package TriajeBinarioApp.Clases;

public class NodoArbol {
    public Paciente datos;
    public NodoArbol izquierdo;
    public NodoArbol derecho;

    public NodoArbol(Paciente paciente) {
        this.datos = paciente;
        this.izquierdo = null;
        this.derecho = null;
    }
}