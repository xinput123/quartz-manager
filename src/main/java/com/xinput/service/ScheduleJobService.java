package com.xinput.service;

import com.xinput.entity.ScheduleJob;
import com.xinput.task.QuartzJobFactory;
import com.xinput.task.QuartzJobFactoryDisallowConcurrentExecution;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xinput
 * @date 2018-06-02 16:38
 */
@Service
public class ScheduleJobService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private Scheduler scheduler;

    /**
     * 查找所有schedule task
     *
     * @return
     */
    public List<ScheduleJob> allScheduleJobs() {
        String sql = "SELECT * FROM schedule_task WHERE 1=1;";
        return jdbcTemplate.query(sql, new ScheduleJob());
    }

    /**
     * 查找指定状态schedule task
     *
     * @return
     */
    public List<ScheduleJob> scheduleJobs(String status) {
        String sql = "SELECT * FROM schedule_task WHERE job_status = ?";
        return jdbcTemplate.query(sql, new ScheduleJob(), status);
    }

    /**
     * 查找定时任务
     *
     * @param taskId
     * @return
     */
    public ScheduleJob scheduleJob(String taskId) {
        String sql = "SELECT * FROM schedule_task WHERE job_id = ? limit 1";

        List<ScheduleJob> jobs = jdbcTemplate.query(sql, new ScheduleJob(), taskId);
        if (jobs == null || jobs.size() == 0) {
            return null;
        }

        return jobs.get(0);
    }

    /**
     * 根据id修改
     *
     * @param taskId
     * @param status
     * @return
     */
    public int updateScheduleJobStatus(String taskId, String status) {
        ScheduleJob scheduleJob = scheduleJob(taskId);
        if (null == scheduleJob || status.equals(scheduleJob.getJobStatus())) {
            return 0;
        }

        String updteJobStatusSql = "UPDATE schedule_task SET job_status = ? WHERE job_id = ?";

        return jdbcTemplate.update(updteJobStatusSql, status, taskId);
    }

    /**
     * 修改cron
     */
    public int updateScheduleJobStatu(ScheduleJob job) {
        ScheduleJob scheduleJob = scheduleJob(job.getJobId());
        if (null == scheduleJob || scheduleJob.getCronExpression().equals(scheduleJob.getCronExpression())) {
            return 0;
        }
        String updteJobStatusSql = "UPDATE schedule_task SET cron_expression = ? WHERE job_id = ?";

        return jdbcTemplate.update(updteJobStatusSql, job.getCronExpression(), job.getJobId());
    }

    /**
     * 添加任务
     *
     * @param job
     * @throws SchedulerException
     */
    public void addJob(ScheduleJob job) throws SchedulerException {
        if (job == null || !ScheduleJob.STATUS_RUNNING.equals(job.getJobStatus())) {
            return;
        }

        TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

        // 不存在，创建一个
        if (null == trigger) {
            Class clazz = ScheduleJob.CONCURRENT_IS.equals(job.getIsConcurrent()) ? QuartzJobFactory.class : QuartzJobFactoryDisallowConcurrentExecution.class;
            JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(job.getJobName(), job.getJobGroup()).build();
            jobDetail.getJobDataMap().put("scheduleJob", job);
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
            trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup()).withSchedule(scheduleBuilder).build();
            scheduler.scheduleJob(jobDetail, trigger);
        } else {
            // Trigger已存在，那么更新相应的定时设置
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
            // 按新的cronExpression表达式重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            // 按新的trigger重新设置job执行
            scheduler.rescheduleJob(triggerKey, trigger);
        }
    }


}
