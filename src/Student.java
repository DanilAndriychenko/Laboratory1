public class Student {

    String name;
    Faculty faculty;
    Speciality speciality;
    int course;

    Student(String name, Faculty faculty, Speciality speciality, int course) {
        this.name = name;
        this.faculty = faculty;
        this.speciality = speciality;
        this.course = course;
    }

    @Override
    public String toString() {
        return ("Student " + name + " studies on " + course + " course on speciality " + speciality + " of " + faculty + ".");
    }
}
