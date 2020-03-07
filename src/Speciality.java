public class Speciality {

    private String name;
    private Faculty faculty;
    private DynamicArray students;

    Speciality(String name, Faculty faculty) {
        this.name = name;
        this.faculty = faculty;
        this.students = new DynamicArray();
    }

    Speciality(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public DynamicArray getStudents() {
        return students;
    }

    public void addStudent(Student newStudent) {
        students.add(newStudent);
    }

    @Override
    public String toString() {
        return name;
    }
}
