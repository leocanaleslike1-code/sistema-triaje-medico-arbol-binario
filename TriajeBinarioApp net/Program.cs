using System;
using TriajeBinarioApp.Clases;

namespace TriajeBinarioApp
{
    internal class Program
    {
        static void Main(string[] args)
        {
            ArbolBinarioTriaje arbolTriaje = new ArbolBinarioTriaje();

            // Carga inicial de datos de prueba
            arbolTriaje.Insertar(new Paciente("Carlos Mendoza", "10984512", "Dolor torácico leve", 50)); // Raíz
            arbolTriaje.Insertar(new Paciente("Ana Lucía Gómez", "52418963", "Esguince de tobillo", 25)); // Izquierda
            arbolTriaje.Insertar(new Paciente("Jorge Ramírez", "80147258", "Dificultad respiratoria", 80)); // Derecha
            arbolTriaje.Insertar(new Paciente("María Fernanda Ruiz", "10203040", "Fiebre moderada", 15)); // Izquierda de 25
            arbolTriaje.Insertar(new Paciente("Luis Eduardo Torres", "79456123", "Trauma craneoencefálico", 95)); // Derecha de 80

            int opcion = 0;
            do
            {
                Console.WriteLine("\n==============================================");
                Console.WriteLine("   SISTEMA DE TRIAJE MÉDICO - ÁRBOL BINARIO   ");
                Console.WriteLine("==============================================");
                Console.WriteLine("1. Registrar nuevo paciente en el árbol");
                Console.WriteLine("2. Visualizar jerarquía del Árbol Binario");
                Console.WriteLine("3. Listar pacientes ordenados (Recorrido InOrden)");
                Console.WriteLine("4. Consultar paciente más crítico (Extremo Derecho)");
                Console.WriteLine("5. Buscar paciente por puntaje de riesgo");
                Console.WriteLine("6. Respaldar pacientes en archivo TXT"); 
                Console.WriteLine("7. Salir");
                Console.Write("Seleccione una opción: ");

                if (!int.TryParse(Console.ReadLine(), out opcion)) continue;
                Console.WriteLine();

                switch (opcion)
                {
                    case 1:
                        Console.Write("Nombre del paciente: ");
                        string nombre = Console.ReadLine() ?? "";
                        Console.Write("Cédula: ");
                        string cedula = Console.ReadLine() ?? "";
                        Console.Write("Síntoma principal: ");
                        string sintoma = Console.ReadLine() ?? "";
                        Console.Write("Puntaje de riesgo (1 - 100): ");
                        int riesgo = int.Parse(Console.ReadLine() ?? "1");
                        arbolTriaje.Insertar(new Paciente(nombre, cedula, sintoma, riesgo));
                        Console.WriteLine("Paciente insertado correctamente en la estructura.");
                        break;

                    case 2:
                        Console.WriteLine("--- ESTRUCTURA JERÁRQUICA DE NODOS ---");
                        arbolTriaje.ImprimirEstructura();
                        break;

                    case 3:
                        Console.WriteLine("--- LISTADO ORDENADO POR GRAVEDAD (INORDEN) ---");
                        arbolTriaje.MostrarInOrden();
                        break;

                    case 4:
                        var critico = arbolTriaje.ObtenerMasCritico();
                        Console.WriteLine(critico != null
                            ? $"ALERTA MÁXIMA: {critico}"
                            : "No hay pacientes registrados.");
                        break;

                    case 5:
                        Console.Write("Ingrese el puntaje de riesgo a buscar: ");
                        int buscar = int.Parse(Console.ReadLine() ?? "0");
                        var encontrado = arbolTriaje.BuscarPorRiesgo(buscar);
                        Console.WriteLine(encontrado != null
                            ? $"Resultado encontrado: {encontrado}"
                            : "No existe un paciente con ese puntaje exacto.");
                        break;

                    case 6:
                        arbolTriaje.RespaldarEnTxt("RespaldoTriaje.txt");
                        break;

                    case 7:
                        Console.WriteLine("Saliendo del sistema de triaje...");
                        break;

                    default:
                        Console.WriteLine("Opción no válida. Intente de nuevo.");
                        break;
                }
            } while (opcion != 7);
        }
    }
}