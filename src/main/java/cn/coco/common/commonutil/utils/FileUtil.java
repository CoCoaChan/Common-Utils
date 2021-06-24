package cn.coco.common.commonutil.utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 * Created With IntelliJ IDEA.
 *
 * @author CoCo
 * @version 1.0
 * @ProjectName common-util
 * @ClassName FileUtil
 * @description 关于文件的操作
 * @date 2021/06/24/2:51 -- By System Date
 **/
@MultipartConfig
public class FileUtil {
    /**
     * 建目录 | 若存在则忽略
     */
    public void mkdir(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

    }

    public static Boolean isExist(String realPath) {
        return new File("projectRealPath" + realPath).exists();
    }

    /**
     * 删除文件
     *
     * @param path 路径;
     */
    public static void deleteFile(String path) {
        File file = new File("projectRealPath" + path);
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     * 文件上传
     *
     * @param request  请求对象 ;
     * @param partName 前台表项值;
     * @param path     由业务层拼接的真实路径
     * @return ;
     */
    public static Boolean partFileUpload(HttpServletRequest request, String partName, String path) throws IOException {
        try {
            Part part = request.getPart(partName);
            path = "ConfigurationConstant.PROJECT_PATH" + path;
            part.write(path);
            return true;
        } catch (IOException | ServletException e) {
            e.printStackTrace();
            return false;
        }
    }
}
