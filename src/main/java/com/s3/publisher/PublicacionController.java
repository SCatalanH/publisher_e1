package com.s3.publisher;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
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
        
        this.publicaciones.add(new Publicacion(1, "Ingenieria de Software", "Esta prueba es de la carrera de Ing de Software", Arrays.asList(4, 5, 3), Arrays.asList(
            new Comentario(1, 1, "Veremos si me acuerdo de algo de lo que vi el semestre pasado"),
            new Comentario(2, 1, "Definitivamente no recuerdo nada")
        )));

        this.publicaciones.add(new Publicacion(2, "Desarrollo Fullstack I", "Un verdadero desafio de cara al bimestre", Arrays.asList(2, 4, 3, 5), Arrays.asList(
        new Comentario(3, 2, "Veremos como nos va, ojalá bien"),
        new Comentario(4, 2, "Igual siempre hay que tener un toque de creatividad")
        )));

        this.publicaciones.add(new Publicacion(3, "World of Warcraft", "El MMORPG mas famoso del mundo",Arrays.asList(5, 5, 5), Arrays.asList(
            new Comentario(5, 3, "Le tengo fe a las nuevas expansiones"),
            new Comentario(6, 3, "Lok'Tar")
        )));

        this.publicaciones.add(new Publicacion(4, "Base de Datos Aplicada", "Estamos dando paralelamente esta asignatura", Arrays.asList(1, 2, 1, 3, 2), Arrays.asList(
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
    
    for (Publicacion publicacion : publicaciones) {
        if (publicacion.getId() == id) {
            
            return publicacion;
        }
    }
    return null;
}
     @GetMapping("/publicaciones/{id}/comentarios")
    public List<Comentario> obtenerComentariosDePublicacion(@PathVariable int id) {
        Publicacion publicacion = null;

        
        for (Publicacion p : publicaciones) {
            if (p.getId() == id) {
                publicacion = p;
                break;
            }
        }

        if (publicacion == null) {
           
            return Collections.emptyList(); 
        }

        
        return publicacion.getComentarios();
    }

    @GetMapping("/publicaciones/{publicacionId}/comentarios/{comentarioId}")
    public Comentario obtenerComentarioDePublicacion(@PathVariable int publicacionId, @PathVariable int comentarioId) {
       
        Publicacion publicacion = buscarPublicacionPorId(publicacionId);

        if (publicacion != null) {
            
            List<Comentario> comentarios = publicacion.getComentarios();
            
            for (Comentario comentario : comentarios) {
                if (comentario.getId() == comentarioId) {
                   
                    return comentario;
                }
            }
        }

        
        return null;
    }

    
    private Publicacion buscarPublicacionPorId(int id) {
        for (Publicacion publicacion : publicaciones) {
            if (publicacion.getId() == id) {
                return publicacion;
            }
        }
        return null;
    }

    @GetMapping("/publicaciones/{id}/promedio-calificaciones")
    public double obtenerPromedioCalificaciones(@PathVariable int id) {
        
        Publicacion publicacion = publicaciones.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
        
        
        return publicacion != null ? publicacion.calcularPromedioCalificaciones() : 0.0;
    }

    @GetMapping("/publicaciones/{id}/calificaciones")
    public List<Integer> obtenerCalificacionesPorPublicacion(@PathVariable int id) {
        
        Publicacion publicacion = obtenerPublicacionPorId(id);

        
        if (publicacion != null) {
            
            return publicacion.getCalificaciones();
        } else {
            
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Publicación no encontrada");
        }
    }
} 