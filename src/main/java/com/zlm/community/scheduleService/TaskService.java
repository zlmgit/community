package com.zlm.community.scheduleService;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: zhuluming
 * @Email: Luming.Zhu@paat.com
 * @Date: 2019/6/27 20:47
 * @Description:
 */
//@Service
@EnableScheduling
public class TaskService {
    @Scheduled(cron = "*/5 * * * * ?")
    public void task1(){
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "    " + Thread.currentThread().getName() + "    任务一启动");
        //Thread.sleep(10000);
        //System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "    " + Thread.currentThread().getName() + "    任一结束");

    }

    @Scheduled(cron = "*/5 * * * * ?")
    public void task2(){
        System.err.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "    " + Thread.currentThread().getName() + "    任务二启动");
        //Thread.sleep(10000);// 这里时间设置长一点，假设任务长时间阻塞
        //System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "    " + Thread.currentThread().getName() + "    任二结束");
    }
}
