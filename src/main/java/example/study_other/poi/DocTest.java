package example.study_other.poi;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
public class DocTest {
    @Test
    public void test() {
        String docFile = "/Users/weekend/Desktop/test.doc";

        try {
            FileInputStream inputStream = new FileInputStream(docFile);
            HWPFDocument document = new HWPFDocument(inputStream);


            Range range = document.getRange();
            for (int i = 0; i < range.numParagraphs(); i++) {
                Paragraph paragraph = range.getParagraph(i);
                int numCharacterRuns = paragraph.numCharacterRuns();
                for (int j = 0; j < numCharacterRuns; j++) {
                    CharacterRun run = paragraph.getCharacterRun(j);

                    String text = run.text();
                    if (text.length() > 1) {
                        log.info("text:{}", run.text());
                        run.replaceText(text, "");
                        for (int k = 0; k < text.length(); k++) {
                            String substring = text.substring(k, k + 1);
                            paragraph.insertAfter(substring);
                        }
                    }
                }
            }

            String outputFile = "/Users/weekend/Desktop/new.doc";
            document.write(Files.newOutputStream(Paths.get(outputFile)));

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }


    @Test
    public void test2() throws IOException {

        String inputFile = "/Users/weekend/Desktop/test.doc";
        FileInputStream inputStream = new FileInputStream(inputFile);
        HWPFDocument inputDocument = new HWPFDocument(inputStream);

        String docFile = "/Users/weekend/Desktop/template.doc";
        FileInputStream docStream = new FileInputStream(docFile);
        HWPFDocument docDocument = new HWPFDocument(docStream);
        Range docDocumentRange = docDocument.getRange();


        Range inputRange = inputDocument.getRange();
        for (int i = 0; i < inputRange.numParagraphs(); i++) {
            Paragraph paragraph = inputRange.getParagraph(i);
            int numCharacterRuns = paragraph.numCharacterRuns();
            for (int j = 0; j < numCharacterRuns; j++) {
                CharacterRun run = paragraph.getCharacterRun(j);
                String text = run.text();

                if (text.length() > 1) {
                    log.info("text:{}", run.text());
                    run.replaceText(text, "");
                }
            }

        }

        String outputFile = "/Users/weekend/Desktop/new.doc";
        docDocument.write(Files.newOutputStream(Paths.get(outputFile)));
    }
}
