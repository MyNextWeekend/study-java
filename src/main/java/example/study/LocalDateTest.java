package example.study;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author weekend
 */
public class LocalDateTest {
    @Test
    public void test01() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now();
        System.out.println(formatter.format(now));

        LocalDate tenDaysAgo = now.minusDays(10);
        System.out.println(formatter.format(tenDaysAgo));
    }
}
