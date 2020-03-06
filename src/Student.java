public class Student {

    private String name;
    private Faculty faculty;
    private Speciality speciality;
    private int course;

    Student(String name, Faculty faculty, Speciality speciality, int course) {
        this.name = name;
        this.faculty = faculty;
        this.speciality = speciality;
        this.course = course;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public int getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return ("Student " + name + " studies on " + course + " course on speciality " + speciality + " of " + faculty + ".");
    }
}
