package cn.coco.common.commonutil.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created With IntelliJ IDEA.
 *
 * @author CoCo
 * @version 1.0
 * @ProjectName common-utils
 * @ClassName CrawlerUtil
 * @description 爬虫工具类 (简单的实现)
 * @date 2021/06/23/15:06 -- By System Date
 **/

@Slf4j
public class CrawlerUtil {
    List<String> list = null;
    /**
     * HttpClient 实例
     */
    CloseableHttpClient httpClient = null;
    CloseableHttpResponse response = null;

    public String parseHtmlContent(String url) throws IOException {
        try {
            // 创建httpclient实例
            httpClient = HttpClients.createDefault();
            // 创建 HttpGet 实例
            HttpGet httpGet = new HttpGet(url);
            // 执行get请求
            response = httpClient.execute(httpGet);
//        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity httpEntity = response.getEntity();
            // 获取返回实体
            return EntityUtils.toString(httpEntity, "utf8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 获取指定标签文本内容
     *
     * @param url             ;
     * @param searchCondition ;
     * @return ;
     * @throws IOException ;
     */
    public List<String> listTagContent(String url, String searchCondition) throws IOException {
        list = new ArrayList<>();
        try {
            // 创建HttpClient实例
            httpClient = HttpClients.createDefault();
            // 创建 HttpGet 实例
            HttpGet httpGet = new HttpGet(url);
            // 执行get请求
            response = httpClient.execute(httpGet);
//        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity httpEntity = response.getEntity();
            // 获取返回实体
            String content = EntityUtils.toString(httpEntity, "utf8");
            // 解析网页 得到文档对象
            Document document = Jsoup.parse(content);
            // 获取指定的标签
            Elements elements = document.select(searchCondition);
            for (Element element : elements) {
                log.info(element.attr("src"));
                if (!"".equals(element.attr("src"))) {
                    list.add(element.attr("src"));
                }
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            response.close();
            httpClient.close();
        }
    }


    public List<String> listTagLink(String url, String searchCondition) throws IOException {
        list = new ArrayList<>();
        try {
            // 创建HttpClient实例
            httpClient = HttpClients.createDefault();
            // 创建 HttpGet 实例
            HttpGet httpGet = new HttpGet(url);
            // 执行get请求
            response = httpClient.execute(httpGet);
//        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity httpEntity = response.getEntity();
            // 获取返回实体
            String content = EntityUtils.toString(httpEntity, "utf8");
            // 解析网页 得到文档对象
            Document document = Jsoup.parse(content);
            // 获取指定的标签
            Elements elements = document.select(searchCondition);
            for (Element element : elements) {
                log.info(element.text());
                if (!"".equals(element.text())) {
                    list.add(element.text());
                }
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            response.close();
            httpClient.close();
        }
    }

    public Integer downloadLinkImages(String url, String searchCondition, String downloadPath) throws IOException {
        List<String> listImages = this.listTagLink(url, searchCondition);
        try {
            Integer count = null;
            for (int i = 0; i < listImages.size(); i++) {
                String imageUrl = listImages.get(i);

                // 再发请求最简单了，并由于该链接是没有 https:开头的，得人工补全 ✔
                HttpGet pictureHttpGet = new HttpGet("https:" + url);
                CloseableHttpResponse pictureResponse = httpClient.execute(pictureHttpGet);
                HttpEntity pictureEntity = pictureResponse.getEntity();
                InputStream inputStream = pictureEntity.getContent();

                // 使用 common-io 下载图片到本地，注意图片名不能重复 ✔
                FileUtils.copyToFile(inputStream, new File(downloadPath + i + ".jpg"));
                pictureResponse.close(); // pictureResponse关闭
                count = i;
            }
            return count;
        } catch (IOException | UnsupportedOperationException e) {
            e.printStackTrace();
            return null;
        } finally {
            response.close();
            httpClient.close();
        }
    }
}
