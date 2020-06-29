package com.test.util;

import com.alibaba.fastjson.JSONObject;
import com.test.wechat.SendRequest;

/**
 * 企业微信参数配置类
 *
 * @Author: tanghh18
 * @Date: 2019/8/30 16:21
 */
public class QiWeiParametersUtil {
    /**
     * 1.获取AccessToken
     */
    public static String getAccessTokenUrl = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid={corpid}&corpsecret={corpsecret}";

    /**
     * 发送企业微信AccessToken
     */
    public static String sendAccessTokenUrl = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=ACCESS_TOKEN";

    /**
     * 上传临时文件素材
     * @param
     * @return
     */
    public static String uploadMediaUrl="https://qyapi.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
    /**
     * 企业ID
     */
    public final static String corpId = "******";

    /**
     * 企业应用的id，整型。可在应用的设置页面查看(yes)项目测试（ebo0.2版本）
     */
    public final static int agentId = 0;
    /**
     * 应用secret
     */
    public static String secret = "**********";

    /**
     * 获得各种access_token
     *
     * @return
     */
    public static String getAccessToken() {
        String url = getAccessTokenUrl.replace("{corpid}", corpId).replace("{corpsecret}", secret);
        JSONObject departmentJson = SendRequest.sendGet(url);
        return departmentJson.getString("access_token");
    }
}
