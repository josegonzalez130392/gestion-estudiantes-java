import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Administra el conjunto de estudiantes y sus operaciones principales.
 */
public class StudentManager {
    // LinkedHashMap conserva el orden de registro y evita IDs duplicados.
    private final Map<Integer, Student> students = new LinkedHashMap<>();

    /** Registra un estudiante. Devuelve false si el ID ya existe. */
    public boolean addStudent(Student student) {
        if (student == null || students.containsKey(student.getId())) {
            return false;
        }
        students.put(student.getId(), student);
        return true;
    }

    /** Busca un estudiante por su ID; devuelve null si no existe. */
    public Student findStudent(int id) {
        return students.get(id);
    }

    /** Actualiza los datos editables de un estudiante. */
    public boolean updateStudent(int id, String name, String career, double grade) {
        Student student = findStudent(id);
        if (student == null) return false;

        // Los setters validan los nuevos datos antes de asignarlos.
        student.setName(name);
        student.setCareer(career);
        student.setGrade(grade);
        return true;
    }

    /** Elimina un estudiante por su ID. */
    public boolean deleteStudent(int id) {
        return students.remove(id) != null;
    }

    /** Proporciona todos los estudiantes registrados. */
    public Collection<Student> getAllStudents() {
        return students.values();
    }

    /** Calcula el promedio general; devuelve 0 si no hay registros. */
    public double calculateAverage() {
        if (students.isEmpty()) return 0.0;

        double total = 0.0;
        for (Student student : students.values()) {
            total += student.getGrade();
        }
        return total / students.size();
    }

    public int getStudentCount() {
        return students.size();
    }
}
