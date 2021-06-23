package cn.coco.common.commonutil.utils;

import cn.coco.common.commonutil.constant.RegexAttrConstant;

import java.util.regex.Pattern;

/**
 * Created With IntelliJ IDEA.
 *
 * @author CoCo
 * @version 1.0
 * @ProjectName common-utils
 * @ClassName RegexUtil
 * @description 正则表达式工具类
 * @date 2021/06/23/15:04 -- By System Date
 **/

public class RegexUtil {
    /**
     * 验证手机格式
     *
     * @param checkStr ;
     * @return ;
     */
    public static boolean isMobile(String checkStr) {
        return Pattern.matches(RegexAttrConstant.MOBILE_PHONE_NUMBER, checkStr);
    }

    /**
     * 验证邮箱格式
     *
     * @param checkStr ;
     * @return ;
     */
    public static boolean isEmail(String checkStr) {
        return Pattern.matches(RegexAttrConstant.EMAIL_ADDRESS, checkStr);
    }

    public static boolean isChineseId(String checkStr) {
        Integer[] lenParam = {15, 16, 17, 18};
        if (checkStr.length() == lenParam[0]) {

        }
        if (checkStr.length() == lenParam[1]) {

        }
        if (checkStr.length() == lenParam[2]) {

        }
        if (checkStr.length() == lenParam[3]) {

        }
        return false;
    }

    public static boolean isOnlyChineseName() {

        return false;
    }
}
