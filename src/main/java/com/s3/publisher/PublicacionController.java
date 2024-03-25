package com.s3.publisher;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PublicacionController {
    private List<Publicacion> publicaciones;

    public PublicacionController() {    
        this.publicaciones = new ArrayList<>();
        // Datos de ejemplo
        this.publicaciones.add(new Publicacion(1, "Título 1", "Contenido 1"));
        this.publicaciones.add(new Publicacion(2, "Título 2", "Contenido 2"));
    }

    @GetMapping("/publicaciones")
    public List<Publicacion> obtenerPublicaciones() {
        return publicaciones;
    }

    @GetMapping("/publicaciones/{id}")
    public Publicacion obtenerPublicacionPorId(@PathVariable int id) {
        // Implementar lógica para buscar publicación por ID
        // Por simplicidad, aquí retornaríamos una publicación estática
        return new Publicacion(id, "Título de la publicación #" + id, "Contenido de la publicación #" + id);
    }
}
