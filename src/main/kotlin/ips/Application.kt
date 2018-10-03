package ips

import org.redisson.api.RedissonClient
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.SpringApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Profile
// import org.springframework.data.redis.connection.RedisConnectionFactory
// import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.redisson.config.Config
import org.redisson.Redisson
import org.redisson.client.codec.Codec


@SpringBootApplication
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
