package com.test.model;

import lombok.Data;

/**
 * 视频消息类
 * @Author: tanghh18
 * @Date: 2019/8/30 18:24
 */
public @Data
class VideoMessage {
    private String touser;
    private String toparty;
    private String totag;
    private String msgType;
    private Integer agentid;
    private Video video;
    private Integer safe=0;
}
