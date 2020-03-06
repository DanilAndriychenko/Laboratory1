public class Speciality {

    String name;
    Faculty faculty;

    Speciality(String name, Faculty faculty) {
        this.name = name;
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return name;
    }
}
