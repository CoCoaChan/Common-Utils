package cn.coco.common.commonutil.constant;

/**
 * Created With IntelliJ IDEA.
 *
 * @author CoCo
 * @version 1.0
 * @ProjectName common-utils
 * @ClassName RegexAttrConstant
 * @description 常用的正则表达式属性
 * @date 2021/06/23/16:00 -- By System Date
 **/
public class RegexAttrConstant {

    /**
     *
     */
    public static final String MOBILE_PHONE_NUMBER2 = ".*^1(3([0-35-9]\\d|4[1-8])|4[14-9]\\d|5([0-35689]\\d|7[1-79])|66\\d|7[2-35-8]\\d|8\\d{2}|9[13589]\\d)\\d{7}$.*";

    /**
     * 国内电话号码正则表达式
     * https://learnku.com/articles/31543
     */
    public static final String MOBILE_PHONE_NUMBER = "*^1(3\\d|4[5-9]|5[0-35-9]|6[2567]|7[0-8]|8\\d|9[0-35-9])\\d{8}$*";

    /**
     * 邮箱正则表达式
     */
    public static final String EMAIL_ADDRESS = ".*^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$.*";

    /**
     * People's Republic of China ID
     */
    public static final String CHINESE_ID_CARD = "/^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$/";
}
