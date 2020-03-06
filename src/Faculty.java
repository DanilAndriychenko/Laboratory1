public class Faculty {

    private String name;
    private DynamicArray specialities;
    private DynamicArray departments;

    Faculty(String name) {
        this.name = name;
        specialities = new DynamicArray();
        departments = new DynamicArray();
    }

    public DynamicArray getSpecialities(){
        return specialities;
    }

    public Speciality getSpeciality(int n){
        if (n > specialities.getRealLength())
            return null;
        else
            return (Speciality)specialities.get(n);
    }

    public void addSpeciality(Speciality speciality){
        specialities.add(speciality);
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

    @Override
    public String toString() {
        return (name);
    }
}
