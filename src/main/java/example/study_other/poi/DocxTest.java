package example.study_other.poi;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;

/**
 * docx测试
 *
 * @author weekend
 * @date 2024/04/18
 */
@Slf4j
public class DocxTest {


    @Test
    public void test() {
        String docFile = "/Users/weekend/Desktop/test.docx";
        try (FileInputStream inputStream = new FileInputStream(new File(docFile))) {
            XWPFDocument document = new XWPFDocument(inputStream);

            for (XWPFParagraph paragraph : document.getParagraphs()) {
                ArrayList<XWPFRun> arrayList = new ArrayList<>();

                // 优化：避免在循环中重复获取size
                int size = paragraph.getRuns().size();
                for (int i = 0; i < size; i++) {
                    XWPFRun run = paragraph.getRuns().get(i);
                    String text = run.text();
                    for (int tIndex = 0; tIndex < text.length(); tIndex++) {
                        String word = text.substring(tIndex, tIndex + 1);
                        XWPFRun newRun = paragraph.createRun();
                        BeanUtils.copyProperties(newRun, run);
                        newRun.setText(word);

                        // 对字体设置逻辑进行封装
                        if ("谢".equals(word) || "测".equals(word)) {
                            log.info("匹配成功");
                            newRun.getCTR().getRPr().addNewColor().setVal("FF0000");
                        }
                        arrayList.add(newRun);
                    }
                }
                for (int i = size; i > 0; i--) {
                    XWPFRun run = paragraph.getRuns().get(i - 1);
                    if (run instanceof XWPFHyperlinkRun || run instanceof XWPFFieldRun) {
                        continue;
                    }
                    paragraph.removeRun(i - 1);
                }


                List<CTHyperlink> hyperlinkList = paragraph.getCTP().getHyperlinkList();
                CTHyperlink[] array = hyperlinkList.toArray(new CTHyperlink[0]);
                for (int i = 0; i < array.length; i++) {
                    paragraph.getCTP().removeHyperlink(0);
                }

            }

            String outputFile = "/Users/weekend/Desktop/new.docx";
            document.write(Files.newOutputStream(Paths.get(outputFile)));
        } catch (Exception e) {
            // 优化：使用日志记录异常信息
            log.error("Exception occurred while processing the document", e);
        }
    }


}
