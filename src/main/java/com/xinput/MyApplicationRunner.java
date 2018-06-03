package com.xinput;

import com.xinput.entity.ScheduleJob;
import com.xinput.service.ScheduleJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    private ScheduleJobService scheduleJobService;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println("开始加载定时任务。。。。");
        // 这里获取任务信息数据
        List<ScheduleJob> jobList = scheduleJobService.allScheduleJobs();
        System.out.println(jobList.size());
        for (ScheduleJob job : jobList) {
            System.out.println(job.toString());

        }
    }
}
