package ar.edu.unq.spring.controller.dto

import ar.edu.unq.spring.modelo.Libro

class LibroDTO (val id: Long?, val titulo: String?, val autor: String?, val genero: String?, val paginas: Int ) {

    companion object {
        fun desdeModelo(libro: Libro) =
            LibroDTO (
                id = libro.id,
                titulo = libro.titulo,
                autor = libro.autor,
                genero = libro.genero,
                paginas = libro.paginas
                )
    }

    fun aModelo(): Libro {
        val libro = Libro(this.titulo!!,this.autor!!,this.genero!!,this.paginas)
        libro.id = this.id
        return libro
    }
}