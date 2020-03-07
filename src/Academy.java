import java.util.concurrent.TimeUnit;

public class Academy {

    private static DynamicArray faculties, students, tutors;

    public static void main(String[] args) {

        Academy academy = new Academy();

        faculties = new DynamicArray();
        students = new DynamicArray();
        tutors = new DynamicArray();

        while (true) {
            academy.performAction(academy.askForAction());
        }

    }

    private int askForAction() {
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
        return Utility.readNumInGivenRange(1, 14);
    }

    private void performAction(int action) {
        switch (action) {
            case 1:
                performFirstCase();
                break;
            case 2:
                performSecondCase();
                break;
            case 3:
                performThirdCase();
                break;
            case 4:
                performFourthCase();
                break;
            case 5:
                performFifthCase();
                break;
            case 7:
                performSeventhCase();
                break;
            case 8:
                performEightCase();
                break;
            case 9:
                performNinthCase();
                break;
            case 10:
                performTenthCase();
                break;
            case 11:
                performEleventhCase();
                break;
            case 12:
                performTwelvesCase();
                break;
            case 13:
                performThirteenthCase();
                break;
            case 14:
                performFourteenthCase();
        }
    }

    private void performFirstCase() {
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
            switch (Utility.readNumInGivenRange(1, 4)) {
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
            }
        }
    }

    private void performSecondCase() {
        if (faculties.getRealLength() == 0) {
            System.out.println("List of faculties is empty.\n" +
                    "Before adding/editing/deleting department you need to create at least one faculty.\n");
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Choose faculty which department you want to add/edit/delete.\n" +
                    "List of faculties:");
            for (int i = 0; i < faculties.getRealLength(); i++)
                System.out.println("" + (i + 1) + ". " + faculties.get(i));
            int chosenNumOfFaculty = Utility.readNumInGivenRange(1, faculties.getRealLength()) - 1;
            Faculty chosenFaculty = (Faculty) faculties.get(chosenNumOfFaculty);
            if (chosenFaculty.getDepartments().getRealLength() == 0) {
                System.out.println("List of departments on " + chosenFaculty + " is empty.\n" +
                        "Do you want to add one?[y/n]");
                char yn = DataInput.getChar();
                if (yn == 'y') {
                    addNewDepartmentOnChosenFaculty(chosenFaculty);
                    return;
                }
            } else {
                System.out.println("List of departments:");
                for (int i = 0; i < chosenFaculty.getDepartments().getRealLength(); i++)
                    System.out.println(chosenFaculty.getDepartments().get(i));
            }
            System.out.println("Choose an action:\n" +
                    "1. Add new department; \n" +
                    "2. Edit a department's name; \n" +
                    "3. Delete a department;\n" +
                    "4. Back to the previous menu;");
            switch (Utility.readNumInGivenRange(1, 4)) {
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
            }
        }
    }

    private void performThirdCase() {
        if (faculties.getRealLength() == 0) {
            System.out.println("List of faculties is empty.\n" +
                    "Before adding/editing/deleting speciality you need to create at least one faculty.\n");
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Choose faculty which speciality you want to add/edit/delete.\n" +
                    "List of faculties:");
            for (int i = 0; i < faculties.getRealLength(); i++)
                System.out.println("" + (i + 1) + ". " + faculties.get(i));
            int chosenNumOfFaculty = Utility.readNumInGivenRange(1, faculties.getRealLength()) - 1;
            Faculty chosenFaculty = (Faculty) faculties.get(chosenNumOfFaculty);
            if (chosenFaculty.getSpecialities().getRealLength() == 0) {
                System.out.println("List of specialities on " + chosenFaculty + " is empty.\n" +
                        "Do you want to add one?[y/n]");
                char yn = DataInput.getChar();
                if (yn == 'y') {
                    addNewSpecialityOnChosenFaculty(chosenFaculty);
                    return;
                }
            } else {
                System.out.println("List of specialities:");
                for (int i = 0; i < chosenFaculty.getSpecialities().getRealLength(); i++)
                    System.out.println(chosenFaculty.getSpecialities().get(i));
            }
            System.out.println("Choose an action:\n" +
                    "1. Add new speciality; \n" +
                    "2. Edit a speciality's name; \n" +
                    "3. Delete a speciality;\n" +
                    "4. Back to the previous menu;");
            switch (Utility.readNumInGivenRange(1, 4)) {
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
            }
        }
    }

    private void performFourthCase() {
        Faculty chosenFaculty;
        Speciality chosenSpeciality;
        if (faculties.getRealLength() == 0) {
            System.out.println("List of faculties is empty.\n" +
                    "Do you want to add one?[y/n]");
            char yn = DataInput.getChar();
            if (yn == 'y') {
                addNewFaculty();
                performFourthCase();
            }
        } else {
            System.out.println("Choose faculty on which your speciality located.\n" +
                    "List of faculties:");
            for (int i = 0; i < faculties.getRealLength(); i++)
                System.out.println("" + (i + 1) + ". " + faculties.get(i));
            int chosenNumOfFaculty = Utility.readNumInGivenRange(1, faculties.getRealLength()) - 1;
            chosenFaculty = (Faculty) faculties.get(chosenNumOfFaculty);
            if (chosenFaculty.getSpecialities().getRealLength() == 0) {
                System.out.println("List of specialities on " + chosenFaculty + " is empty.\n" +
                        "Do you want to add one?[y/n]");
                char yn = DataInput.getChar();
                if (yn == 'y') {
                    addNewSpecialityOnChosenFaculty(chosenFaculty);
                    performFourthCase();
                }
            } else {
                System.out.println("List of specialities:");
                for (int i = 0; i < chosenFaculty.getSpecialities().getRealLength(); i++)
                    System.out.println("" + (i + 1) + ". " + chosenFaculty.getSpecialities().get(i));
                int chosenNumOfSpeciality = Utility.readNumInGivenRange(1, chosenFaculty.getSpecialities().getRealLength()) - 1;
                chosenSpeciality = (Speciality) chosenFaculty.getSpecialities().get(chosenNumOfSpeciality);
                if (chosenSpeciality.getStudents().getRealLength() == 0) {
                    System.out.println("List of students on " + chosenSpeciality + " is empty.\n" +
                            "Do you want to add one?[y/n]");
                    char yn = DataInput.getChar();
                    if (yn == 'y') {
                        addNewStudentOnChosenSpeciality(chosenSpeciality);
                    }
                }else{
                    System.out.println("Choose an action:\n" +
                            "1. Add new student; \n" +
                            "2. Edit a student; \n" +
                            "3. Delete a student;\n" +
                            "4. Back to the previous menu;");
                    switch (Utility.readNumInGivenRange(1, 4)) {
                        case 1:
                            addNewStudentOnChosenSpeciality(chosenSpeciality);
                            break;
                        case 2:
                            DynamicArray studentsOnChosenSpeciality = chosenSpeciality.getStudents();
                            System.out.println("List of students:");
                            for (int i = 0; i < studentsOnChosenSpeciality.getRealLength(); i++)
                                System.out.println("" + (i + 1) + ". " + studentsOnChosenSpeciality.get(i));
                            int chosenNumOfStudent = Utility.readNumInGivenRange(1, studentsOnChosenSpeciality.getRealLength()) - 1;
                            Student chosenStudent = (Student) studentsOnChosenSpeciality.get(chosenNumOfStudent);
                            System.out.print("Enter new student's full name(if you don't want to change it - enter space):");
                            String newName;
                            do{
                                newName = DataInput.getString();
                                if (newName.equalsIgnoreCase(" ")) {
                                    newName = chosenStudent.getName();
                                    break;
                                }
                                else if (!Utility.lineContainsOnlyLetters(newName))
                                    System.out.print("\nName must contain only letters. Please, enter again:");
                                else if (!nameIsUniqueInDynamicArray(newName, chosenSpeciality.getStudents()))
                                    System.out.print("\nThe name is not unique. Please, enter again:");
                            } while (!Utility.lineContainsOnlyLetters(newName) || !nameIsUniqueInDynamicArray(newName, chosenSpeciality.getStudents()));
                            chosenStudent.setName(newName);

                            System.out.print("Enter new student's course(if you don't want to change it - enter \"0\"):");
                            int newCourse = Utility.readNumInGivenRange(0,4);
                            if (newCourse!=0) chosenStudent.setCourse(newCourse);
                            break;
                        case 3:
                            studentsOnChosenSpeciality = chosenSpeciality.getStudents();
                            System.out.println("List of students:");
                            for (int i = 0; i < studentsOnChosenSpeciality.getRealLength(); i++)
                                System.out.println("" + (i + 1) + ". " + studentsOnChosenSpeciality.get(i));
                            System.out.print("Choose the number of student you want to delete:");
                            int numToDelete = Utility.readNumInGivenRange(1, studentsOnChosenSpeciality.getRealLength())-1;
                            studentsOnChosenSpeciality.delete(numToDelete);
                            students.delete(numToDelete);
                    }
                }
            }
        }
    }

    private void performFifthCase() {
        Faculty chosenFaculty;
        Department chosenDepartment;
        if (faculties.getRealLength() == 0) {
            System.out.println("List of faculties is empty.\n" +
                    "Do you want to add one?[y/n]");
            char yn = DataInput.getChar();
            if (yn == 'y') {
                addNewFaculty();
                performFifthCase();
            }
        } else {
            System.out.println("Choose faculty on which your department is located.\n" +
                    "List of faculties:");
            for (int i = 0; i < faculties.getRealLength(); i++)
                System.out.println("" + (i + 1) + ". " + faculties.get(i));
            int chosenNumOfFaculty = Utility.readNumInGivenRange(1, faculties.getRealLength()) - 1;
            chosenFaculty = (Faculty) faculties.get(chosenNumOfFaculty);
            if (chosenFaculty.getDepartments().getRealLength() == 0) {
                System.out.println("List of departments on " + chosenFaculty + " is empty.\n" +
                        "Do you want to add one?[y/n]");
                char yn = DataInput.getChar();
                if (yn == 'y') {
                    addNewDepartmentOnChosenFaculty(chosenFaculty);
                    performFifthCase();
                }
            } else {
                System.out.println("List of departments:");
                for (int i = 0; i < chosenFaculty.getDepartments().getRealLength(); i++)
                    System.out.println("" + (i + 1) + ". " + chosenFaculty.getDepartments().get(i));
                int chosenNumOfDepartment = Utility.readNumInGivenRange(1, chosenFaculty.getDepartments().getRealLength()) - 1;
                chosenDepartment = (Department) chosenFaculty.getDepartments().get(chosenNumOfDepartment);
                if (chosenDepartment.getTutors().getRealLength() == 0) {
                    System.out.println("List of tutors on " + chosenDepartment + " is empty.\n" +
                            "Do you want to add one?[y/n]");
                    char yn = DataInput.getChar();
                    if (yn == 'y') {
                        addNewTutorOnChosenDepartment(chosenDepartment);
                    }
                }else{
                    System.out.println("Choose an action:\n" +
                            "1. Add new tutor; \n" +
                            "2. Edit a tutor; \n" +
                            "3. Delete a tutor;\n" +
                            "4. Back to the previous menu;");
                    switch (Utility.readNumInGivenRange(1, 4)) {
                        case 1:
                            addNewTutorOnChosenDepartment(chosenDepartment);
                            break;
                        case 2:
                            DynamicArray tutorsOnChosenDepartment = chosenDepartment.getTutors();
                            System.out.println("List of tutors:");
                            for (int i = 0; i < tutorsOnChosenDepartment.getRealLength(); i++)
                                System.out.println("" + (i + 1) + ". " + tutorsOnChosenDepartment.get(i));
                            int chosenNumOfTutors = Utility.readNumInGivenRange(1, tutorsOnChosenDepartment.getRealLength()) - 1;
                            Tutor chosenTutor = (Tutor) tutorsOnChosenDepartment.get(chosenNumOfTutors);
                            System.out.print("Enter new tutor's full name(if you don't want to change it - enter space):");
                            String newName;
                            do{
                                newName = DataInput.getString();
                                if (newName.equalsIgnoreCase(" ")) {
                                    newName = chosenTutor.getName();
                                    break;
                                }
                                else if (!Utility.lineContainsOnlyLetters(newName))
                                    System.out.print("\nName must contain only letters. Please, enter again:");
                                else if (!nameIsUniqueInDynamicArray(newName, chosenDepartment.getTutors()))
                                    System.out.print("\nThe name is not unique. Please, enter again:");
                            } while (!Utility.lineContainsOnlyLetters(newName) || !nameIsUniqueInDynamicArray(newName, chosenDepartment.getTutors()));
                            chosenTutor.setName(newName);
                            break;
                        case 3:
                            tutorsOnChosenDepartment = chosenDepartment.getTutors();
                            System.out.println("List of tutors:");
                            for (int i = 0; i < tutorsOnChosenDepartment.getRealLength(); i++)
                                System.out.println("" + (i + 1) + ". " + tutorsOnChosenDepartment.get(i));
                            System.out.print("Choose the number of tutor you want to delete:");
                            int numToDelete = Utility.readNumInGivenRange(1, tutorsOnChosenDepartment.getRealLength())-1;
                            tutorsOnChosenDepartment.delete(numToDelete);
                            tutors.delete(numToDelete);
                    }
                }
            }
        }
    }

    private void performSeventhCase() {
        StringBuilder studFirstCourse = new StringBuilder();
        StringBuilder studSecondCourse = new StringBuilder();
        StringBuilder studThirdCourse = new StringBuilder();
        StringBuilder studFourthCourse = new StringBuilder();
        for (int i = 0; i < students.getRealLength(); i++) {
            switch (((Student) students.get(i)).getCourse()) {
                case 1:
                    studFirstCourse.append(students.get(i)).append("\n");
                    break;
                case 2:
                    studSecondCourse.append(students.get(i)).append("\n");
                    break;
                case 3:
                    studThirdCourse.append(students.get(i)).append("\n");
                    break;
                case 4:
                    studFourthCourse.append(students.get(i)).append("\n");
            }
        }
        System.out.println(studFirstCourse + studSecondCourse.toString() + studThirdCourse + studFourthCourse);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void performEightCase(){
        Faculty chosenFaculty;
        if (faculties.getRealLength() == 0) {
            System.out.println("List of faculties is empty.\n" +
                    "Do you want to add one?[y/n]");
            char yn = DataInput.getChar();
            if (yn == 'y') addNewFaculty();
            performEightCase();
        } else {
            System.out.println("Students of what faculty you want to be displayed?\n" +
                    "List of faculties:");
            for (int i = 0; i < faculties.getRealLength(); i++)
                System.out.println("" + (i + 1) + ". " + faculties.get(i));
            int chosenNumOfFaculty = Utility.readNumInGivenRange(1, faculties.getRealLength()) - 1;
            chosenFaculty = (Faculty) faculties.get(chosenNumOfFaculty);
            sortStudOrTutInAlphabeticOrder(students);
            for (int i=0; i<students.getRealLength(); i++) if (((Student) students.get(i)).getFaculty()==chosenFaculty)
                System.out.println(students.get(i));
        }
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void performNinthCase(){
        Faculty chosenFaculty;
        if (faculties.getRealLength() == 0) {
            System.out.println("List of faculties is empty.\n" +
                    "Do you want to add one?[y/n]");
            char yn = DataInput.getChar();
            if (yn == 'y') addNewFaculty();
            performNinthCase();
        } else {
            System.out.println("Students of what faculty you want to be displayed?\n" +
                    "List of faculties:");
            for (int i = 0; i < faculties.getRealLength(); i++)
                System.out.println("" + (i + 1) + ". " + faculties.get(i));
            int chosenNumOfFaculty = Utility.readNumInGivenRange(1, faculties.getRealLength()) - 1;
            chosenFaculty = (Faculty) faculties.get(chosenNumOfFaculty);
            sortStudOrTutInAlphabeticOrder(tutors);
            for (int i=0; i<tutors.getRealLength(); i++) if (((Tutor) tutors.get(i)).getFaculty()==chosenFaculty)
                System.out.println(tutors.get(i));
        }
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void performTenthCase() {
        Faculty chosenFaculty = null;
        Speciality chosenSpeciality = null;
        if (faculties.getRealLength() == 0) {
            System.out.println("List of faculties is empty.\n" +
                    "Do you want to add one?[y/n]");
            char yn = DataInput.getChar();
            if (yn == 'y') addNewFaculty();
            performTenthCase();
        } else {
            System.out.println("Choose faculty on which your speciality located.\n" +
                    "List of faculties:");
            for (int i = 0; i < faculties.getRealLength(); i++)
                System.out.println("" + (i + 1) + ". " + faculties.get(i));
            int chosenNumOfFaculty = Utility.readNumInGivenRange(1, faculties.getRealLength()) - 1;
            chosenFaculty = (Faculty) faculties.get(chosenNumOfFaculty);
            if (chosenFaculty.getSpecialities().getRealLength() == 0) {
                System.out.println("List of specialities on " + chosenFaculty + " is empty.\n" +
                        "Do you want to add one?[y/n]");
                char yn = DataInput.getChar();
                if (yn == 'y') addNewSpecialityOnChosenFaculty(chosenFaculty);
               performTenthCase();
            } else {
                System.out.println("List of specialities:");
                for (int i = 0; i < chosenFaculty.getSpecialities().getRealLength(); i++)
                    System.out.println("" + (i + 1) + ". " + chosenFaculty.getSpecialities().get(i));
                int chosenNumOfSpeciality = Utility.readNumInGivenRange(1, chosenFaculty.getSpecialities().getRealLength()) - 1;
                chosenSpeciality = (Speciality) chosenFaculty.getSpecialities().get(chosenNumOfSpeciality);
            }
        }
        StringBuilder studFirstCourseOnSpeciality = new StringBuilder();
        StringBuilder studSecondCourseOnSpeciality = new StringBuilder();
        StringBuilder studThirdCourseOnSpeciality = new StringBuilder();
        StringBuilder studFourthCourseOnSpeciality = new StringBuilder();
        for (int i = 0; i < students.getRealLength(); i++) {
            if (((Student) students.get(i)).getFaculty() == chosenFaculty && ((Student) students.get(i)).getSpeciality() == chosenSpeciality) {
                switch (((Student) students.get(i)).getCourse()) {
                    case 1:
                        studFirstCourseOnSpeciality.append(students.get(i)).append("\n");
                        break;
                    case 2:
                        studSecondCourseOnSpeciality.append(students.get(i)).append("\n");
                        break;
                    case 3:
                        studThirdCourseOnSpeciality.append(students.get(i)).append("\n");
                        break;
                    case 4:
                        studFourthCourseOnSpeciality.append(students.get(i)).append("\n");
                }
            }

        }
        System.out.println(studFirstCourseOnSpeciality + studSecondCourseOnSpeciality.toString() + studThirdCourseOnSpeciality + studFourthCourseOnSpeciality);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void performEleventhCase(){
        Faculty chosenFaculty;
        Speciality chosenSpeciality;
        if (faculties.getRealLength() == 0) {
            System.out.println("List of faculties is empty.\n" +
                    "Do you want to add one?[y/n]");
            char yn = DataInput.getChar();
            if (yn == 'y') addNewFaculty();
            performEleventhCase();
        } else {
            System.out.println("Choose faculty on which your speciality located.\n" +
                    "List of faculties:");
            for (int i = 0; i < faculties.getRealLength(); i++)
                System.out.println("" + (i + 1) + ". " + faculties.get(i));
            int chosenNumOfFaculty = Utility.readNumInGivenRange(1, faculties.getRealLength()) - 1;
            chosenFaculty = (Faculty) faculties.get(chosenNumOfFaculty);
            if (chosenFaculty.getSpecialities().getRealLength() == 0) {
                System.out.println("List of specialities on " + chosenFaculty + " is empty.\n" +
                        "Do you want to add one?[y/n]");
                char yn = DataInput.getChar();
                if (yn == 'y') addNewSpecialityOnChosenFaculty(chosenFaculty);
                performEleventhCase();
            } else {
                System.out.println("List of specialities:");
                for (int i = 0; i < chosenFaculty.getSpecialities().getRealLength(); i++)
                    System.out.println("" + (i + 1) + ". " + chosenFaculty.getSpecialities().get(i));
                int chosenNumOfSpeciality = Utility.readNumInGivenRange(1, chosenFaculty.getSpecialities().getRealLength()) - 1;
                chosenSpeciality = (Speciality) chosenFaculty.getSpecialities().get(chosenNumOfSpeciality);
                sortStudOrTutInAlphabeticOrder(students);
                for (int i=0; i<students.getRealLength(); i++) if (((Student) students.get(i)).getSpeciality()==chosenSpeciality)
                    System.out.println(students.get(i));
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void performTwelvesCase(){
        Faculty chosenFaculty;
        Department chosenDepartment;
        if (faculties.getRealLength() == 0) {
            System.out.println("List of faculties is empty.\n" +
                    "Do you want to add one?[y/n]");
            char yn = DataInput.getChar();
            if (yn == 'y') addNewFaculty();
            performEleventhCase();
        } else {
            System.out.println("Choose faculty on which your department located.\n" +
                    "List of faculties:");
            for (int i = 0; i < faculties.getRealLength(); i++)
                System.out.println("" + (i + 1) + ". " + faculties.get(i));
            int chosenNumOfFaculty = Utility.readNumInGivenRange(1, faculties.getRealLength()) - 1;
            chosenFaculty = (Faculty) faculties.get(chosenNumOfFaculty);
            if (chosenFaculty.getDepartments().getRealLength() == 0) {
                System.out.println("List of departments on " + chosenFaculty + " is empty.\n" +
                        "Do you want to add one?[y/n]");
                char yn = DataInput.getChar();
                if (yn == 'y') addNewDepartmentOnChosenFaculty(chosenFaculty);
                performTwelvesCase();
            } else {
                System.out.println("List of departments:");
                for (int i = 0; i < chosenFaculty.getDepartments().getRealLength(); i++)
                    System.out.println("" + (i + 1) + ". " + chosenFaculty.getDepartments().get(i));
                int chosenNumOfDepartment = Utility.readNumInGivenRange(1, chosenFaculty.getDepartments().getRealLength()) - 1;
                chosenDepartment = (Department) chosenFaculty.getDepartments().get(chosenNumOfDepartment);
                sortStudOrTutInAlphabeticOrder(tutors);
                for (int i=0; i<tutors.getRealLength(); i++) if (((Tutor) tutors.get(i)).getDepartment()==chosenDepartment)
                    System.out.println(tutors.get(i));
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void performThirteenthCase(){
        Faculty chosenFaculty;
        Speciality chosenSpeciality;
        if (faculties.getRealLength() == 0) {
            System.out.println("List of faculties is empty.\n" +
                    "Do you want to add one?[y/n]");
            char yn = DataInput.getChar();
            if (yn == 'y') addNewFaculty();
            performEleventhCase();
        } else {
            System.out.println("Choose faculty on which your speciality located.\n" +
                    "List of faculties:");
            for (int i = 0; i < faculties.getRealLength(); i++)
                System.out.println("" + (i + 1) + ". " + faculties.get(i));
            int chosenNumOfFaculty = Utility.readNumInGivenRange(1, faculties.getRealLength()) - 1;
            chosenFaculty = (Faculty) faculties.get(chosenNumOfFaculty);
            if (chosenFaculty.getSpecialities().getRealLength() == 0) {
                System.out.println("List of specialities on " + chosenFaculty + " is empty.\n" +
                        "Do you want to add one?[y/n]");
                char yn = DataInput.getChar();
                if (yn == 'y') addNewSpecialityOnChosenFaculty(chosenFaculty);
                performEleventhCase();
            } else {
                System.out.println("List of specialities:");
                for (int i = 0; i < chosenFaculty.getSpecialities().getRealLength(); i++)
                    System.out.println("" + (i + 1) + ". " + chosenFaculty.getSpecialities().get(i));
                int chosenNumOfSpeciality = Utility.readNumInGivenRange(1, chosenFaculty.getSpecialities().getRealLength()) - 1;
                chosenSpeciality = (Speciality) chosenFaculty.getSpecialities().get(chosenNumOfSpeciality);
                System.out.println("Enter course:");
                int chosenCourse = Utility.readNumInGivenRange(1,4);
                for (int i=0; i<students.getRealLength(); i++)
                    if (((Student) students.get(i)).getSpeciality()==chosenSpeciality && ((Student) students.get(i)).getCourse()==chosenCourse)
                        System.out.println(students.get(i));
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void performFourteenthCase(){
        Faculty chosenFaculty;
        Speciality chosenSpeciality;
        if (faculties.getRealLength() == 0) {
            System.out.println("List of faculties is empty.\n" +
                    "Do you want to add one?[y/n]");
            char yn = DataInput.getChar();
            if (yn == 'y') addNewFaculty();
            performEleventhCase();
        } else {
            System.out.println("Choose faculty on which your speciality located.\n" +
                    "List of faculties:");
            for (int i = 0; i < faculties.getRealLength(); i++)
                System.out.println("" + (i + 1) + ". " + faculties.get(i));
            int chosenNumOfFaculty = Utility.readNumInGivenRange(1, faculties.getRealLength()) - 1;
            chosenFaculty = (Faculty) faculties.get(chosenNumOfFaculty);
            if (chosenFaculty.getSpecialities().getRealLength() == 0) {
                System.out.println("List of specialities on " + chosenFaculty + " is empty.\n" +
                        "Do you want to add one?[y/n]");
                char yn = DataInput.getChar();
                if (yn == 'y') addNewSpecialityOnChosenFaculty(chosenFaculty);
                performEleventhCase();
            } else {
                System.out.println("List of specialities:");
                for (int i = 0; i < chosenFaculty.getSpecialities().getRealLength(); i++)
                    System.out.println("" + (i + 1) + ". " + chosenFaculty.getSpecialities().get(i));
                int chosenNumOfSpeciality = Utility.readNumInGivenRange(1, chosenFaculty.getSpecialities().getRealLength()) - 1;
                chosenSpeciality = (Speciality) chosenFaculty.getSpecialities().get(chosenNumOfSpeciality);
                System.out.println("Enter course:");
                int chosenCourse = Utility.readNumInGivenRange(1,4);
                sortStudOrTutInAlphabeticOrder(students);
                for (int i=0; i<students.getRealLength(); i++)
                    if (((Student) students.get(i)).getSpeciality()==chosenSpeciality && ((Student) students.get(i)).getCourse()==chosenCourse)
                        System.out.println(students.get(i));
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void addNewFaculty() {
        String name;
        System.out.println("Enter the name of new faculty: ");
        do {
            name = DataInput.getString();
            if (!Utility.lineContainsOnlyLetters(name)) System.out.println("Incorrect value. Enter again: ");
            else if (!nameIsUniqueInDynamicArray(name, faculties))
                System.out.println("There is a faculty with the same name. Create a unique one.");
        } while (!(Utility.lineContainsOnlyLetters(name) && nameIsUniqueInDynamicArray(name, faculties)));
        faculties.add(new Faculty(name));
    }

    private void addNewTutorOnChosenDepartment(Department chosenDepartment) {
        System.out.print("Enter tutor's full name:");
        String fullName;
        do{
            fullName = DataInput.getString();
            if (!Utility.lineContainsOnlyLetters(fullName))
                System.out.print("\nName must contain only letters. Please, enter again:");
            else if (!nameIsUniqueInDynamicArray(fullName, chosenDepartment.getTutors()))
                System.out.print("\nThe name is not unique. Please, enter again:");
        } while (!Utility.lineContainsOnlyLetters(fullName) || !nameIsUniqueInDynamicArray(fullName, chosenDepartment.getTutors()));
        Tutor newTutor = new Tutor(fullName, chosenDepartment.getFaculty(), chosenDepartment);
        tutors.add(newTutor);
        chosenDepartment.setTutor(newTutor);
    }

    private boolean nameIsUniqueInDynamicArray(String name, DynamicArray dynamicArray) {
        for (int i = 0; i < dynamicArray.getRealLength(); i++) {
            if (dynamicArray.get(i).toString().equals(name)) return false;
        }
        return true;
    }

    private void addNewDepartmentOnChosenFaculty(Faculty chosenFaculty) {
        String name;
        DynamicArray givenDepartments = chosenFaculty.getDepartments();
        System.out.println("Enter the name of new department: ");
        do {
            name = DataInput.getString();
            if (!Utility.lineContainsOnlyLetters(name)) System.out.println("Incorrect value. Enter again: ");
            else if (!nameIsUniqueInDynamicArray(name, givenDepartments))
                System.out.println("There is a department with the same name. Create a unique one.");
        } while (!(Utility.lineContainsOnlyLetters(name) && nameIsUniqueInDynamicArray(name, givenDepartments)));
        givenDepartments.add(new Department(name, chosenFaculty));
    }

    private void addNewSpecialityOnChosenFaculty(Faculty chosenFaculty) {
        String name;
        DynamicArray givenSpecialities = chosenFaculty.getSpecialities();
        System.out.println("Enter the name of new speciality: ");
        do {
            name = DataInput.getString();
            if (!Utility.lineContainsOnlyLetters(name)) System.out.println("Incorrect value. Enter again: ");
            else if (!nameIsUniqueInDynamicArray(name, givenSpecialities))
                System.out.println("There is a speciality with the same name. Create a unique one.");
        } while (!(Utility.lineContainsOnlyLetters(name) && nameIsUniqueInDynamicArray(name, givenSpecialities)));
        givenSpecialities.add(new Speciality(name, chosenFaculty));
    }

    private void addNewStudentOnChosenSpeciality(Speciality chosenSpeciality){
        System.out.print("Enter student's full name:");
        String fullName;
        do{
            fullName = DataInput.getString();
            if (!Utility.lineContainsOnlyLetters(fullName))
                System.out.print("\nName must contain only letters. Please, enter again:");
            else if (!nameIsUniqueInDynamicArray(fullName, chosenSpeciality.getStudents()))
                System.out.print("\nThe name is not unique. Please, enter again:");
        } while (!Utility.lineContainsOnlyLetters(fullName) || !nameIsUniqueInDynamicArray(fullName, chosenSpeciality.getStudents()));
        System.out.print("Enter student's course:");
        int course = Utility.readNumInGivenRange(1,4);
        Student newStudent = new Student(fullName, chosenSpeciality.getFaculty(), chosenSpeciality, course);
        students.add(newStudent);
        chosenSpeciality.addStudent(newStudent);
    }

    private void sortStudOrTutInAlphabeticOrder(DynamicArray dynamicArray){
        if (dynamicArray==students){
            for (int i = 0; i < students.getRealLength(); i++) {
                for (int j = i + 1; j < students.getRealLength(); j++) {
                    if (((Student) students.get(i)).getName().compareTo(((Student) students.get(j)).getName()) > 0) {
                        students.swap(i,j);
                    }
                }
            }
        }
        else if (dynamicArray==tutors){
            for (int i = 0; i < tutors.getRealLength(); i++) {
                for (int j = i + 1; j < tutors.getRealLength(); j++) {
                    if (((Student) tutors.get(i)).getName().compareTo(((Student) tutors.get(j)).getName()) > 0) {
                        tutors.swap(i,j);
                    }
                }
            }
        }
    }
}