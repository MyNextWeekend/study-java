package example.study_other.apache_commons;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.*;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * lang试验
 *
 * @author weekend
 * @date 2024/02/18
 */
@Slf4j
public class LangTest {

    @Test
    public void test1() throws ParseException {
        //********************************ArrayUtils***************************************
        // 将两个数组合并为一个数组
        String[] s1 = new String[]{"1", "2", "3"};
        String[] s2 = new String[]{"a", "b", "c"};
        String[] s = (String[]) ArrayUtils.addAll(s1, s2);
        for (int i = 0; i < s.length; i++) {
            log.info(s[i]);
        }
        String str = ArrayUtils.toString(s);
        str = str.substring(1, str.length() - 1);
        log.info(str + ">>" + str.length());

        //********************************StringUtils***************************************
        // 截取从from开始字符串
        StringUtils.substringAfter("SELECT * FROM PERSON ", "from");
        // 判断该字符串是不是为数字(0~9)组成，如果是，返回true 但该方法不识别有小数点和请注意
        StringUtils.isNumeric("454534"); // 返回true
        // 取得类名
        log.info(ClassUtils.getShortClassName(LangTest.class));
        // 取得其包名
        log.info(ClassUtils.getPackageName(LangTest.class));
        // 五位的随机字母和数字
        log.info(RandomStringUtils.randomAlphanumeric(5));
        // StringEscapeUtils
        log.info(StringEscapeUtils.escapeHtml3("<html>"));
        // 输出结果为<html>
        log.info(StringEscapeUtils.escapeJava("String"));
        // StringUtils,判断是否是空格字符
        log.info("" + StringUtils.isBlank("   "));
        // 将数组中的内容以,分隔
        log.info(StringUtils.join(s1, ","));
        // 在右边加下字符,使之总长度为6
        log.info(StringUtils.rightPad("abc", 6, 'T'));
        // 首字母大写
        log.info(StringUtils.capitalize("abc"));
        // Deletes all whitespaces from a String 删除所有空格
        log.info(StringUtils.deleteWhitespace("   ab  c  "));
        // 判断是否包含这个字符
        log.info("" + StringUtils.contains("abc", "ba"));
        // 表示左边两个字符
        log.info(StringUtils.left("abc", 2));

        //********************************DateFormatUtils***************************************
        log.info(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        // 直接将日期格式化为内置的固定格式
        log.info(DateFormatUtils.ISO_DATE_FORMAT.format(new Date()));
        // 字符型日期转化为Date
        log.info("" + DateUtils.parseDate("2014-11-11 11:11:11", new String[]{"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM-dd", "yyyy/MM/dd"}));
        // 日期舍入与截整
        log.info("" + DateUtils.truncate(new Date(), Calendar.DATE));
        // 判断是否是同一天
        log.info("" + DateUtils.isSameDay(new Date(), new Date()));
        // 加天数
        log.info("" + DateUtils.addDays(new Date(), 10));
    }

}
