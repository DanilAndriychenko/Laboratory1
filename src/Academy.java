import java.util.concurrent.TimeUnit;

public class Academy {

    private static DynamicArray faculties, students;

    public static void main(String[] args) {

        faculties = new DynamicArray();
        students = new DynamicArray();

        while (true) {
            performAction(askForAction());
        }

    }

    private static int askForAction() {
        System.out.println("Please, choose action from the list below:\n" +
                "1. Add/edit/delete faculty;\n" +
                "2. Add/edit/delete department on some faculty;\n" +
                "3. Add/edit/delete speciality on some faculty;\n" +
                "4. Add/edit/delete student on some speciality;\n" +
                "5. Add/edit/delete tutor on some department;\n" +
                "6. Find student by full name, course or speciality;\n" +
                "7. Display all students sorted by course;\n" +
                "8. Display all students on some faculty sorted by full name;\n" +
                "9. Display all tutors on some faculty sorted by full name;\n" +
                "10. Display all students on some speciality sorted by course;\n" +
                "11. Display all students on some speciality sorted by full name;\n" +
                "12. Display all tutors on some department sorted by full name;\n" +
                "13. Display all students on some speciality and course;\n" +
                "14. Display all students on some speciality and course sorted by full name;");
        return Utility.nextActionNum(1, 14);
    }

    private static void performAction(int action) {
        switch (action) {
            case 1:
                performFirstCase();
                break;
            case 2:
                performSecondCase();
                break;
            case 3:
                performThirdCase();
        }
    }

    private static void performFirstCase() {
        if (faculties.getRealLength() == 0) {
            System.out.println("List of faculties is empty.\n" +
                    "Do you want to add one?[y/n]");
            char yn = DataInput.getChar();
            if (yn == 'y') addNewFaculty();
        } else {
            System.out.println("List of faculties:");
            for (int i = 0; i < faculties.getRealLength(); i++) System.out.println(faculties.get(i));
            System.out.println("Choose an action:\n" +
                    "1. Add new faculty; \n" +
                    "2. Edit a faculty's name; \n" +
                    "3. Delete a faculty;\n" +
                    "4. Back to the previous menu;");
            switch (Utility.nextActionNum(1, 4)) {
                case 1:
                    addNewFaculty();
                    break;
                case 2:
                    String oldName = DataInput.getString("Enter old faculty's name: ");
                    for (int i = 0; i < faculties.getRealLength(); i++) {
                        if (faculties.get(i).toString().equals(oldName)) {
                            faculties.delete(i);
                            addNewFaculty();
                            break;
                        }
                        if (i == faculties.getRealLength() - 1) {
                            System.out.println("You have input incorrect name. Changes cannot be done.");
                            try {
                                TimeUnit.SECONDS.sleep(3);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    break;
                case 3:
                    oldName = DataInput.getString("Enter old faculty's name: ");
                    for (int i = 0; i < faculties.getRealLength(); i++) {
                        if (faculties.get(i).toString().equals(oldName)) {
                            faculties.delete(i);
                            break;
                        }
                        if (i == faculties.getRealLength() - 1) {
                            System.out.println("You have input incorrect name. Changes cannot be done.");
                            try {
                                TimeUnit.SECONDS.sleep(3);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    break;
                case 4:
                    return;
            }
        }
    }

    private static void addNewFaculty() {
        String name;
        System.out.println("Enter the name of new faculty: ");
        do {
            name = DataInput.getString();
            if (!Utility.lineContainsOnlyLetters(name)) System.out.println("Incorrect value. Enter again: ");
            else if (!NameIsUniqueInDynamicArray(name, faculties))
                System.out.println("There is a faculty with the same name. Create a unique one.");
        } while (!(Utility.lineContainsOnlyLetters(name) && NameIsUniqueInDynamicArray(name, faculties)));
        faculties.add(new Faculty(name));
    }

    private static boolean NameIsUniqueInDynamicArray(String name, DynamicArray dynamicArray) {
        for (int i = 0; i < dynamicArray.getRealLength(); i++) {
            if (dynamicArray.get(i).toString().equals(name)) return false;
        }
        return true;
    }

    private static void performSecondCase() {
        if (faculties.getRealLength() == 0) {
            System.out.println("List of faculties is empty.\n" +
                    "Before adding/editing/deleting department you need to create at least one faculty.\n");
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Choose faculty which department you want to add/edit/delete.\n" +
                    "List of faculties:");
            for (int i = 0; i < faculties.getRealLength(); i++) System.out.println("" + (i+1) + ". " + faculties.get(i));
            int chosenNumOfFaculty = Utility.nextActionNum(1, faculties.getRealLength()) - 1;
            Faculty chosenFaculty = (Faculty) faculties.get(chosenNumOfFaculty);
            if (chosenFaculty.getDepartments().getRealLength() == 0) {
                System.out.println("List of departments on " + chosenFaculty + " is empty.\n" +
                        "Do you want to add one?[y/n]");
                char yn = DataInput.getChar();
                if (yn == 'y') {
                    addNewDepartmentOnChosenFaculty(chosenFaculty);
                    return;
                }
            }
            else {
                System.out.println("List of departments:");
                for (int i = 0; i < chosenFaculty.getDepartments().getRealLength(); i++) System.out.println(chosenFaculty.getDepartments().get(i));
            }
            System.out.println("Choose an action:\n" +
                    "1. Add new department; \n" +
                    "2. Edit a department's name; \n" +
                    "3. Delete a department;\n" +
                    "4. Back to the previous menu;");
            switch (Utility.nextActionNum(1, 4)) {
                case 1:
                    addNewDepartmentOnChosenFaculty(chosenFaculty);
                    break;
                case 2:
                    String oldName = DataInput.getString("Enter old department's name: ");
                    DynamicArray givenDepartments = chosenFaculty.getDepartments();
                    for (int i = 0; i < givenDepartments.getRealLength(); i++) {
                        if (givenDepartments.get(i).toString().equals(oldName)) {
                            givenDepartments.delete(i);
                            addNewDepartmentOnChosenFaculty(chosenFaculty);
                            break;
                        }
                        if (i == givenDepartments.getRealLength() - 1) {
                            System.out.println("You have input incorrect name. Changes cannot be done.");
                            try {
                                TimeUnit.SECONDS.sleep(3);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    break;
                case 3:
                    oldName = DataInput.getString("Enter old departments's name: ");
                    givenDepartments = chosenFaculty.getDepartments();
                    for (int i = 0; i < givenDepartments.getRealLength(); i++) {
                        if (givenDepartments.get(i).toString().equals(oldName)) {
                            givenDepartments.delete(i);
                            break;
                        }
                        if (i == givenDepartments.getRealLength() - 1) {
                            System.out.println("You have input incorrect name. Changes cannot be done.");
                            try {
                                TimeUnit.SECONDS.sleep(3);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    break;
                case 4:
                    return;
            }
        }
    }

    private static void addNewDepartmentOnChosenFaculty (Faculty chosenFaculty) {
        String name;
        DynamicArray givenDepartments = chosenFaculty.getDepartments();
        System.out.println("Enter the name of new department: ");
        do {
            name = DataInput.getString();
            if (!Utility.lineContainsOnlyLetters(name)) System.out.println("Incorrect value. Enter again: ");
            else if (!NameIsUniqueInDynamicArray(name, givenDepartments))
                System.out.println("There is a department with the same name. Create a unique one.");
        } while (!(Utility.lineContainsOnlyLetters(name) && NameIsUniqueInDynamicArray(name, givenDepartments)));
        givenDepartments.add(new Department(name, chosenFaculty));
    }

    private static void performThirdCase() {
        if (faculties.getRealLength() == 0) {
            System.out.println("List of faculties is empty.\n" +
                    "Before adding/editing/deleting speciality you need to create at least one faculty.\n");
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Choose faculty which speciality you want to add/edit/delete.\n" +
                    "List of faculties:");
            for (int i = 0; i < faculties.getRealLength(); i++) System.out.println("" + (i+1) + ". " + faculties.get(i));
            int chosenNumOfFaculty = Utility.nextActionNum(1, faculties.getRealLength()) - 1;
            Faculty chosenFaculty = (Faculty) faculties.get(chosenNumOfFaculty);
            if (chosenFaculty.getSpecialities().getRealLength() == 0) {
                System.out.println("List of specialities on " + chosenFaculty + " is empty.\n" +
                        "Do you want to add one?[y/n]");
                char yn = DataInput.getChar();
                if (yn == 'y') {
                    addNewSpecialityOnChosenFaculty(chosenFaculty);
                    return;
                }
            }
            else {
                System.out.println("List of specialities:");
                for (int i = 0; i < chosenFaculty.getSpecialities().getRealLength(); i++) System.out.println(chosenFaculty.getSpecialities().get(i));
            }
            System.out.println("Choose an action:\n" +
                    "1. Add new speciality; \n" +
                    "2. Edit a speciality's name; \n" +
                    "3. Delete a speciality;\n" +
                    "4. Back to the previous menu;");
            switch (Utility.nextActionNum(1, 4)) {
                case 1:
                    addNewSpecialityOnChosenFaculty(chosenFaculty);
                    break;
                case 2:
                    String oldName = DataInput.getString("Enter old speciality's name: ");
                    DynamicArray givenSpecialities = chosenFaculty.getSpecialities();
                    for (int i = 0; i < givenSpecialities.getRealLength(); i++) {
                        if (givenSpecialities.get(i).toString().equals(oldName)) {
                            givenSpecialities.delete(i);
                            addNewSpecialityOnChosenFaculty(chosenFaculty);
                            break;
                        }
                        if (i == givenSpecialities.getRealLength() - 1) {
                            System.out.println("You have input incorrect name. Changes cannot be done.");
                            try {
                                TimeUnit.SECONDS.sleep(3);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    break;
                case 3:
                    oldName = DataInput.getString("Enter old speciality's name: ");
                    givenSpecialities = chosenFaculty.getDepartments();
                    for (int i = 0; i < givenSpecialities.getRealLength(); i++) {
                        if (givenSpecialities.get(i).toString().equals(oldName)) {
                            givenSpecialities.delete(i);
                            break;
                        }
                        if (i == givenSpecialities.getRealLength() - 1) {
                            System.out.println("You have input incorrect name. Changes cannot be done.");
                            try {
                                TimeUnit.SECONDS.sleep(3);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    break;
                case 4:
                    return;
            }
        }
    }

    private static void addNewSpecialityOnChosenFaculty (Faculty chosenFaculty) {
        String name;
        DynamicArray givenSpecialities = chosenFaculty.getSpecialities();
        System.out.println("Enter the name of new speciality: ");
        do {
            name = DataInput.getString();
            if (!Utility.lineContainsOnlyLetters(name)) System.out.println("Incorrect value. Enter again: ");
            else if (!NameIsUniqueInDynamicArray(name, givenSpecialities))
                System.out.println("There is a speciality with the same name. Create a unique one.");
        } while (!(Utility.lineContainsOnlyLetters(name) && NameIsUniqueInDynamicArray(name, givenSpecialities)));
        givenSpecialities.add(new Department(name, chosenFaculty));
    }
}