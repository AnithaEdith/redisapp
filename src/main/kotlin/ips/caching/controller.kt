package ips.caching

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import javax.annotation.Resource
import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.data.redis.core.SetOperations
//import org.springframework.data.redis.core.RedisTemplate
//import org.springframework.data.redis.core.HashOperations
//import org.springframework.data.redis.core.StringRedisTemplate;
import org.bouncycastle.crypto.tls.ConnectionEnd.client
import org.redisson.api.RLocalCachedMap
import org.redisson.api.RedissonClient
import org.redisson.api.LocalCachedMapOptions
import org.bouncycastle.crypto.tls.ConnectionEnd.client
import org.jboss.logging.MDC.getMap
import org.redisson.api.RMap

@RestController
class HelloController {

  /*  @Autowired
    private val template: RedisTemplate<String, String>? = null

    @Autowired
    private val stringRedisTemplate: StringRedisTemplate? = null*/

    @Autowired
    private val redissonClient: RedissonClient? = null

   // private var hashOperations: HashOperations<String, String, Long>? = null

    var options = LocalCachedMapOptions.defaults().maxIdle((10 * 1000).toLong()).timeToLive((10 * 1000).toLong())
    var map: RMap<String?, String?>? = redissonClient?.getMap("myredisCache")


    @GetMapping("/hello")
    fun helloKotlin(): String {
        return "hello world"
    }


    @GetMapping("/hey/{name}")
    fun helloKotlin(@PathVariable("name") name: String?): String {
        return "hello world" + name
    }

    @GetMapping("/get/{cacheitem}")
    fun setCache(@PathVariable("cacheitem") cacheitem: String?): String? {
        println("before pushing to cache")
        map?.get(cacheitem)
        println("pushed to cache" + map?.get(cacheitem))
        return cacheitem
    }


/*
    @GetMapping("/set/{cacheitem}")
    fun setCache(@PathVariable("cacheitem") cacheitem: String?): String? {
        println("before pushing to cache")
        template?.opsForValue()?.set(cacheitem, cacheitem)
        println("pushed to cache")
        return cacheitem
    }

    @GetMapping("/get/{cacheitem}")
    fun getfromCache(@PathVariable("cacheitem") cacheitem: String?): String? {
        println("before getting from cache")
        val retrievedFromCache: String? = template?.opsForValue()?.get(cacheitem)
        println(retrievedFromCache)
        return retrievedFromCache
    }

    @GetMapping("/sethash/{cacheitem}")
    fun setCacheforHash(@PathVariable("cacheitem") cacheitem: String?): String {
        println("sethash before pushing to cache")
        hashOperations = template?.opsForHash()
        hashOperations?.increment(cacheitem,cacheitem, 1L);

        println("sethash pushed to cache")
        return "hello world"
    }

    @GetMapping("/setstring/{cacheitem}")
    fun setstring(@PathVariable("cacheitem") cacheitem: String?): String {
        println("setstring before pushing to cache")
        stringRedisTemplate?.opsForValue()?.set(cacheitem, cacheitem )
        println("setstring pushed to cache")
        return "hello world"
    }*/

}