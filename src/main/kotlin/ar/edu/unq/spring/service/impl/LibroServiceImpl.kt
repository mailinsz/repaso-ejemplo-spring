package ar.edu.unq.spring.service.impl

import ar.edu.unq.spring.modelo.Libro
import ar.edu.unq.spring.persistence.LibroDAO
import ar.edu.unq.spring.service.interfaces.LibroService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class LibroServiceImpl : LibroService {

    @Autowired private lateinit var libroDAO: LibroDAO

    override fun guardarLibro(libro: Libro) {
        libroDAO.save(libro)
    }

    override fun recuperarLibro(libroId: Long): Libro? {
        return libroDAO.findByIdOrNull(libroId)
    }

    override fun todosLosLibros(): Collection<Libro> {
        return libroDAO.findAll().toMutableSet()
    }

    override fun librosMasLargos(): Collection<Libro> {
        return libroDAO.findTop5ByOrderByPaginasDesc()
    }

    override fun librosPorGenero(genero: String): Collection<Libro> {
        return libroDAO.librosPorGenero(genero)
    }

    override fun librosPorAutor(autor: String): Collection<Libro> {
        return libroDAO.librosPorAutor(autor)
    }

    override fun borrarTodo() {
        libroDAO.deleteAll()
    }
}