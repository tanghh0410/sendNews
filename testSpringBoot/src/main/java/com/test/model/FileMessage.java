package com.test.model;

import lombok.Data;

/**
 * Created by tanghh on 2019/8/30
 */
public @Data
class FileMessage {
    private String touser;
    private String toparty;
    private String totag;
    private String msgtype;
    private File file;
    private Integer safe=0;
}
