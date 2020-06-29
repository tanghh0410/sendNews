package com.test.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.test.model.Image;
import com.test.model.ImageMessage;
import com.test.util.QiWeiParametersUtil;
import com.test.util.QiYeWeiUtil;
import com.test.wechat.SendRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @Author tanghh
 * @Date 2020/6/29 15:41
 */
@Service
public class WeiMessageServiceImpl implements WeiMessageService {

    private Logger logger = LoggerFactory.getLogger(WeiMessageServiceImpl.class);

    @Override
    public void sendImageMessage(String filePath, String type) {
        //1.将获取到的图片上传到企业微信服务器
        JSONObject resultJsonObject = uploadTempMaterial(filePath,"image");
        String mediaId = resultJsonObject.getString("media_id");
        //将图片发给用户(企业微信或者是微信) 微信用户如果在24小时之内没有与微信公众平台交互，微信用户将接收不到微信公众号的消息
        String accessToken = QiWeiParametersUtil.getAccessToken();
        //2.组装图片消息
        //2.1.创建图片消息对象
        ImageMessage sendImgMessage = new ImageMessage();
        //2.2非必需 发送用户id
        sendImgMessage.setTouser("TangHuiHong");
        //2.3 发送类型
        sendImgMessage.setMsgtype(type);
        sendImgMessage.setAgentid(QiWeiParametersUtil.agentId);

        Image image = new Image();
        image.setMedia_id(mediaId);
        sendImgMessage.setImage(image);
        //2.获取请求的url
        String sendMessage_url = QiWeiParametersUtil.sendAccessTokenUrl.replace("ACCESS_TOKEN", accessToken);
        String json = JSON.toJSONString(sendImgMessage);
        //3.发送消息：调用业务类，发送消息
        JSONObject jsonObject = SendRequest.sendPost(sendMessage_url, json);
        //4.错误消息处理
        if (null != jsonObject) {
            if (0 != jsonObject.getIntValue("errcode")) {
                logger.error("发送消息失败 errcode:{} errmsg:{}", jsonObject.getIntValue("errcode"), jsonObject.getString("errmsg"));
            }
        }
    }

    /**
     * 企业微信上传临时素材
     * 文件上传并获取上传文件的mediaId
     * type   媒体文件类型，分别有图片（image）、语音（voice）、视频（video），普通文件(file)
     *
     * @param
     * @return
     */
    public JSONObject uploadTempMaterial(String filePath, String type) {
        //1.创建本地文件
        File file = new File(filePath);
        String accessToken = QiWeiParametersUtil.getAccessToken();
        //2.拼接请求url
        String uploadTempMaterialUrl = QiWeiParametersUtil.uploadMediaUrl.replace("ACCESS_TOKEN", accessToken)
                .replace("TYPE", type);
        //3.调用接口，发送请求，上传文件到微信服务器
        String result = QiYeWeiUtil.httpRequest(uploadTempMaterialUrl, file);
        //4.json字符串转对象：解析返回值，json反序列化
        result = result.replaceAll("[\\\\]", "");
        JSONObject resultJSON = JSONObject.parseObject(result);

        //5.返回参数判断
        if (resultJSON != null) {
            if (resultJSON.get("media_id") != null) {
                System.out.println("上传" + type + "永久素材成功");
                return resultJSON;
            } else {
                System.out.println("上传" + type + "永久素材失败");
            }
        }
        return resultJSON;
    }



}
