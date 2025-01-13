import java.util.Scanner;

public class Task2 {

    public static void pwdStrengthChecker(String pwd) {
        
        if (pwd == null || pwd.isEmpty()) {
            System.out.println("Password cannot be null or empty. Enter Password.");
            return;
        }
        int len = pwd.length();
        boolean hasLower = false, hasUpper = false, hasChar = false, hasDigit = false;
        char[] specialChars = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'};

        for (char ch : pwd.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                hasLower = true;
            }
            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            }
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
            for (char special : specialChars) {
                if (ch == special) {
                    hasChar = true;
                    break;
                }
            }
        }
        if ((len >= 8) && hasLower && hasUpper && hasDigit && hasChar) {
            System.out.println("Password is strong.");
        } else if ((len >= 6) && hasLower && hasUpper && hasDigit) {
            System.out.println("Password is Moderate.");
        } else {
            System.out.println("Password is weak.");
        }
    }

    public static void main(String args[]) {
        String password = "";
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter Password : ");
            password = sc.nextLine();
            pwdStrengthChecker(password);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}