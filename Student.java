import java.util.Objects;

/**
 * Representa a un estudiante dentro del sistema.
 * Contiene sus datos personales y la calificación final.
 */
public class Student {
    private final int id;
    private String name;
    private String career;
    private double grade;

    /**
     * Constructor: inicializa un estudiante con sus datos.
     */
    public Student(int id, String name, String career, double grade) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que cero.");
        }
        setName(name);
        setCareer(career);
        setGrade(grade);
        this.id = id;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCareer() { return career; }
    public double getGrade() { return grade; }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.name = name.trim();
    }

    public void setCareer(String career) {
        if (career == null || career.isBlank()) {
            throw new IllegalArgumentException("La carrera no puede estar vacía.");
        }
        this.career = career.trim();
    }

    public void setGrade(double grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("La calificación debe estar entre 0 y 100.");
        }
        this.grade = grade;
    }

    /** Devuelve si el estudiante aprobó con calificación mínima de 70. */
    public boolean isApproved() {
        return grade >= 70;
    }

    /** Genera una descripción legible del estudiante. */
    @Override
    public String toString() {
        return String.format(
            "ID: %d | Nombre: %s | Carrera: %s | Calificación: %.2f | Estado: %s",
            id, name, career, grade, isApproved() ? "Aprobado" : "No aprobado"
        );
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Student)) return false;
        Student student = (Student) other;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
