public class Department {

    String name;
    Faculty faculty;

    Department(String name, Faculty faculty) {
        this.name = name;
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return name;
    }
}
