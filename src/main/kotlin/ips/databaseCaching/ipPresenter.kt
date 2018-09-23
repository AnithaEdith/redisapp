package ips.databaseCaching

import com.fasterxml.jackson.annotation.JsonRawValue
import org.springframework.stereotype.Service

@Service
class ipPresenter(val iprepo: ipRepo) {

    @Override
    fun getByIp(ipaddress: String): IP? {
        val obj:IP? = iprepo.findByIpadd(ipaddress)
		return obj
	}

    @Override
    fun putIp(ipaddress: String): IP? {

        val ipobject: IP? = IP(Math.random().toInt(), ipaddress)
        val obj:IP? = iprepo.save(ipobject)
        return obj
    }
}
