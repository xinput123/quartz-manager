package com.xinput.task;

import com.xinput.entity.ScheduleJob;
import com.xinput.service.ScheduleJobService;
import com.xinput.util.SpringContextHolder;

import java.util.List;

/**
 * @author xinput
 * @date 2018-06-03 09:27
 */
public class TaskSchedule {

    private ScheduleJobService scheduleJobService;

    public void run1() {
        System.out.println("run1 开始执行。。。");
        if (scheduleJobService == null) {
            scheduleJobService = SpringContextHolder.getBean(ScheduleJobService.class);
        }
        try {
            List<ScheduleJob> lists = scheduleJobService.allScheduleJobs();
            System.out.println("run1 执行完成。。。数量：" + lists.size());
        } catch (Exception e) {
            System.out.println("run1 执行失败。。。");
            e.printStackTrace();
        }
    }

    public void run2() {
        System.out.println("run2 开始执行。。。");
    }

    public void run3() {
        System.out.println("run3 开始执行。。。");
    }
}
