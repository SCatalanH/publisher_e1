package com.s3.publisher;

import java.util.List;

public class Publicacion {
    private int id;
    private String titulo;
    private String contenido;
    private List<Comentario> comentarios;
    private List<Integer> calificaciones;

    public Publicacion() {}

    public Publicacion(int id, String titulo, String contenido, List<Integer> calificaciones, List<Comentario> comentarios) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.calificaciones = calificaciones;
        this.comentarios = comentarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public void setCalificaciones(List<Integer> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public List<Integer> getCalificaciones() {
        return calificaciones;
    }

    public double calcularPromedioCalificaciones() {
        if (calificaciones == null || calificaciones.isEmpty()) {
            return 0.0;
        }
        int total = 0;
        for (int calificacion : calificaciones) {
            total += calificacion;
        }
        return (double) total / calificaciones.size();
    }
}
