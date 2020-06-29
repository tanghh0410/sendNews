package com.test.controller;

import com.test.service.WeiMessageService;
import com.test.wechat.SendApplicationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tanghh on 2019/9/1
 */
@RestController
public class TestController {

    @Autowired
    private WeiMessageService weiMessageService;


    @GetMapping(value = "/testSendNews")
    public void testSendNews(){
        //1.发送文本消息
//        SendApplicationMessage message = new SendApplicationMessage();
//        message.testSendText();
        //2.发送图片消息
        weiMessageService.sendImageMessage("D:/project/csdn/有钱.gif","image");
    }
}
