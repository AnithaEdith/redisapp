package ips.caching

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import javax.annotation.Resource
import org.springframework.data.redis.core.SetOperations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.HashOperations
import org.springframework.data.redis.core.StringRedisTemplate;

@RestController
class HelloController {

    @Autowired
    private val template: RedisTemplate<String, String>? = null

    @Autowired
    private val stringRedisTemplate: StringRedisTemplate? = null

    private var hashOperations: HashOperations<String, String, Long>? = null

    @GetMapping("/hello")
    fun helloKotlin(): String {
        return "hello world"
    }

    @GetMapping("/set")
    fun setCache(): String {
        println("before pushing to cache")
        template?.opsForValue()?.set("1", "one")
        println("pushed to cache")
        return "hello world"
    }

    @GetMapping("/get")
    fun getfromCache(): String? {
        println("before getting from cache")
        val cacheitems: String? = template?.opsForValue()?.get("1")
        println(cacheitems)
        return cacheitems
    }

    @GetMapping("/sethash")
    fun setCacheforHash(): String {
        println("sethash before pushing to cache")
        hashOperations = template?.opsForHash()
        hashOperations?.increment("2", "two", 1L);

        println("sethash pushed to cache")
        return "hello world"
    }

    @GetMapping("/setstring")
    fun setstring(): String {
        println("setstring before pushing to cache")
        stringRedisTemplate?.opsForValue()?.set("3", "three" )
        println("setstring pushed to cache")
        return "hello world"
    }

}