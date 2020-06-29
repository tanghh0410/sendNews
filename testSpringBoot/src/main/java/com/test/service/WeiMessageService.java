package com.test.service;

/**
 * @Author tanghh
 * @Date 2020/6/29 15:41
 */
public interface WeiMessageService {
    /**
     * 发送图片消息
     * @param filePath
     * @param type
     */
    void sendImageMessage(String filePath,String type);
}
