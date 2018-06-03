package com.xinput.service;

import com.xinput.entity.ScheduleJob;
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

    /**
     * 查找所有schedule task
     *
     * @return
     */
    public List<ScheduleJob> scheduleJobs() {
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
}
