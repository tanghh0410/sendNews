package com.test.model;

import lombok.Data;

/**
 * Created by tanghh on 2019/8/30
 */
public @Data
class ImageMessage {
    private String touser;
//    private String toparty;
//    private String totag;
    private String msgtype;
    private Integer agentid;
    private Image image;
    private Integer safe;
}
