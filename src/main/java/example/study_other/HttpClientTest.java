package example.study_other;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.nio.charset.StandardCharsets;

/**
 * @author weekend
 */
public class HttpClientTest {
    private static final Logger logger = LoggerFactory.getLogger(HttpClientTest.class);

    @Test
    public void test01() {
        String post = HttpClientTest.doPost("https://www.baidu.com");
        logger.info(post);
    }

    public static String doPost(String url) {
        String result = "";
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            URIBuilder builder = new URIBuilder(url);
            builder.addParameter("aa", "bb");
            URI uri = builder.build();

            HttpPost request = new HttpPost(uri);

            request.setConfig(RequestConfig.custom()
                    .setConnectionRequestTimeout(5000) // 请求超时时间
                    .setConnectTimeout(5000) // 连接超时时间
                    .setSocketTimeout(5000) // 响应超时时间
                    .build());

            response = client.execute(request);
            if (response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
            }
        } catch (Exception e) {
            logger.error("request err: ", e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                client.close();
            } catch (Exception e) {
                logger.error("response close err: ", e);
            }
        }
        return result;
    }

}