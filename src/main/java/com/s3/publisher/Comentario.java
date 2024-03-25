package com.s3.publisher;

public class Comentario {
    private int id;
    private int publicacionId;
    private String texto;

    public Comentario() {}

    public Comentario(int id, int publicacionId, String texto) {
        this.id = id;
        this.publicacionId = publicacionId;
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPublicacionId() {
        return publicacionId;
    }

    public void setPublicacionId(int publicacionId) {
        this.publicacionId = publicacionId;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}