package ar.edu.unq.spring.persistence

import ar.edu.unq.spring.modelo.Libro
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface LibroDAO: CrudRepository<Libro, Long> {

    fun findTop5ByOrderByPaginasDesc(): Collection<Libro>

    @Query("SELECT l FROM Libro l WHERE REPLACE(l.genero, ' ', '') LIKE CONCAT('%', REPLACE(?1, ' ', ''), '%')\n")
    fun librosPorGenero(genero: String): Collection<Libro>

    @Query("SELECT l FROM Libro l WHERE REPLACE(l.autor, ' ', '') LIKE CONCAT('%', REPLACE(?1, ' ', ''), '%')\n")
    fun librosPorAutor(autor: String): Collection<Libro>

}
