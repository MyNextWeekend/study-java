package example.study_other.poi;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
public class Excel07Test {
    @Test
    public void readExcel() throws Exception {
        String xlsxFile = "/Users/weekend/Desktop/test.xlsx";
        FileInputStream inputStream = new FileInputStream(xlsxFile);
        // 打开工作薄
        Workbook workbook = new XSSFWorkbook(inputStream);
        for (Sheet rows : workbook) {
            for (Row row : rows) {
                for (Cell cell : row) {
                    cell.setCellType(CellType.STRING);
                    log.info("cell:{}", cell.getStringCellValue());
                    if ("324".equals(cell.getStringCellValue())){
                        // 创建一个新的RichTextString对象
                        RichTextString richText = workbook.getCreationHelper().createRichTextString(cell.getStringCellValue());
                        // 创建一个红色字体样式
                        Font redFont = workbook.createFont();
                        redFont.setColor(IndexedColors.RED.getIndex());

                        richText.applyFont(redFont);
                        cell.setCellValue(richText);
                    }
                }
            }
        }

        String outputFile = "/Users/weekend/Desktop/new.xlsx";
        // 写入修改后的Excel文件
        workbook.write(Files.newOutputStream(Paths.get(outputFile)));

    }


    private static void processCell(Cell cell) {
        // 根据单元格类型获取其值
        switch (cell.getCellType()) {
            case STRING:
                log.info("String value: {}", cell.getStringCellValue());
                break;
            case NUMERIC:
                log.info("Numeric value: {}", cell.getNumericCellValue());
                break;
            case BOOLEAN:
                log.info("Boolean value: {}", cell.getBooleanCellValue());
                break;
            // ... 其他类型处理（如日期、公式等）
            default:
                log.info("Unsupported cell type encountered.");
        }
    }

    @Test
    public void writeExcel() throws Exception {
        log.info("开始写入");
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("sheet名称");
        for (int rowNum = 0; rowNum < 100000; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue("单元格值" + (rowNum + 1) + "-" + (cellNum + 1));
            }
        }
        OutputStream outputStream = Files.newOutputStream(Paths.get("./test.xlsx")); // 创建输出流
        workbook.write(outputStream);
        outputStream.close();   // 关闭流
        log.info("写入完成");
    }

    @Test
    public void writeExcelBuffer() throws Exception {
        log.info("开始写入");
        Workbook workbook = new SXSSFWorkbook();    // 创建SXSSFWorkbook对象:SXSSF是XSSF的流式处理版本
        Sheet sheet = workbook.createSheet("SXSSF");
        for (int rowNum = 0; rowNum < 100000; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue("SXSSF单元格值" + (rowNum + 1) + "-" + (cellNum + 1));
            }
        }
        OutputStream outputStream = Files.newOutputStream(Paths.get("./test.xlsx")); // 创建输出流
        workbook.write(outputStream);
        outputStream.close();   // 关闭流
        ((SXSSFWorkbook) workbook).dispose(); // 释放内存,清除临时文件
        log.info("写入完成");
    }
}
