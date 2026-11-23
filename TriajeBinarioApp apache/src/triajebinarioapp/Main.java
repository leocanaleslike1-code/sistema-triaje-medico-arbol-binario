package TriajeBinarioApp;

import TriajeBinarioApp.Clases.ArbolBinarioTriaje;
import TriajeBinarioApp.Clases.Paciente;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArbolBinarioTriaje arbolTriaje = new ArbolBinarioTriaje();
        Scanner scanner = new Scanner(System.in);

        // Carga inicial de datos de prueba
        arbolTriaje.insertar(new Paciente("Carlos Mendoza", "10984512", "Dolor toracico leve", 50));
        arbolTriaje.insertar(new Paciente("Ana Lucia Gomez", "52418963", "Esguince de tobillo", 25));
        arbolTriaje.insertar(new Paciente("Jorge Ramirez", "80147258", "Dificultad respiratoria", 80));
        arbolTriaje.insertar(new Paciente("Maria Fernanda Ruiz", "10203040", "Fiebre moderada", 15));
        arbolTriaje.insertar(new Paciente("Luis Eduardo Torres", "79456123", "Trauma craneoencefalico", 95));

        int opcion = 0;
        do {
            System.out.println("\n==============================================");
            System.out.println("   SISTEMA DE TRIAJE MEDICO - ARBOL BINARIO   ");
            System.out.println("==============================================");
            System.out.println("1. Registrar nuevo paciente en el arbol");
            System.out.println("2. Visualizar jerarquia del Arbol Binario");
            System.out.println("3. Listar pacientes ordenados (Recorrido InOrden)");
            System.out.println("4. Consultar paciente mas critico (Extremo Derecho)");
            System.out.println("5. Buscar paciente por puntaje de riesgo");
            System.out.println("6. Respaldar pacientes en archivo TXT");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: ");

            if (!scanner.hasNextInt()) {
                scanner.next();
                continue;
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del paciente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Cedula: ");
                    String cedula = scanner.nextLine();
                    System.out.print("Sintoma principal: ");
                    String sintoma = scanner.nextLine();
                    System.out.print("Puntaje de riesgo (1 - 100): ");
                    int riesgo = scanner.nextInt();
                    arbolTriaje.insertar(new Paciente(nombre, cedula, sintoma, riesgo));
                    System.out.println("Paciente insertado correctamente.");
                    break;
                case 2:
                    System.out.println("--- ESTRUCTURA JERARQUICA DE NODOS ---");
                    arbolTriaje.imprimirEstructura();
                    break;
                case 3:
                    System.out.println("--- LISTADO ORDENADO POR GRAVEDAD (INORDEN) ---");
                    arbolTriaje.mostrarInOrden();
                    break;
                case 4:
                    Paciente critico = arbolTriaje.obtenerMasCritico();
                    System.out.println(critico != null ? "ALERTA MAXIMA: " + critico : "No hay pacientes.");
                    break;
                case 5:
                    System.out.print("Ingrese el puntaje de riesgo a buscar: ");
                    int buscar = scanner.nextInt();
                    Paciente encontrado = arbolTriaje.buscarPorRiesgo(buscar);
                    System.out.println(encontrado != null ? "Encontrado: " + encontrado : "No existe paciente con ese puntaje.");
                    break;
                case 6:
                    arbolTriaje.respaldarEnTxt("RespaldoTriajeJava.txt");
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 7);
        scanner.close();
    }
}