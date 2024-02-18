package example.study_other.apache_commons;

import example.util.PathUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

/**
 * @author weekend
 * @date 2024/02/18
 */
@Slf4j
public class IOTest {
    @Test
    public void test() throws Exception {
        // 1．读取Stream
        // 标准代码：
        InputStream in = new URL("https://www.baidu.com").openStream();
        InputStreamReader inR = new InputStreamReader(in);
        BufferedReader buf = new BufferedReader(inR);
        String line;
        while ((line = buf.readLine()) != null) {
            log.info(line);
        }
        in.close();

        // 使用IOUtils
        InputStream in2 = new URL("https://www.baidu.com").openStream();
        try {
            log.info(IOUtils.toString(in2));
        } finally {
            IOUtils.closeQuietly(in);
        }

        // 2．读取文件
        File file = new File( PathUtil.getPath() + "logback.xml");
        List lines = FileUtils.readLines(file, "UTF-8");
        log.info(lines.toString());

        // 3．察看剩余空间
        long freeSpace = FileSystemUtils.freeSpace("/");
        log.info(""+freeSpace);
    }
}
