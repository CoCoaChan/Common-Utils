package cn.coco.common.commonutil;

import cn.coco.common.commonutil.utils.CrawlerUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class CommonUtilApplicationTests {

    @SneakyThrows
    @Test
    void testCrawlerSimple() {
        CrawlerUtil crawlerUtil = new CrawlerUtil();
        String targetUrl = "https://yurinavi.com/yuri-calendar/";
        List<String> parseResult = crawlerUtil.listTagContent(targetUrl, ".column-3");
        for (String s : parseResult) {
            System.out.println(s);
        }
    }
}
