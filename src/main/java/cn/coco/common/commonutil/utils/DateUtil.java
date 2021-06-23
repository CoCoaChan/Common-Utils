package cn.coco.common.commonutil.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created With IntelliJ IDEA.
 *
 * @author CoCo
 * @version 1.0
 * @ProjectName common-utils
 * @ClassName DateUtil
 * @description 时间工具类
 * @date 2021/06/23/15:05 -- By System Date
 **/

@Slf4j
public class DateUtil {
    /**
     * 获取网络时间 默认为 NTSC (中国科学院国家授时中心)
     *
     * @return 通过访问网络时间返回一个时间格式字符串;
     * @date 2021/6/23
     */
    public static Date getByNTSC() throws IOException {
        try {
            // 取得资源对象
            URL url = new URL("http://www.ntsc.ac.cn");
            // 生成连接对象
            URLConnection uc = url.openConnection();
            // 发出连接
            uc.connect();
            // 读取网站日期时间
            long ld = uc.getDate();
            // 转换为标准时间对象
            return new Date(ld);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过网址获取网络时间
     *
     * @param urlStr 指定网址
     * @return 通过访问网络时间返回一个时间格式字符串
     * @date 2021/6/23
     */
    public static Date getByUrl(String urlStr) throws IOException {
        try {
            // 取得资源对象
            URL url = new URL(urlStr);
            // 生成连接对象
            URLConnection uc = url.openConnection();
            // 发出连接
            uc.connect();
            // 读取网站日期时间
            long ld = uc.getDate();
            // 转换为标准时间对象
            Date date = new Date(ld);
            return date;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取 Local.CHINA 时间 并且格式化
     *
     * @param format = "yyyy-MM-dd HH:mm:ss" / format = "yyyy-MM-dd"  -- = -- 指定的格式化字符串
     * @return 一个时间格式的字符串;
     * @date 2021/6/23
     */
    public static String getByLocal(String format) {
        // 输出北京时间
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Date date = new Date();
        return sdf.format(new Date());
    }

    /**
     * @param format 指定的格式化字符串;
     * @return ;
     * @date 2021/6/23
     */
    public static String getByCalendar(String format) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getDefault());
        log.info("默认时间区 : " + TimeZone.getDefault());
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(calendar.getTime());
    }

}
