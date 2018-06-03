package com.xinput.controller;

import com.xinput.entity.ScheduleJob;
import com.xinput.service.ScheduleJobService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xinput
 * @date 2018-06-02 22:39
 */
@RestController
public class ScheduleController {

    @Autowired
    private ScheduleJobService scheduleJobService;

    /**
     * 增加任务
     *
     * @return
     */
    @RequestMapping(value = "/scheduleJobs", method = RequestMethod.POST)
    public void scheduleJobs(@RequestBody ScheduleJob job) {
        //1、保存到数据库

        // 2、
        try {
            scheduleJobService.addJob(job);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有任务
     *
     * @return
     */
    @RequestMapping(value = "/scheduleJobs", method = RequestMethod.GET)
    public List<ScheduleJob> scheduleJobs() {
        return scheduleJobService.allScheduleJobs();
    }

    @RequestMapping(value = "/scheduleJobs/{id}", method = RequestMethod.GET)
    public ScheduleJob scheduleJobs(@PathVariable("id") String id) {
        return scheduleJobService.scheduleJob(id);
    }

    /**
     * 暂停
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/scheduleJobs/{id}/pause", method = RequestMethod.GET)
    public int pauseScheduleJobs(@PathVariable("id") String id) {
        return updateScheduleStatus(id, "0");
    }

    /**
     * 开始
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/scheduleJobs/{id}/resume", method = RequestMethod.GET)
    public int resumeScheduleJobs(@PathVariable("id") String id) {
        return updateScheduleStatus(id, "1");
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/scheduleJobs/{id}/delete", method = RequestMethod.GET)
    public int deleteScheduleJobs(@PathVariable("id") String id) {
        return updateScheduleStatus(id, "2");
    }


    private int updateScheduleStatus(String taskId, String status) {
        ScheduleJob scheduleJob = scheduleJobService.updateScheduleJobStatus(taskId, status);
        try {
            scheduleJobService.updateJobStatus(scheduleJob, status);
        } catch (SchedulerException e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

}
