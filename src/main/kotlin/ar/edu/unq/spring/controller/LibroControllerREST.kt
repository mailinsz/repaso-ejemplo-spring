package ar.edu.unq.spring.controller

import ar.edu.unq.spring.controller.dto.LibroDTO
import ar.edu.unq.spring.modelo.Libro
import ar.edu.unq.spring.service.interfaces.LibroService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping("/libro")
class LibroControllerREST(private val libroService: LibroService) {

    @PostMapping()
    fun guardarLibro(@RequestBody libro: LibroDTO) = libroService.guardarLibro(libro.aModelo())

    @GetMapping("/id/{libroId}")
    fun recuperarLibro(@PathVariable libroId: Long) = LibroDTO.desdeModelo(libroService.recuperarLibro(libroId)!!)

    @GetMapping("/todos")
    fun todosLosLibros() = libroService.todosLosLibros().map {libro -> LibroDTO.desdeModelo(libro)}

    @GetMapping("/masLargos")
    fun librosMasLargos() = libroService.librosMasLargos().map {libro -> LibroDTO.desdeModelo(libro)}

    @GetMapping("/genero/{genero}")
    fun librosPorGenero(@PathVariable genero: String) = libroService.librosPorGenero(genero).map { libro -> LibroDTO.desdeModelo(libro) }

    @GetMapping("/autor/{autor}")
    fun librosPorAutor(@PathVariable autor: String) = libroService.librosPorAutor(autor).map { libro -> LibroDTO.desdeModelo(libro)}
}