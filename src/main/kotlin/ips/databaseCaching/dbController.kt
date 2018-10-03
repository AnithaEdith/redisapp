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
        val storedIp = ipresenter.getByIp(ip)?.id
        println(storedIp)
        return "Retrieved ip from Database is " + storedIp + "\t"
    }

    @GetMapping("/api/db/save/{ip}")
    fun savePlan(@PathVariable ip: String): String {
        if(ipresenter.getByIp(ip)?.id!!.equals(null)) {
            ipresenter.putIp(ip)
        }
        return "ip is stored in Database" + ip + "\t"
    }

    @GetMapping("/api/db/delete")
    fun deleteall(): String {
        ipresenter.delete()
        return "deleted entries from db"
    }
}
