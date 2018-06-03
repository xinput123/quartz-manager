package com.xinput.entity;

import org.springframework.jdbc.core.RowMapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * 计划任务信息
 */
public class ScheduleJob implements RowMapper<ScheduleJob>, Serializable {
    private static final long serialVersionUID = 3379166326486842752L;

    public static final String STATUS_RUNNING = "1";
    public static final String STATUS_NOT_RUNNING = "0";
    public static final String STATUS_DELETE = "2";

    public static final String CONCURRENT_IS = "1";
    public static final String CONCURRENT_NOT = "0";

    private String jobId;

    /**
     * 任务名称
     */
    private String jobName;

    /**
     * 任务分组
     */
    private String jobGroup;

    /**
     * 任务状态 是否启动任务 0暂停  1启动  2表示已经删除
     */
    private String jobStatus;

    /**
     * cron表达式
     */
    private String cronExpression;

    /**
     * 定时任务描述
     */
    private String description;

    /**
     * 任务是否有状态
     */
    private String isConcurrent;

    /**
     * 任务执行时调用哪个类的方法 包名+类名
     */
    private String beanClass;

    /**
     * 任务调用的方法名
     */
    private String methodName;

    private Date createTime;

    private Date updateTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static String getStatusRunning() {
        return STATUS_RUNNING;
    }

    public static String getStatusNotRunning() {
        return STATUS_NOT_RUNNING;
    }

    public static String getStatusDelete() {
        return STATUS_DELETE;
    }

    public static String getConcurrentIs() {
        return CONCURRENT_IS;
    }

    public static String getConcurrentNot() {
        return CONCURRENT_NOT;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsConcurrent() {
        return isConcurrent;
    }

    public void setIsConcurrent(String isConcurrent) {
        this.isConcurrent = isConcurrent;
    }

    public String getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(String beanClass) {
        this.beanClass = beanClass;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ScheduleJob{" +
                "jobId=" + jobId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", jobName='" + jobName + '\'' +
                ", jobGroup='" + jobGroup + '\'' +
                ", jobStatus='" + jobStatus + '\'' +
                ", cronExpression='" + cronExpression + '\'' +
                ", description='" + description + '\'' +
                ", isConcurrent='" + isConcurrent + '\'' +
                ", beanClass='" + beanClass + '\'' +
                ", methodName='" + methodName + '\'' +
                '}';
    }

    @Override
    public ScheduleJob mapRow(ResultSet rs, int i) throws SQLException {
        ScheduleJob job = new ScheduleJob();
        job.setJobId(rs.getString("job_id"));
        job.setJobName(rs.getString("job_name"));
        job.setJobGroup(rs.getString("job_group"));
        job.setJobStatus(rs.getString("job_status"));
        job.setCronExpression(rs.getString("cron_expression"));
        job.setDescription(rs.getString("description"));
        job.setIsConcurrent(rs.getString("is_concurrent"));
        job.setBeanClass(rs.getString("bean_class"));
        job.setMethodName(rs.getString("method_name"));
        job.setCreateTime(rs.getDate("create_time"));
        job.setUpdateTime(rs.getDate("update_time"));
        return job;
    }
}