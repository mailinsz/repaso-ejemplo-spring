package ar.edu.unq.spring.modelo

import javax.persistence.*
import java.util.Objects

@Entity
class Libro() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var titulo: String? = null
    var autor: String? = null
    var genero: String? = null
    var paginas: Int = 0

    constructor(titulo: String,autor: String, genero: String, paginas: Int):this() {
        this.titulo = titulo
        this.autor = autor
        this.genero = genero
        this. paginas = paginas
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val libro = other as Libro?
        return id == libro!!.id
    }

    override fun hashCode(): Int {
        return Objects.hash(id)
    }

    override fun toString(): String {
        return titulo!!
    }

}