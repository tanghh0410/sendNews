package com.test.model;

import lombok.Data;

/**
 * 语音消息
 * @Author: tanghh18
 * @Date: 2019/8/30 17:04
 */
public @Data
class VoiceMessage {
    private String touser;
    private String toparty;
    private String totag;
    private String msgtype;
    private Integer agentid;
    private Voice voice;
}
