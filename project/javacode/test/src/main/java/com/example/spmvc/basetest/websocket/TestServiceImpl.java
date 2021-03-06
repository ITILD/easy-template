package com.example.spmvc.basetest.websocket;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TestServiceImpl
 *
 * @author Wangxu
 * @date 2022/4/14
 */
@Service
@EnableScheduling
public class TestServiceImpl {

    //打印时间

    /**
     * 广播
     */
    @Scheduled(fixedRate=5000) //1000毫秒执行一次
    public  void  printTime(){

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String date = dateFormat.format(new Date());
        WebSocketServer.sendInfo(date,"10");
        System.out.println(date);
    }

}
