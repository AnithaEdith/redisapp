package ips.caching

import org.redisson.Redisson
import org.redisson.api.RedissonClient
import org.redisson.config.Config
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
class redisConfig() {

    @Bean
    @Profile("dev", "default")
    fun redissonClient(): RedissonClient {
        val config = Config()
        val hostUri = "redis://127.0.0.1:6379"
        config.useReplicatedServers().addNodeAddress(hostUri)
        val client = Redisson.create(config)
        return client
    }

    @Bean
    @Profile("cloud")
    fun redissonClientforCloud(): RedissonClient {
        val config = Config()
      //  val hostUri = "redis://10.0.16.93:6379"
        val password = "56750894-cacc-4c73-bfe4-e1f71d34c31f"

      //  config.useReplicatedServers().addNodeAddress(hostUri).setPassword(password)
        config.useSingleServer().setAddress("10.0.16.93:6379").setPassword(password)
        val client:RedissonClient  = Redisson.create(config)

        return client
    }
}
