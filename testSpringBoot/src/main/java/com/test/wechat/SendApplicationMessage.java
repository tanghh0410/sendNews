package com.test.wechat;

import com.alibaba.fastjson.JSON;
import com.test.model.Image;
import com.test.model.ImageMessage;
import com.test.model.Text;
import com.test.model.TextMessage;
import com.test.util.QiWeiParametersUtil;

/**
 * 测试发送应用消息
 *
 * @Author: tanghh18
 * @Date: 2019/8/30 16:18
 */
public class SendApplicationMessage {
    /**
     * 发送文本消息
     */
    public void testSendText() {
        TextMessage textMessage = new TextMessage();
        textMessage.setTouser("@all");
        textMessage.setMsgtype("text");
        textMessage.setAgentid(QiWeiParametersUtil.agentId);

        Text text = new Text();
        text.setContent("Hello world!");
        textMessage.setText(text);
        //将对象转json字符串
        String textJson = JSON.toJSONString(textMessage);
        //获取AccessToken
        String accessToken = QiWeiParametersUtil.getAccessToken();
        String sendUrl = QiWeiParametersUtil.sendAccessTokenUrl.replace("ACCESS_TOKEN", accessToken);
        //发送post请求
        SendRequest.sendPost(sendUrl, textJson);


    }



}
