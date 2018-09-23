package ips.caching

import org.springframework.cloud.config.java.AbstractCloudConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.cloud.service.PooledServiceConnectorConfig
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.serializer.StringRedisSerializer
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import redis.clients.jedis.JedisPool
import org.springframework.data.redis.core.RedisTemplate

@Configuration
@Profile("cloud")
class RedisCloudConfig : AbstractCloudConfig() {

 /*   @Bean
    fun redisConnection(): RedisConnectionFactory {
//        val poolConfig: PoolConfig = PoolConfig(5, 30, 3000)
//        val redisConfig: PooledServiceConnectorConfig = RedisConnectionFactoryConfig(poolConfig)
        return connectionFactory().redisConnectionFactory("ppr-redis")
    }
    */
  /*   @Bean
    fun jedisConnectionFactory(): JedisConnectionFactory {
        val jedisConFactory: JedisConnectionFactory = JedisConnectionFactory()
        jedisConFactory.setHostName("master.cf-dbce4bc55b36406a9.91mvq1.apse2.cache.amazonaws.com");
        jedisConFactory.setPort(6379);
        jedisConFactory.setPassword("pNEwdhFCU1n4HKAAqwh7ftkW6N4yivOPJv0Az-71jT02yQMZ-AJdXIbarEweDs4xzEqBn9CDKF1Wtrh1");
        return jedisConFactory;
    }
*/
    @Bean
    fun redisTemplate(redisConnectionFactory: RedisConnectionFactory): RedisTemplate<String, String> {
        val template: RedisTemplate<String, String> = RedisTemplate()

        template.setConnectionFactory(redisConnectionFactory)

        val stringSerializer = StringRedisSerializer()

        template.setKeySerializer(stringSerializer)
        template.setValueSerializer(stringSerializer)
        template.setHashKeySerializer(stringSerializer)
        template.setHashValueSerializer(stringSerializer)

        return template
    }
}