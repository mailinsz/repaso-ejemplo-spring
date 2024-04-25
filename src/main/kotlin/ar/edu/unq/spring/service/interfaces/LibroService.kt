package ar.edu.unq.spring.service.interfaces

import ar.edu.unq.spring.modelo.Libro

interface LibroService {
    fun guardarLibro(libro: Libro)
    fun recuperarLibro(libroId: Long): Libro?
    fun todosLosLibros(): Collection<Libro>
    fun librosMasLargos(): Collection<Libro>
    fun librosPorGenero(genero: String): Collection<Libro>
    fun librosPorAutor(autor: String): Collection<Libro>
    fun borrarTodo()
}