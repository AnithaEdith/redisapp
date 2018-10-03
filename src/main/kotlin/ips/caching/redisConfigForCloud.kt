package ips.caching

import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.postgresql.jdbc.EscapedFunctions
import org.redisson.Redisson
import org.redisson.api.RedissonClient
import org.redisson.config.Config
import org.springframework.cloud.service.common.RedisServiceInfo
import org.springframework.cloud.CloudFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import redis.clients.jedis.Jedis

@Configuration
@Profile("cloud")
class redisConfigForCloud () {

    @Bean
    fun listServiceInfo(): List<RedisServiceInfo> {
        val redisServiceInfos: List<RedisServiceInfo>
        val cloudFactory = CloudFactory()
        val cloud = cloudFactory.cloud
        redisServiceInfos = cloud.getServiceInfosByType(RedisServiceInfo::class.java)
        println("redisservice info" + redisServiceInfos.size)
        return redisServiceInfos
    }

    @Bean
    fun getInfoforCloud(): RedisInstanceInfo {
        val vcap = System.getenv("VCAP_SERVICES")
        val root = JsonParser().parse(vcap)
        var redis: JsonObject? = null
        if (root != null) {
            if (root!!.getAsJsonObject().has("aws-elasticache-redis")) {
                redis = root!!.getAsJsonObject().get("aws-elasticache-redis").getAsJsonArray().get(0).getAsJsonObject()
            }
        }

        if (redis != null) {
            val creds = redis.get("credentials").asJsonObject
            val info = RedisInstanceInfo()
            info.host = creds.get("host").asString
            info.port = creds.get("port").asInt
            info.password = creds.get("password").asString

            println("redis info " + info.host + info.password)


            return info
        } else
            println("redis info is null ")
        return RedisInstanceInfo()
    }

    @Bean
    fun getJedisConnectionforCloud(redisInstanceInfo : RedisInstanceInfo): Jedis {
        val jedis = Jedis(redisInstanceInfo.host, redisInstanceInfo.port, true)
        jedis.connect()
        jedis.auth(redisInstanceInfo.password)

        return jedis;
    }

}

class RedisInstanceInfo {
    var host: String? = null
    var port: Int = 0
    var password: String? = null
}

