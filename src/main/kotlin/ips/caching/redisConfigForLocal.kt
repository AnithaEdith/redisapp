package ips.caching

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import redis.clients.jedis.Jedis

@Configuration
class redisConfigForLocal() {

    @Bean
    @Profile("default")
    fun getInfoforLocal(): RedisInstanceInfo {
        val info = RedisInstanceInfo()
        info.host = "127.0.0.1"
        info.port = 6379
        return info
    }


    @Bean
    @Profile("default")
    fun getJedisConnectionforLocal(redisInstanceInfo : RedisInstanceInfo): Jedis {
        val jedis = Jedis(redisInstanceInfo.host, redisInstanceInfo.port)
        jedis.connect()
        return jedis;
    }
}
