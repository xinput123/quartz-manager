package com.xinput.util;

import com.xinput.entity.ScheduleJob;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class TaskUtils {
    public final static Logger logger = Logger.getLogger(TaskUtils.class);

    public static void invokMethod(ScheduleJob scheduleJob) {

        Object object = null;
        Class clazz = null;
        Method method = null;
        if (!StringUtils.isNullOrEmpty(scheduleJob.getBeanClass(), scheduleJob.getMethodName())) {
            try {
                clazz = Class.forName(scheduleJob.getBeanClass());
                object = clazz.newInstance();
                method = clazz.getDeclaredMethod(scheduleJob.getMethodName());
                method.invoke(object);
            } catch (Exception e) {
                //TODO 写日志 或者写库
                System.out.println("Exception : " + scheduleJob.toString());
                e.printStackTrace();
            }

        }

        // TODO 日志或者数据库持久化
        System.out.println("任务名称 = [" + scheduleJob.getJobName() + "]----------启动成功");
        System.out.println(scheduleJob.toString());
    }

    /**
     * 通过反射调用scheduleJob中定义的方法
     *
     * @param scheduleJob
     */
    public static void invokMethod1(ScheduleJob scheduleJob) {
        Object object = null;
        Class clazz = null;

        if (StringUtils.isNotNullOrEmpty(scheduleJob.getBeanClass())) {
            try {
                System.out.println(scheduleJob.getBeanClass());
                clazz = Class.forName(scheduleJob.getBeanClass());
                object = clazz.newInstance();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        if (object == null) {
            logger.error("任务名称 = [" + scheduleJob.getJobName() + "]---------------未启动成功，请检查是否配置正确！！！");
            return;
        }
        clazz = object.getClass();
        Method method = null;
        try {
            method = clazz.getDeclaredMethod(scheduleJob.getMethodName());
        } catch (NoSuchMethodException e) {
            logger.error("任务名称 = [" + scheduleJob.getJobName() + "]---------------未启动成功，方法名设置错误！！！");
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (method != null) {
            try {
                method.invoke(object);
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("任务名称 = [" + scheduleJob.getJobName() + "]----------启动成功");
    }
}
