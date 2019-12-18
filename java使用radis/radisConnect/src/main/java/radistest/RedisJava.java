package radistest;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author lizhang.huang@hand-china.com
 * @date 2019-12-16 16:33
 */
public class RedisJava {
    public static void main(String[] args) {
        //连接本地radis
        Jedis jedis = new Jedis("localhost");
        System.out.println("Redis成功");
        //查看服务
        System.out.println("服务正在运行：" + jedis.ping());
        //存储数据到String
        jedis.set("key1","1");
        System.out.println("String为" + jedis.get("key1"));
        //存储数据到list
        jedis.lpush("keyList","list1");
        jedis.lpush("keyList","list2");
        jedis.lpush("keyList","list3");
        List<String> keyList = jedis.lrange("keyList", 0, 3);
        System.out.println("list存储为：" + keyList);
        for (int i = 0; i < keyList.size(); i++) {
            System.out.println("list存储的第" + (i+1) + "项为：" + keyList.get(i));
        }
        // 获取所有的key并输出
        Set<String> s  = jedis.keys("*");
        Iterator<String> iterator = s.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key);
        }

    }
}
