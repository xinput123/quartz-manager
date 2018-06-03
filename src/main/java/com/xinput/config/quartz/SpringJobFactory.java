package com.xinput.config.quartz;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * 解决Job中注入Spring Bean为null的问题
 *
 * @author xinput
 * @date 2018-06-02 23:07
 */
@Component
public class SpringJobFactory extends AdaptableJobFactory {
    /**
     * 这个对象Spring会帮我们自动注入进来,也属于Spring技术范畴.
     */
    @Autowired
    private AutowireCapableBeanFactory capableBeanFactory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        //调用父类的方法
        Object jobInstance = super.createJobInstance(bundle);
        //进行注入
        capableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}
