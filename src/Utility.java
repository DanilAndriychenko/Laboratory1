public class Utility {

    public static boolean numberInGivenRange(String n, int a, int b) {
        for (int i = 0; i < n.length(); i++) if (!Character.isDigit(n.charAt(i))) return false;
        return n.equals("") || (Integer.parseInt(n) >= a && Integer.parseInt(n) <= b);
    }

    public static boolean lineContainsOnlyLetters(String line) {
        for (int i = 0; i < line.length(); i++)
            if (!Character.isLetter(line.charAt(i)) && line.charAt(i) != ' ') return false;
        return true;
    }

    public static void swap(int[] arr, int i) {
        int tmp = arr[i + 1];
        arr[i + 1] = arr[i];
        arr[i] = tmp;
    }

    public static boolean stringContainsOnlyDigits(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }

    public static int readNumInGivenRange(int a, int b) {
        String action;
        do {
            action = DataInput.getString();
            if (!Utility.numberInGivenRange(action, a, b) || (action.equals("")))
                System.out.println("Incorrect value. Enter again: ");
        } while (!Utility.numberInGivenRange(action, a, b) || (action.equals("")));
        return Integer.parseInt(action);
    }

    public static String[] sortArrInAlphabeticOrder(String[] strings) {
        String temp;
        for (int i = 0; i < strings.length; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                if (strings[i].compareTo(strings[j]) > 0) {
                    temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                }
            }
        }
        return strings;
    }
}
