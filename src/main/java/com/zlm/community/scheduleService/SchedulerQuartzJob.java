package com.zlm.community.scheduleService;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Auther: zhuluming
 * @Email: Luming.Zhu@paat.com
 * @Date: 2019/7/1 12:58
 * @Description:
 */
public class SchedulerQuartzJob  implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("开始："+System.currentTimeMillis());
    }
}
