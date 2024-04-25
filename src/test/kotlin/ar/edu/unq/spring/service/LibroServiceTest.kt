package ar.edu.unq.spring.service

import ar.edu.unq.spring.modelo.Libro
import ar.edu.unq.spring.service.interfaces.LibroService
import org.junit.jupiter.api.*
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.jdbc.JdbcTestUtils


@ExtendWith(SpringExtension::class)
@SpringBootTest
@TestInstance(PER_CLASS)
class LibroServiceTest {

    @Autowired
    lateinit var libroService: LibroService

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    lateinit var libro1: Libro
    lateinit var libro2: Libro
    lateinit var libro3: Libro
    lateinit var libro4: Libro
    lateinit var libro5: Libro
    lateinit var libro6: Libro
    lateinit var libro7: Libro
    lateinit var libro8: Libro
    lateinit var libro9: Libro
    lateinit var libro10: Libro

    @BeforeAll
    fun prepare() {
        libro1 = Libro("Cementerio de animales", "Stephen King", "Terror",488)
        libro2 = Libro("Carrie", "Stephen King", "Terror", 272)
        libro3 = Libro("Las cosas que perdimos en el fuego", "Mariana Enriquez", "Terror", 200)
        libro4 = Libro("La comunidad del anillo", "J.R.R. Tolkien", "Fantasia", 560)
        libro5 = Libro("Las Crónicas de Narnia: el león, la bruja y el ropero", "C.S. Lewis", "Fantasia", 206)
        libro6 = Libro("Los juegos del hambre", "Suzanne Collins", "Distopía", 396)
        libro7 = Libro("Canción de hielo y fuego 1: Juego de tronos", "George R.R. Martin", "Fantasia", 832)
        libro8 = Libro("Canción de hielo y fuego 2: Choque de reyes", "George R.R. Martin", "Fantasia", 928)
        libro9 = Libro("El Reino del Revés", "María Elena Walsh", "Cuentos", 104 )
        libro10 = Libro("Ready Player One", "Ernest Cline", "Ciencia Ficcion", 374)

        libroService.guardarLibro(libro1)
        libroService.guardarLibro(libro2)
        libroService.guardarLibro(libro3)
        libroService.guardarLibro(libro4)
        libroService.guardarLibro(libro5)
        libroService.guardarLibro(libro6)
        libroService.guardarLibro(libro7)
        libroService.guardarLibro(libro8)
        libroService.guardarLibro(libro9)
        libroService.guardarLibro(libro10)
    }

    @Test
    fun testRecuperarLibro(){
        val libro = libroService.recuperarLibro(1)

        Assertions.assertEquals("Cementerio de animales", libro?.titulo)
    }
    @Test
    fun testRecuperarTodosLosLibros() {
        val libros = libroService.todosLosLibros()

        Assertions.assertEquals(10,libros.size)
    }

    @Test
    fun testLibrosMasLargos() {
        val libros = libroService.librosMasLargos()

        Assertions.assertEquals(5,libros.size)
        Assertions.assertTrue(libros.contains(libro8))
    }

    @Test
    fun testLibrosPorGenero() {
        val libros = libroService.librosPorGenero("Terror")

        Assertions.assertEquals(3,libros.size)
    }

    @Test
    fun testLibrosPorAutor() {
        val libros = libroService.librosPorAutor("Stephen King")

        Assertions.assertEquals(2,libros.size)
    }

    @AfterAll
    fun clearDatabase() {
        libroService.borrarTodo()
        JdbcTestUtils.dropTables(jdbcTemplate,"libro")
    }

}