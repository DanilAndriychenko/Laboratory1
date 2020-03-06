import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class DataInput {

    public static Long getLong() {
        String s = getString();
        Long value = Long.valueOf(s);
        return value;
    }

    public static char getChar() throws NullPointerException, StringIndexOutOfBoundsException{
        String s = getString();
        return ((!s.equals("")) ? s.charAt(0) : ' ');
    }

    public static Integer getInt() {
        String s = "";
        s = getString();
        Integer value = Integer.valueOf(s);
        return value;

    }

    public static Integer getInt(String text) {
        System.out.println(text);
        String s = "";
        s = getString();
        Integer value = Integer.valueOf(s);
        return value;

    }

    public static Double getDouble() {
        String s = "";
        s = getString();
        Double value = Double.valueOf(s);
        return value;

    }

    public static Double getDouble(String text) {
        System.out.println(text);
        String s = "";
        s = getString();
        Double value = Double.valueOf(s);
        return value;

    }

    public static String getString() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = "";
        try {
            s = br.readLine();
        } catch (IOException e) {
            System.out.println("Line wasn't found.");
        } catch (NumberFormatException e){
            System.out.println("Line is empty.");
        } catch (IllegalArgumentException e){
            System.out.println("Line is empty.");
        }
        return s;
    }

    public static String getString(String text) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = null;
        System.out.println(text);
        try {
            s = br.readLine();
        } catch (IOException e) {
            System.out.println("DataInput.getString.IOException \"Line wasn't found.\"");
        }
        return s;
    }
}