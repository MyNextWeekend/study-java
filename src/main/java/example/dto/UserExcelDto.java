package example.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author weekend
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserExcelDto {
    @ExcelProperty("字符串标题")
    private String userName;
    @ExcelProperty("日期标题")
    private Date birthday;
    @ExcelProperty("数字标题")
    private Integer age;

}
