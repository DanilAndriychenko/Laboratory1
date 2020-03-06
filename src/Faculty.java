public class Faculty {

    private String name;
    private DynamicArray specialities;
    private DynamicArray departments;

    Faculty(String name) {
        this.name = name;
        specialities = new DynamicArray();
        departments = new DynamicArray();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addNewSpeciality(String name) {
        specialities.add(new Speciality(name, this));
    }

    public void addNewDepartment(String name) {
        departments.add(new Department(name, this));
    }

    public DynamicArray getDepartments() {
        return departments;
    }

    public DynamicArray getSpecialities() {
        return specialities;
    }

    @Override
    public String toString() {
        return (name);
    }
}
