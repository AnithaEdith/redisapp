package ips.caching

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.context.annotation.Profile
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory
import org.springframework.cloud.service.common.RedisServiceInfo;
import org.springframework.data.redis.core.StringRedisTemplate;

//@Configuration
//@Profile("default")
class RedisConfig {

    //@Bean
    fun jedisConnectionFactory(): RedisConnectionFactory {
        val factory = JedisConnectionFactory()
        factory.hostName = "127.0.0.1"
        factory.port = 6379
        factory.usePool = true
        return factory
    }

}
