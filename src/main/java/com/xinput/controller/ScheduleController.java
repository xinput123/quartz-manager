package com.xinput.controller;

import com.xinput.entity.ScheduleJob;
import com.xinput.service.ScheduleJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * 查询所有任务
     *
     * @return
     */
    @RequestMapping(value = "/scheduleJobs")
    public List<ScheduleJob> scheduleJobs() {
        return scheduleJobService.allScheduleJobs();
    }


}
