# Sistema de Gestión de Estudiantes (Java)

Aplicación de consola desarrollada con Java y programación orientada a objetos. No requiere bibliotecas externas.

## Requisitos
- JDK 17 o posterior (también puede funcionar con versiones anteriores compatibles).
- IntelliJ IDEA, Eclipse o NetBeans, o una terminal.

## Estructura
- `src/Student.java`: clase que representa a un estudiante; contiene atributos, constructor, getters/setters y método de aprobación.
- `src/StudentManager.java`: administra los registros mediante un `LinkedHashMap` y contiene operaciones CRUD y cálculo de promedio.
- `src/Main.java`: menú interactivo y punto de entrada.

## Compilar y ejecutar desde la carpeta del proyecto
```bash
javac -d out src/*.java
java -cp out Main
```

En Windows también puedes ejecutar los comandos anteriores desde CMD o PowerShell, siempre que el JDK esté agregado al PATH.

## Funcionalidades
1. Registrar estudiantes.
2. Listar estudiantes.
3. Buscar por ID.
4. Actualizar nombre, carrera y calificación.
5. Eliminar por ID.
6. Calcular promedio general.

La calificación válida va de 0 a 100. Se considera aprobado a partir de 70. El ID debe ser positivo y no se permiten IDs repetidos.

## Publicar en GitHub
1. Crea un repositorio nuevo en https://github.com/ (por ejemplo, `gestion-estudiantes-java`).
2. Abre una terminal en la carpeta del proyecto.
3. Ejecuta:
```bash
git init
git add .
git commit -m "Versión inicial: gestión de estudiantes"
git branch -M main
git remote add origin https://github.com/TU-USUARIO/gestion-estudiantes-java.git
git push -u origin main
```
4. Sustituye `TU-USUARIO` por tu usuario real de GitHub.
5. Copia la URL del repositorio y agrégala al documento de entrega.

## Prueba rápida sugerida
Registra:
- ID: 1, Nombre: Ana López, Carrera: Ingeniería, Calificación: 85
- ID: 2, Nombre: Luis Pérez, Carrera: Administración, Calificación: 65

Después lista los registros y consulta el promedio. Resultado esperado: 75.00.
