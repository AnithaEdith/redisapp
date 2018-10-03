package ips.databaseCaching

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Repository
interface ipRepo:CrudRepository<IP, Long> {
    fun findByIpadd(code: String): IP?
}

@Entity
data class IP (

    @Id
    @GeneratedValue(generator = "id_generator")
    @SequenceGenerator(
            name = "id_generator",
            sequenceName = "id_sequence",
            initialValue = 1000
    )
    val id: Long? = null,

    @Column(name="ipadd")
    var ipadd: String = ""

)
