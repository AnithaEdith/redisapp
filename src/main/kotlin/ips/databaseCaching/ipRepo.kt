package ips.databaseCaching

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ipRepo:CrudRepository<IP, Int> {
    fun findByIpadd(code: String): IP?
}

@Entity
data class IP(
    @Id
    @Column(name="id")
    val id: Int? = null,

    @Column(name="ipadd")
    val ipadd: String
)
