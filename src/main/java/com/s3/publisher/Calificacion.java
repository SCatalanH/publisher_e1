package com.s3.publisher;

public class Calificacion {
    private int id;
    private int publicacionId;
    private int valor;

    // Constructor, getters y setters
    public Calificacion() {}

    public Calificacion(int id, int publicacionId, int valor) {
        this.id = id;
        this.publicacionId = publicacionId;
        this.valor = valor;
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


    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
