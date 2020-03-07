public class Department {

    private String name;
    private Faculty faculty;
    private DynamicArray tutors;

    public void setTutor(Tutor tutor){
        tutors.add(tutor);
    }

    public void deleteTutor(int n){
        tutors.delete(n);
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public DynamicArray getTutors() {
        return tutors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Department(String name, Faculty faculty) {
        this.name = name;
        this.faculty = faculty;
        tutors = new DynamicArray();
    }

    @Override
    public String toString() {
        return name;
    }
}
