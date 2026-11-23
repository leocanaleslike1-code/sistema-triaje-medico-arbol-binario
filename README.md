# Sistema de Triaje Medico - Arbol Binario (.NET y Java)

## 📌 Descripcion del Proyecto
Este proyecto implementa una solucion de software para la gestion y clasificacion de pacientes en un sistema de triaje medico de urgencias. La organizacion de la informacion se realiza mediante una estructura no lineal de **Arbol Binario de Busqueda (BST)**, utilizando el puntaje de riesgo del paciente (en una escala de 1 a 100) como criterio de ordenamiento.

El repositorio contiene dos implementaciones completas:
1. **Version .NET (C#):** Desarrollada como aplicacion de consola en Visual Studio, incorporando exportacion de datos a archivos `.txt`.
2. **Version Java:** Migrada para su ejecucion en el entorno Apache NetBeans.

---

## 🛠️ Tecnologias Utilizadas
* **Lenguajes:** C# (.NET 8.0 / 10.0) y Java (JDK 8+)
* **IDEs:** Visual Studio Community / Apache NetBeans
* **Estructura de Datos:** Arbol Binario de Busqueda (BST)
* **Persistencia:** Archivos de texto plano (`.txt`)

---

## 📑 Levantamiento de Requerimientos

### 1. Requerimientos Funcionales (RF)
* **RF-01 (Registro de Pacientes):** El sistema debe registrar pacientes capturando nombre, cedula, sintoma principal y puntaje de riesgo (1 a 100).
* **RF-02 (Estructura en BST):** El sistema debe organizar automaticamente a los pacientes en un Arbol Binario de Busqueda, ubicando los de menor puntaje a la izquierda y los de mayor o igual puntaje a la derecha de la raiz.
* **RF-03 (Recorrido InOrden):** El sistema debe listar los pacientes ordenados de menor a mayor gravedad utilizando el recorrido recursivo InOrden.
* **RF-04 (Paciente Mas Critico):** El sistema debe identificar al paciente con mayor puntaje de riesgo accediendo directamente al nodo del extremo derecho del arbol.
* **RF-05 (Busqueda Binaria):** El sistema debe permitir consultar un paciente especifico por su puntaje de riesgo exacto.
* **RF-06 (Respaldo en TXT):** El sistema debe exportar los datos del arbol ordenados a un archivo de texto plano (`.txt`).

### 2. Requerimientos No Funcionales (RNF)
* **RNF-01 (Interoperabilidad):** El sistema debe funcionar de manera equivalente tanto en la plataforma .NET como en la JVM de Java.
* **RNF-02 (Eficiencia Algoritmica):** Las operaciones de insercion y busqueda en el arbol deben mantener una complejidad promedio de O(log n).
* **RNF-03 (Persistencia Local):** Generacion de respaldos en archivos locales de texto sin dependencia de motores de base de datos relacionales.

### 3. Requerimientos de Dominio (RD)
* **RD-01 (Escala de Triaje):** La priorizacion del paciente se rige estrictamente por la escala numerica estandarizada de 1 a 100 del servicio de urgencias.

---

## 📋 Product Backlog (Historias de Usuario)

| ID | Historia de Usuario | Criterios de Aceptacion | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **US-01** | Como desarrollador, quiero crear las clases `Paciente` y `NodoArbol` para definir los atributos y referencias. | Encapsulamiento correcto y punteros/referencias `Izquierdo` y `Derecho`. | Alta | Completado |
| **US-02** | Como operador, quiero insertar pacientes segun su puntaje de riesgo para construir el arbol de forma jerarquica. | Insercion recursiva funcional diferenciando ramas izquierda y derecha. | Alta | Completado |
| **US-03** | Como medico, quiero listar los pacientes mediante el recorrido InOrden para atender en orden de gravedad. | Impresion continua en consola ordenada de menor a mayor riesgo. | Media | Completado |
| **US-04** | Como personal de urgencias, quiero consultar el paciente mas critico para atencion prioritaria. | Retorno exacto del nodo situado en el extremo derecho del arbol. | Media | Completado |
| **US-05** | Como administrador, quiero exportar la informacion del arbol a un archivo `.txt` para mantener respaldos. | Generacion exitosa del archivo de texto plano con formato estructurado. | Baja | Completado |
| **US-06** | Como equipo, queremos portar el sistema a Java para validar la interoperabilidad entre ecosistemas. | Ejecucion impecable de la aplicacion de consola en Apache NetBeans. | Alta | Completado |

---

## 🚀 Estructura del Codigo y Ejecucion

### Estructura de Clases
* **`Paciente`**: Clase entidad que encapsula la informacion personal y clinica del usuario.
* **`NodoArbol`**: Clase estructural que contiene la instancia del paciente y las referencias a los nodos hijos.
* **`ArbolBinarioTriaje`**: Clase controladora con la logica del BST (insercion, recorridos, busquedas y respaldo TXT).
* **`Program` / `Main`**: Punto de entrada con el menu interactivo de consola.

### Instrucciones de Ejecucion
1. **Clonar el repositorio:**
   ```bash
   git clone [https://github.com/TU_USUARIO/TU_REPOSITORIO.git](https://github.com/TU_USUARIO/TU_REPOSITORIO.git)
