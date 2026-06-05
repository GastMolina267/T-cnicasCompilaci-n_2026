# Manual de Usuario y Guía de Navegación del Proyecto

¡Bienvenido al proyecto del **Compilador de C++ a Código de Tres Direcciones (TAC) y Optimizador**! Este documento está diseñado para ayudarte a navegar por el repositorio, comprender la estructura del código y aprender a compilar y ejecutar el compilador en cuestión de minutos.

---

## 📂 1. Mapa del Proyecto (Estructura de Directorios)

Para entender rápidamente dónde está ubicado cada componente, aquí tienes una descripción de la estructura principal:

```
Ejercicios_Sintacticos-ejercicio1/
│
├── Ejercicio/demo/                      # Carpeta principal del código fuente (Proyecto Maven)
│   ├── src/
│   │   ├── main/
│   │   │   ├── antlr4/                  # Gramática formal del lenguaje (.g4)
│   │   │   │   └── com/compilador/MiLenguaje.g4
│   │   │   │
│   │   │   └── java/com/compilador/     # Código fuente en Java
│   │   │       ├── App.java             # Clase principal (Orquestador y CLI)
│   │   │       ├── TablaSimbolos.java   # Gestión de variables y ámbitos locales/globales
│   │   │       ├── SemanticVisitor.java # Chequeo de tipos, variables no declaradas/no usadas
│   │   │       ├── CodigoVisitor.java   # Generador de Código de Tres Direcciones (TAC)
│   │   │       ├── Instruccion.java     # Representación del formato cuádruple de TAC
│   │   │       └── Optimizador.java     # Optimizador multipaso (folding, propagación, etc.)
│   │   │
│   │   └── test/java/com/compilador/    # Tests unitarios del proyecto
│   │
│   ├── ejemplo.txt                      # Caso de prueba básico sin errores
│   ├── ejemplo_optimizacion.txt         # Caso de prueba enfocado en optimizaciones avanzadas
│   ├── ejemplo_errores.txt              # Caso de prueba para verificar reporte de errores semánticos
│   ├── compilador.sh                    # Script auxiliar para ejecutar el compilador en Unix
│   └── pom.xml                          # Archivo de configuración de dependencias de Maven
│
├── README.md                            # Resumen y presentación del repositorio en GitHub
├── informe_tecnico_compilador.md        # Documentación teórica y técnica del diseño del compilador
└── manual_usuario.md                    # Esta guía (Manual del usuario)
```

---

## ⚙️ 2. Requisitos Previos

Antes de compilar y ejecutar el proyecto, asegúrate de tener instalado en tu computadora:
1. **Java Development Kit (JDK) 8** o superior.
2. **Apache Maven** (gestor de dependencias).
3. Acceso a una terminal de comandos (PowerShell, Command Prompt o Bash).

---

## 🛠️ 3. Instrucciones de Compilación e Instalación

El proyecto utiliza Maven para gestionar dependencias (como la biblioteca ANTLR4 y sus utilidades). Sigue estos pasos para compilarlo desde cero:

1. Abre una terminal de comandos.
2. Navega hasta la carpeta del proyecto Maven (`Ejercicio/demo`):
   ```bash
   cd Ejercicio/demo
   ```
3. Ejecuta el comando de compilación de Maven:
   ```bash
   mvn clean package
   ```
   *Este comando compilará el código Java, generará los parsers automáticos a partir de la gramática `.g4`, correrá los tests unitarios y creará un archivo ejecutable empaquetado en `target/demo-1.0-jar-with-dependencies.jar`.*

---

## 🚀 4. Guía de Uso del Compilador

Una vez compilado el proyecto, puedes ejecutar el compilador sobre cualquier archivo de código fuente (`.txt` o `.cpp`) usando la máquina virtual de Java.

### Comando Básico de Ejecución
Desde la carpeta `Ejercicio/demo`, ejecuta:
```bash
java -jar target/demo-1.0-jar-with-dependencies.jar <ruta-al-archivo>
```

### Ejemplos Prácticos de Prueba:

*   **Para probar el flujo correcto con variables, funciones y arrays (ejemplo base):**
    ```bash
    java -jar target/demo-1.0-jar-with-dependencies.jar ejemplo.txt
    ```
    *(Nota: Se abrirá una ventana interactiva de Java Swing que te mostrará el Árbol Sintáctico (AST) de forma gráfica. Al cerrarla, la ejecución continuará en la consola).*

*   **Para ver la potencia del optimizador en acción:**
    ```bash
    java -jar target/demo-1.0-jar-with-dependencies.jar ejemplo_optimizacion.txt
    ```

*   **Para ver cómo se detiene la compilación y se reportan los errores semánticos:**
    ```bash
    java -jar target/demo-1.0-jar-with-dependencies.jar ejemplo_errores.txt
    ```

---

## 📊 5. Interpretación de la Consola (Reportes)

El compilador cuenta con un reporte coloreado por consola para facilitar la lectura del análisis:

*   **Verde (`ANSI_GREEN`)**: Indica éxito en el análisis de una fase o estadísticas de código optimizado (por ejemplo: `✅ Análisis léxico completado sin errores`).
*   **Amarillo (`ANSI_YELLOW`)**: Indica advertencias (*warnings*) que no detienen la compilación pero sugieren mejoras de código (ej. variables declaradas pero nunca leídas).
*   **Rojo (`ANSI_RED`)**: Representa errores críticos de tipo léxico, sintáctico o semántico. Detienen inmediatamente el compilador.

---

## 📄 6. Archivos Generados

Al compilar un archivo fuente (por ejemplo, `codigo.txt`), el compilador creará automáticamente dos archivos de salida en el mismo directorio donde se encuentra el archivo fuente:

1.  **`codigo_codigo_intermedio.txt`**: Contiene la secuencia plana de instrucciones de código de tres direcciones (TAC) generada directamente a partir del árbol, sin ningún tipo de optimización.
2.  **`codigo_codigo_optimizado.txt`**: Contiene el código TAC limpio después de aplicar las pasadas del optimizador (eliminando el código inalcanzable, propagando y plegando constantes, y quitando variables temporales redundantes).
