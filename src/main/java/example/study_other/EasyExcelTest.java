package example.study_other;

import com.alibaba.excel.EasyExcel;
import example.dto.UserExcelDto;
import example.util.PathUtil;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author weekend
 */
public class EasyExcelTest {
    @Test
    public void testWriteExcel() {
        ArrayList<UserExcelDto> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UserExcelDto userExcelDto = new UserExcelDto();
            userExcelDto.setUserName("字符串" + i);
            userExcelDto.setBirthday(new Date());
            userExcelDto.setAge(i);
            list.add(userExcelDto);
        }

        String fileName = PathUtil.getPath() + "demo.xlsx";
        EasyExcel.write(fileName).sheet("用户信息").    doWrite(list);
    }

    @Test
    public void testReadExcel() {
//        String fileName = PathUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        String fileName = PathUtil.getPath() + "demo.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName).sheet().doRead();
    }
}
