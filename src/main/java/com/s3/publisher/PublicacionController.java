package com.s3.publisher;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class PublicacionController {
    private List<Publicacion> publicaciones;

    public PublicacionController() {    
        this.publicaciones = new ArrayList<>();
        // Datos de ejemplo
        this.publicaciones.add(new Publicacion(1, "Ingenieria de Software", "Esta prueba es de la carrera de Ing de Software", Arrays.asList(
        new Comentario(1, 1, "Veremos si me acuerdo de algo de lo que vi el semestre pasado"),
        new Comentario(2, 1, "Definitivamente no recuerdo nada")
        )));

        this.publicaciones.add(new Publicacion(2, "Desarrollo Fullstack I", "Un verdadero desafio de cara al bimestre", Arrays.asList(
        new Comentario(3, 2, "Veremos como nos va, ojalá bien"),
        new Comentario(4, 2, "Igual siempre hay que tener un toque de creatividad")
        )));

        this.publicaciones.add(new Publicacion(3, "World of Warcraft", "El MMORPG mas famoso del mundo", Arrays.asList(
            new Comentario(5, 3, "Le tengo fe a las nuevas expansiones"),
            new Comentario(6, 3, "Lok'Tar")
        )));

        this.publicaciones.add(new Publicacion(4, "Base de Datos Aplicada", "Estamos dando paralelamente esta asignatura", Arrays.asList(
            new Comentario(7, 4, "No voy a mentir, no recordaba como modelar bases de datos"),
            new Comentario(8, 4, "Igual se saca adelante, pero hay que hacer memoria")
        )));
        
        
    }

    @GetMapping("/publicaciones")
    public List<Publicacion> obtenerPublicaciones() {
        return publicaciones;
    }

    @GetMapping("/publicaciones/{id}")
    public Publicacion obtenerPublicacionPorId(@PathVariable int id) {
    // Buscar la publicación correspondiente al ID
    for (Publicacion publicacion : publicaciones) {
        if (publicacion.getId() == id) {
            // Si se encuentra la publicación, devolverla
            return publicacion;
        }
    }
    return null;
}
     @GetMapping("/publicaciones/{id}/comentarios")
    public List<Comentario> obtenerComentariosDePublicacion(@PathVariable int id) {
        Publicacion publicacion = null;

        // Buscar la publicación correspondiente al ID
        for (Publicacion p : publicaciones) {
            if (p.getId() == id) {
                publicacion = p;
                break;
            }
        }

        if (publicacion == null) {
            // Manejar el caso donde no se encuentra la publicación
            return Collections.emptyList(); // Devolver una lista vacía de comentarios
        }

        // Devolver los comentarios asociados a la publicación
        return publicacion.getComentarios();
    }

    @GetMapping("/publicaciones/{publicacionId}/comentarios/{comentarioId}")
public Comentario obtenerComentarioDePublicacion(@PathVariable int publicacionId, @PathVariable int comentarioId) {
    // Buscar la publicación por su ID
    Publicacion publicacion = buscarPublicacionPorId(publicacionId);

    // Verificar si la publicación existe
    if (publicacion != null) {
        // Obtener la lista de comentarios de la publicación
        List<Comentario> comentarios = publicacion.getComentarios();

        // Buscar el comentario por su ID en la lista de comentarios
        for (Comentario comentario : comentarios) {
            if (comentario.getId() == comentarioId) {
                // Devolver el comentario si se encuentra
                return comentario;
            }
        }
    }

    // Devolver null si la publicación o el comentario no se encuentran
    return null;
}

// Método de ayuda para buscar una publicación por su ID
private Publicacion buscarPublicacionPorId(int id) {
    for (Publicacion publicacion : publicaciones) {
        if (publicacion.getId() == id) {
            return publicacion;
        }
    }
    return null;
}

}
 