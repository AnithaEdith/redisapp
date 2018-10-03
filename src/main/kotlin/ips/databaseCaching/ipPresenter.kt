package ips.databaseCaching

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
        return iprepo.save(IP(1L, ipaddress))
    }

    @Override
    fun delete() {
        return iprepo.deleteAll()
    }

}
