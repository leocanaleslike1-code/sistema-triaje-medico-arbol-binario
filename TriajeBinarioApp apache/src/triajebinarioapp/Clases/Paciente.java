package TriajeBinarioApp.Clases;

public class Paciente {
    private String nombre;
    private String cedula;
    private String sintoma;
    private int puntajeRiesgo; // Criterio de ordenamiento (1 - 100)

    public Paciente(String nombre, String cedula, String sintoma, int puntajeRiesgo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.sintoma = sintoma;
        this.puntajeRiesgo = puntajeRiesgo;
    }

    public String getNombre() { return nombre; }
    public String getCedula() { return cedula; }
    public String getSintoma() { return sintoma; }
    public int getPuntajeRiesgo() { return puntajeRiesgo; }

    @Override
    public String toString() {
        return "[Riesgo: " + puntajeRiesgo + "] " + nombre + " (CC: " + cedula + ") - Sintoma: " + sintoma;
    }
}