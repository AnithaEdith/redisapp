package caching

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import javax.annotation.Resource
import org.springframework.data.redis.core.SetOperations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate

@RestController
class HelloController {

    @Autowired
    private val template: RedisTemplate<String, String>? = null

    @GetMapping("/hello")
    fun helloKotlin(): String {
        return "hello world"
    }

    @GetMapping("/set")
    fun setCache(): String {
        println("before pushing to cache")
        this.template?.opsForValue()?.set("1", "one")
        println("pushed to cache")
        return "hello world"
    }

    @GetMapping("/get")
    fun getfromCache(): String? {
        println("before getting from cache")
        val cacheitems: String? = this.template?.opsForValue()?.get("1")
        println(cacheitems)
        return cacheitems
    }

}