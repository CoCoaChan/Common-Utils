package cn.coco.common.commonutil.utils;

import cn.coco.common.commonutil.model.AliSmsModel;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.tea.*;
import com.aliyun.dysmsapi20170525.*;
import com.aliyun.dysmsapi20170525.models.*;
import com.aliyun.teaopenapi.*;
import com.aliyun.teaopenapi.models.*;

/**
 * Created With IntelliJ IDEA.
 *
 * @author CoCo
 * @version 1.0
 * @ProjectName common-utils
 * @ClassName SMS$Util
 * @description 手机短信业务工具类
 * @date 2021/06/23/15:05 -- By System Date
 **/

public class SmsAliUtil {

    public static Client aliSmsCreateClient(String accessKeyId, String accessKeySecret) {
        return null;
    }

    public static void aliSendSms(String accessKeyId, String accessKeySecret, AliSmsModel aliSmsModel) throws Exception {
        Config config = new Config();
        // 阿里 SMS KeyId
        config.setAccessKeyId(accessKeyId);
        // 阿里 SMS KeySecret
        config.setAccessKeySecret(accessKeySecret);
        // 访问域名
        config.endpoint = "CoCoChan@1650699017302651.onaliyun.com";
        Client client = new Client(config);
        SendSmsRequest sendSmsRequest = new SendSmsRequest();
        sendSmsRequest.setPhoneNumbers(aliSmsModel.getPhoneNumbers());
        sendSmsRequest.setSignName(aliSmsModel.getSignName());
        sendSmsRequest.setTemplateCode(aliSmsModel.getTemplateCode());
        if (aliSmsModel.getTemplateParam() != null) {
            sendSmsRequest.setTemplateParam(aliSmsModel.getTemplateParam());
        }
        if (aliSmsModel.getSmsUpExtendCode() != null) {
            sendSmsRequest.setSmsUpExtendCode(aliSmsModel.getSmsUpExtendCode());
        }
        if (aliSmsModel.getOutId() != null) {
            sendSmsRequest.setOutId(aliSmsModel.getOutId());
        }


    }
}
