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
                "3. Add/edit/delete student on some speciality;\n" +
                "4. Add/edit/delete tutor on some department;\n" +
                "5. Find student by full name, course or speciality;\n" +
                "6. Display all students sorted by course;\n" +
                "7. Display all students on some faculty sorted by full name;\n" +
                "8. Display all tutors on some faculty sorted by full name;\n" +
                "9. Display all students on some speciality sorted by course;\n" +
                "10. Display all students on some speciality sorted by full name;\n" +
                "11. Display all tutors on some department sorted by full name;\n" +
                "12. Display all students on some speciality and course;\n" +
                "13. Display all students on some speciality and course sorted by full name;");
        return Utility.nextActionNum(1, 13);
    }

    private static void performAction(int action) {
        switch (action) {
            case 1:
                performFirstCase();
                break;
            case 2:
                performSecondCase();
                break;
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
                    "3. Delete a faculty;");
            switch (Utility.nextActionNum(1, 3)) {
                case 1:
                    addNewFaculty();
                    break;
                case 2:
                    //TODO. If there is no faculty with "old faculty's name", ask again
                    String oldName = DataInput.getString("Enter old faculty's name: ");
                    for (int i = 0; i < faculties.getRealLength(); i++) {
                        if (faculties.get(i).toString().equals(oldName)) {
                            faculties.delete(i);
                            addNewFaculty();
                            break;
                        }
                    }
                    break;
                case 3:
                    //TODO. Same issue as in case 2
                    oldName = DataInput.getString("Enter old faculty's name: ");
                    for (int i = 0; i < faculties.getRealLength(); i++) {
                        if (faculties.get(i).toString().equals(oldName)) {
                            faculties.delete(i);
                            break;
                        }
                    }
                    break;
            }
        }
    }

    private static void addNewFaculty() {
        String name;
        System.out.println("Enter the name of new faculty: ");
        do {
            name = DataInput.getString();
            if (!Utility.lineContainsOnlyLetters(name)) System.out.println("Incorrect value. Enter again: ");
            else if (!facNameIsUnique(name))
                System.out.println("There is a faculty with the same name. Create a unique one.");
        } while (!(Utility.lineContainsOnlyLetters(name) && facNameIsUnique(name)));
        faculties.add(new Faculty(name));
    }

    private static boolean facNameIsUnique(String name) {
        for (int i = 0; i < faculties.getRealLength(); i++) {
            if (faculties.get(i).toString().equals(name)) return false;
        }
        return true;
    }

    private static void performSecondCase() {
        if (faculties.getRealLength() == 0)
            System.out.println("List of faculties is empty.\n" +
                    "Before adding/editing/deleting department you need to create at least one faculty.");
        else {
            System.out.println("Choose faculty whose department you want to add/edit/delete.\n" +
                    "List of faculties:");
            for (int i = 0; i < faculties.getRealLength(); i++) System.out.println(faculties.get(i));
            //TODO. Add numeration to displaying list. Then ask num of faculty user want to add/edit/delete.
            //TODO. Create var <Faculty> where we gonna store  chosen one. Make switch for actions with departments.
        }
    }
}