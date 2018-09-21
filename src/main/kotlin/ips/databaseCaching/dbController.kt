package ips.databaseCaching

import com.fasterxml.jackson.databind.JsonNode
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class dbController(
    private val ipresenter: ipPresenter
) {
    @GetMapping("/api/db/{ip}")
    fun getPlan(@PathVariable ip: String): String {
        println(ipresenter.getByIp(ip)?.id)
        return "ipgetplan"
    }

    @GetMapping("/api/db/save/{ip}")
    fun savePlan(@PathVariable ip: String): String {
        ipresenter.putIp(ip)
        return "ipputplan"
    }
}
