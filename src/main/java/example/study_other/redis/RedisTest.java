package example.study_other.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisClientConfig;
import redis.clients.jedis.resps.Tuple;

import java.util.List;

/**
 * @author weekend
 */
@Slf4j
public class RedisTest {

    @Test
    public void test01() {

        // 1. 获取连接
        Jedis jedis = new Jedis("106.55.186.222", 6379);
        jedis.auth("dsifgiuqwgefbshdfkah123123352345");
        // 2. 执行操作关闭连接
        String set = jedis.set("name", "mannor");
        System.out.println("存储结果是：" + set);
        // 3. 关闭连接
        jedis.close();
    }

    @Test
    public void test02() {

        // 1. 获取连接
        Jedis jedis = new Jedis("106.55.186.222", 6379);
        jedis.auth("dsifgiuqwgefbshdfkah123123352345");
        // 2. 执行操作关闭连接
        String value = jedis.get("name");
        System.out.println("获取结果是：" + value);
        // 3. 关闭连接
        jedis.close();
    }

    @Test
    public void test03() {
        long currentTime = System.currentTimeMillis() / 1000;
        // 1. 获取连接
        Jedis jedis = new Jedis("106.55.186.222", 6379);
        jedis.auth("dsifgiuqwgefbshdfkah123123352345");
        // 2. 执行操作关闭连接
        long zadd = jedis.zadd("hot_file_key", currentTime, "钢铁是怎样炼成的1");
        System.out.println("存入有序集合的结果是：" + zadd);
        // 3. 关闭连接
        jedis.close();
    }

    @Test
    public void test04() {
        long currentTime = System.currentTimeMillis() / 1000;

        // 1. 获取连接
        Jedis jedis = new Jedis("106.55.186.222", 6379);
        jedis.auth("dsifgiuqwgefbshdfkah123123352345");
        // 2. 执行操作关闭连接
        List<Tuple> hotFileKey = jedis.zrangeByScoreWithScores("hot_file_key", 0, currentTime);
        for (Tuple tuple : hotFileKey) {
            String element = tuple.getElement();
            double score = tuple.getScore();
            System.out.println("获取有序集合区间的结果是：" + element + "--" + (int)score);
        }

        // 3. 关闭连接
        jedis.close();
    }

    @Test
    public void test05() {
        long currentTime = System.currentTimeMillis() / 1000;

        // 1. 获取连接
        Jedis jedis = new Jedis("106.55.186.222", 6379);
        jedis.auth("dsifgiuqwgefbshdfkah123123352345");
        // 2. 执行操作关闭连接
        long remove = jedis.zremrangeByScore("hot_file_key", 0, currentTime);
        System.out.println("删除有序集合区间的结果是：" + remove);
        // 3. 关闭连接
        jedis.close();
    }
}
