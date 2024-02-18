package example.study_other.apache_commons;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.apache.commons.collections4.map.LinkedMap;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 集合测试
 *
 * @author weekend
 * @date 2024/02/18
 */
@Slf4j
public class CollectionsTest {
    @Test
    public void test() {
        // 得到集合里按顺序存放的key之后的某一Key
        OrderedMap map = new LinkedMap();
        map.put("FIVE", "5");
        map.put("SIX", "6");
        map.put("SEVEN", "7");
        map.firstKey(); // returns "FIVE"
        map.nextKey("FIVE"); // returns "SIX"
        map.nextKey("SIX"); // returns "SEVEN"

        // 通过key得到value 通过value得到key 将map里的key和value对调
        BidiMap bidi = new TreeBidiMap();
        bidi.put("SIX", "6");
        bidi.get("SIX"); // returns "6"
        bidi.getKey("6"); // returns "SIX"
        // bidi.removeValue("6"); // removes the mapping
        BidiMap inverse = bidi.inverseBidiMap(); // returns a map with keys and values swapped
        log.info(""+inverse);

        // 得到两个集合中相同的元素
        List<String> list1 = new ArrayList<String>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        List<String> list2 = new ArrayList<String>();
        list2.add("2");
        list2.add("3");
        list2.add("5");
        Collection c = CollectionUtils.retainAll(list1, list2);
        log.info(""+c);
    }
}
