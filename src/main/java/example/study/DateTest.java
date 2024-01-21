package example.study;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void test01() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String today = "2023-11-22 12:00:00";
        Date date = format.parse(today);
        System.out.println("转换为时间是：" + date);

        String s = format.format(date);
        System.out.println("时间转换为字符串：" + s);
    }

    @Test
    public void test02() {
        Calendar calendar = Calendar.getInstance();
        System.out.println("获得年份:" + calendar.get(Calendar.YEAR));
        System.out.println("获得月份:" + (calendar.get(Calendar.MONTH) + 1)); //月份需要+1
        System.out.println("获得日期:" + calendar.get(Calendar.DATE));
        System.out.println(format.format(calendar.getTime()));  //格式化当前日期

        calendar.add(Calendar.DATE, 15); // 日期往后推15天
        System.out.println(format.format(calendar.getTime()));  //格式化当前日期
    }

    @Test
    public void test03() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        //获取前月的第一天
        Calendar cal_1 = Calendar.getInstance();//获取当前日期
        cal_1.add(Calendar.MONTH, -1);
        cal_1.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        String firstDay = format.format(cal_1.getTime());
        System.out.println("-----1------firstDay:" + firstDay);

        //获取前月的最后一天
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, 0);//设置为0号,当前日期既为上月最后一天
        String lastDay = format.format(cale.getTime());
        System.out.println("-----2------lastDay:" + lastDay);


        //获取当前月第一天：
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        String first = format.format(c.getTime());
        System.out.println("===============first:" + first);

        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = format.format(ca.getTime());
        System.out.println("===============last:" + last);
    }
}
