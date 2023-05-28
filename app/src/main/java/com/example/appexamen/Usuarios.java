package com.example.appexamen;

public class Usuarios {

    private String Nombre;
    private String Cedula;
    private int Edad;
    private String Usuario;
    private String Contrasena;

    public Usuarios() {
    }

    public Usuarios(String nombre, String cedula, int edad, String usuario, String contrasena) {
        Nombre = nombre;
        Cedula = cedula;
        Edad = edad;
        Usuario = usuario;
        Contrasena = contrasena;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }


}
