import java.util.Scanner;

/**
 * Punto de entrada de la aplicación de gestión de estudiantes.
 * Presenta un menú de consola para ejecutar las operaciones del sistema.
 */
public class Main {
    private static final Scanner INPUT = new Scanner(System.in);
    private static final StudentManager MANAGER = new StudentManager();

    public static void main(String[] args) {
        int option;
        do {
            showMenu();
            option = readInt("Selecciona una opción: ");

            try {
                switch (option) {
                    case 1: addStudent(); break;
                    case 2: listStudents(); break;
                    case 3: searchStudent(); break;
                    case 4: updateStudent(); break;
                    case 5: deleteStudent(); break;
                    case 6:
                        System.out.printf("Promedio general: %.2f%n",
                            MANAGER.calculateAverage());
                        break;
                    case 0:
                        System.out.println("Gracias por utilizar el sistema.");
                        break;
                    default:
                        System.out.println("Opción no válida. Intenta de nuevo.");
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Dato inválido: " + ex.getMessage());
            }
            System.out.println();
        } while (option != 0);

        INPUT.close();
    }

    private static void showMenu() {
        System.out.println("===== SISTEMA DE GESTIÓN DE ESTUDIANTES =====");
        System.out.println("1. Registrar estudiante");
        System.out.println("2. Mostrar todos los estudiantes");
        System.out.println("3. Buscar estudiante por ID");
        System.out.println("4. Actualizar estudiante");
        System.out.println("5. Eliminar estudiante");
        System.out.println("6. Consultar promedio general");
        System.out.println("0. Salir");
    }

    private static void addStudent() {
        int id = readInt("ID: ");
        String name = readText("Nombre completo: ");
        String career = readText("Carrera: ");
        double grade = readDouble("Calificación (0 a 100): ");

        Student student = new Student(id, name, career, grade);
        if (MANAGER.addStudent(student)) {
            System.out.println("Estudiante registrado correctamente.");
        } else {
            System.out.println("No se registró: ya existe un estudiante con ese ID.");
        }
    }

    private static void listStudents() {
        if (MANAGER.getStudentCount() == 0) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        System.out.println("--- Lista de estudiantes ---");
        for (Student student : MANAGER.getAllStudents()) {
            System.out.println(student);
        }
    }

    private static void searchStudent() {
        int id = readInt("ID que deseas buscar: ");
        Student student = MANAGER.findStudent(id);
        System.out.println(student == null ? "No se encontró el estudiante." : student);
    }

    private static void updateStudent() {
        int id = readInt("ID del estudiante que deseas actualizar: ");
        if (MANAGER.findStudent(id) == null) {
            System.out.println("No se encontró el estudiante.");
            return;
        }
        String name = readText("Nuevo nombre: ");
        String career = readText("Nueva carrera: ");
        double grade = readDouble("Nueva calificación (0 a 100): ");

        MANAGER.updateStudent(id, name, career, grade);
        System.out.println("Datos actualizados correctamente.");
    }

    private static void deleteStudent() {
        int id = readInt("ID del estudiante que deseas eliminar: ");
        System.out.println(MANAGER.deleteStudent(id)
            ? "Estudiante eliminado correctamente."
            : "No se encontró el estudiante.");
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            String value = INPUT.nextLine().trim();
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException ex) {
                System.out.println("Escribe un número entero válido.");
            }
        }
    }

    private static double readDouble(String message) {
        while (true) {
            System.out.print(message);
            String value = INPUT.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(value);
            } catch (NumberFormatException ex) {
                System.out.println("Escribe una calificación numérica válida.");
            }
        }
    }

    private static String readText(String message) {
        System.out.print(message);
        return INPUT.nextLine().trim();
    }
}
