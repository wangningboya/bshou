package cn.wy.bs.config.redis;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * @Author WY
 * @Date 2019/4/16
 **/
@Configuration
@EnableCaching
public class RedisCacheConfig {

//	@Bean
//	public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
//		CacheManager cacheManager = new RedisCacheManager(redisTemplate);
//		return cacheManager;
//	}
}
