package demo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * description
 * </p>
 *
 * @author meixiang.wang@hand-china.com 2019-10-16-15:55
 */
public class redisPool {
	public Map<String,Object> getJedis(String url, Integer port){
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		//设置最大连接数
		jedisPoolConfig.setMaxTotal(100);
		//设置最大空闲池数
		jedisPoolConfig.setMinIdle(10);

		JedisPool jedisPool = new JedisPool(jedisPoolConfig,url,port);
		Jedis jedis = jedisPool.getResource();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("jedis",jedis);
		map.put("jedisPool",jedisPool);
		return map;

	}
}
