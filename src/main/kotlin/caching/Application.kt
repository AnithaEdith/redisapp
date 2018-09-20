package caching

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.SpringApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.GenericToStringSerializer
import org.springframework.context.annotation.Profile
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.serializer.StringRedisSerializer
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}

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
/*
@Bean
fun redisConnectionFactory(): RedisConnectionFactory {
    LettuceConnectionFactory()
}

@Bean
fun reactiveRedisConnectionFactory(): ReactiveRedisConnectionFactory {
    LettuceConnectionFactory()
}

@Bean
fun reactiveRedisConnection(reactiveRedisConnectionFactory: ReactiveRedisConnectionFactory): ReactiveRedisConnection {
    reactiveRedisConnectionFactory.getReactiveConnection()
}*/

/*
@Bean
fun redisTemplate(): RedisTemplate<String, Any> {
    val template = RedisTemplate<String, Any>()
    template.setConnectionFactory(jedisConnectionFactory())
    template.setValueSerializer(GenericToStringSerializer<Any>(Any::class.java))
    return template
}
        */