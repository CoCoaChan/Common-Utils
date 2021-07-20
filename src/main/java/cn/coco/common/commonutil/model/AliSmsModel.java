package cn.coco.common.commonutil.model;

import io.netty.channel.nio.AbstractNioByteChannel;
import lombok.Data;

/**
 * Created With IntelliJ IDEA.
 *
 * @author CoCo
 * @version 1.0
 * @ProjectName common-util
 * @ClassName AliSMS$System
 * @description 阿里云SMS短信系统服务
 * @date 2021/07/20/15:21 -- By System Date
 **/
@Data
public class AliSmsModel {

    public AliSmsModel() {
    }

    public AliSmsModel(String phoneNumbers, String signName, String templateCode) {
        this.phoneNumbers = phoneNumbers;
        this.signName = signName;
        this.templateCode = templateCode;
    }

    /**
     * 接收短信的手机号码
     */
    private String phoneNumbers;
    /**
     * 短信签名名称
     */
    private String signName;
    /**
     * 短信模板ID
     */
    private String templateCode;
    /**
     * 短信模板变量对应的实际值
     */
    private String templateParam;
    /**
     * T上行短信扩展码
     */
    private String smsUpExtendCode;
    /**
     * 外部流水扩展字段
     */
    private String outId;

}
