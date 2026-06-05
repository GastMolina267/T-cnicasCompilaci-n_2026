#!/bin/bash

# Clean and compile the project using Maven
echo "🧹 Limpiando y compilando el compilador con Maven..."
mvn clean package

# Run base example
echo "🚀 Ejecutando el compilador con el ejemplo base (ejemplo.txt)..."
java -jar target/demo-1.0-jar-with-dependencies.jar ejemplo.txt

echo ""
echo "✅ Compilación completada con éxito. Comandos para ejecutar otros ejemplos:"
echo "👉 Ejemplo de optimizaciones (constant folding, algebraic simplifications, dead code):"
echo "   java -jar target/demo-1.0-jar-with-dependencies.jar ejemplo_optimizacion.txt"
echo ""
echo "👉 Ejemplo con errores semánticos (para ver la detección de errores y warnings):"
echo "   java -jar target/demo-1.0-jar-with-dependencies.jar ejemplo_errores.txt"
