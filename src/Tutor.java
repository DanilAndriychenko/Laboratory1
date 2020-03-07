public class Tutor {

    String name;
    Faculty faculty;
    Department department;

    Tutor(String name, Faculty faculty, Department department) {
        this.name = name;
        this.faculty = faculty;
        this.department = department;
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

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return ("Tutor " + name + " teaches at department " + department + " of " + faculty + ".");
    }
}
