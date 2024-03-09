package example.study_other.poi;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
public class Excel03Test {

    @Test
    public void readExcel() throws Exception {
        FileInputStream inputStream = new FileInputStream("./test.xls"); // 打开文件流
        Workbook workbook = new HSSFWorkbook(inputStream); // 打开工作薄
        Sheet sheet = workbook.getSheetAt(0);   // 获取第一个工作表
        Row row = sheet.getRow(0);  // 获取第一行
        Cell cell = row.getCell(0); // 获取第一列
        log.info(cell.getStringCellValue()); // 获取单元格的值
        inputStream.close();    // 关闭流
    }

    @Test
    public void writeExcel() throws Exception {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("sheet名称1");
        for (int rowNum = 0; rowNum < 10; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue("单元格" + (rowNum + 1) + "-" + (cellNum + 1));
            }
        }
        OutputStream outputStream = Files.newOutputStream(Paths.get("./test.xls")); // 创建输出流
        workbook.write(outputStream);
        outputStream.close();   // 关闭流
        log.info("写入完成");
    }
}
