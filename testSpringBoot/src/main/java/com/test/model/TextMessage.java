package com.test.model;

import lombok.Data;

/**
 * 功能描述: 文本消息
 * @Author: tanghh18
 * @Date: 2019/8/30 16:55
 */
public @Data
class TextMessage {
    private String touser;
//    private String toparty;
//    private String totag;
    private String msgtype;
    private Integer agentid;
    private Text text;
//    private Integer safe = 0;
//    private Integer enable_id_trans=0;

}
