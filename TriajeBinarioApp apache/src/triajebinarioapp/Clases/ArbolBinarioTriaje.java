package TriajeBinarioApp.Clases;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class ArbolBinarioTriaje {
    private NodoArbol raiz;

    public ArbolBinarioTriaje() {
        this.raiz = null;
    }

    // Insercion recursiva segun PuntajeRiesgo
    public void insertar(Paciente nuevoPaciente) {
        raiz = insertarRecursivo(raiz, nuevoPaciente);
    }

    private NodoArbol insertarRecursivo(NodoArbol actual, Paciente paciente) {
        if (actual == null) {
            return new NodoArbol(paciente);
        }
        if (paciente.getPuntajeRiesgo() < actual.datos.getPuntajeRiesgo()) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, paciente);
        } else {
            actual.derecho = insertarRecursivo(actual.derecho, paciente);
        }
        return actual;
    }

    // Recorrido InOrden (Izquierda -> Raiz -> Derecha)
    public void mostrarInOrden() {
        if (raiz == null) {
            System.out.println("El arbol se encuentra vacio.");
            return;
        }
        recorrerInOrden(raiz);
    }

    private void recorrerInOrden(NodoArbol nodo) {
        if (nodo == null) return;
        recorrerInOrden(nodo.izquierdo);
        System.out.println(nodo.datos.toString());
        recorrerInOrden(nodo.derecho);
    }

    // Busqueda por puntaje de riesgo
    public Paciente buscarPorRiesgo(int puntaje) {
        return buscarRecursivo(raiz, puntaje);
    }

    private Paciente buscarRecursivo(NodoArbol actual, int puntaje) {
        if (actual == null) return null;
        if (actual.datos.getPuntajeRiesgo() == puntaje) return actual.datos;
        if (puntaje < actual.datos.getPuntajeRiesgo())
            return buscarRecursivo(actual.izquierdo, puntaje);
        else
            return buscarRecursivo(actual.derecho, puntaje);
    }

    // Paciente mas critico (extremo derecho)
    public Paciente obtenerMasCritico() {
        if (raiz == null) return null;
        NodoArbol actual = raiz;
        while (actual.derecho != null) {
            actual = actual.derecho;
        }
        return actual.datos;
    }

    // Visualizacion de la estructura en consola
    public void imprimirEstructura() {
        if (raiz == null) {
            System.out.println("El arbol esta vacio.");
            return;
        }
        imprimirNodo(raiz, "", true, "RAIZ");
    }

    private void imprimirNodo(NodoArbol nodo, String sangria, boolean esUltimo, String rama) {
        if (nodo == null) return;
        System.out.print(sangria);
        System.out.print(esUltimo ? "└── " : "├── ");
        System.out.println("[" + rama + "] " + nodo.datos.getNombre() + " (Riesgo: " + nodo.datos.getPuntajeRiesgo() + ")");
        sangria += esUltimo ? "    " : "│   ";
        if (nodo.izquierdo != null || nodo.derecho != null) {
            if (nodo.izquierdo != null)
                imprimirNodo(nodo.izquierdo, sangria, nodo.derecho == null, "IZQ <");
            if (nodo.derecho != null)
                imprimirNodo(nodo.derecho, sangria, true, "DER >=");
        }
    }

    // Respaldo en archivo TXT
    public void respaldarEnTxt(String rutaArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo))) {
            writer.println("==============================================");
            writer.println("      RESPALDO DE PACIENTES - TIAJE MEDICO    ");
            writer.println("==============================================");
            guardarInOrdenRecursivo(raiz, writer);
            System.out.println("Respaldo generado exitosamente en el archivo: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al generar el respaldo: " + e.getMessage());
        }
    }

    private void guardarInOrdenRecursivo(NodoArbol nodo, PrintWriter writer) {
        if (nodo == null) return;
        guardarInOrdenRecursivo(nodo.izquierdo, writer);
        writer.println(nodo.datos.toString());
        guardarInOrdenRecursivo(nodo.derecho, writer);
    }
}