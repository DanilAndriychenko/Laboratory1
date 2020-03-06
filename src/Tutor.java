public class Tutor {

    String name;
    Faculty faculty;
    Department department;

    Tutor(String name, Faculty faculty, Department department) {
        this.name = name;
        this.faculty = faculty;
        this.department = department;
    }

    @Override
    public String toString() {
        return ("Tutor " + name + " teaches at department " + department + " of " + faculty + ".");
    }
}
