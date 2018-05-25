DROP TABLE IF EXISTS `schedule_task`;

CREATE TABLE `schedule_task` (
  `job_id` varchar(50) NOT NULL DEFAULT '',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `job_name` varchar(50) DEFAULT NULL,
  `job_group` varchar(50) DEFAULT NULL,
  `job_status` varchar(2) DEFAULT NULL COMMENT '0:暂停 1: 启动 2:删除',
  `cron_expression` varchar(20) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `bean_class` varchar(100) NOT NULL DEFAULT '',
  `method_name` varchar(50) DEFAULT NULL,
  `is_concurrent` varchar(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `schedule_task` (`job_id`, `create_time`, `update_time`, `job_name`, `job_group`, `job_status`, `cron_expression`, `description`, `bean_class`, `method_name`, `is_concurrent`)
VALUES
	('1','2018-01-01 00:00:00','2018-05-22 07:36:13','测试run1','测试group1','0','0/2 * * * * ?',NULL,'com.precisource.task.TaskSchedule','run1','1'),
	('2','2018-01-01 00:00:01','2018-05-22 07:41:33','测试run2','测试group2','0','0/10 * * * * ?',NULL,'com.precisource.task.TaskSchedule','run2','1'),
	('5b03d8cf29243e32fae244b5','2018-05-22 08:46:07','2018-05-22 10:49:30','测试添加任务','测试任务分组','0','0/2 * * * * ?','测试描述','com.precisource.task.TaskSchedule','run3','1'),
	('5b03f1d729243e353d742baf','2018-05-22 10:32:55','2018-05-23 03:29:55','测试添加任务1','测试任务分组','1','0/10 * * * * ?','测试描述','com.precisource.task.TaskSchedule','runAdd','1');
