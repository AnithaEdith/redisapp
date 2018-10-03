package ips.caching

import org.springframework.web.bind.annotation.*
import redis.clients.jedis.Jedis

@RestController
class redisController(
        private val jedis: Jedis
) {

    @GetMapping("/api/cache/set/{name}")
    fun setKey(@PathVariable("name") name: String?): String {
        jedis.set(name, name)
        return "Cache Set key: $name to value: $name" + "\t"
    }

    @GetMapping("/api/cache/get/{name}")
    fun getKey(@PathVariable("name") name: String?): String {
        return "cache get $name: \t" + jedis.get(name) + "\t"
    }

    @GetMapping("/api/cache/delete")
    fun deleteAllKeys(): String? {
        return jedis.flushAll()
    }

}
