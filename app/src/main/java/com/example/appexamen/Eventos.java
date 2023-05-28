package com.example.appexamen;

public class Eventos {
    public int id;
    public int imagen;
    public String nombreEvento;
    public String Lugar;

    public Eventos(int id, int imagen, String nombreEvento, String lugar) {
        this.id = id;
        this.imagen = imagen;
        this.nombreEvento = nombreEvento;
        Lugar = lugar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String lugar) {
        Lugar = lugar;
    }

}
