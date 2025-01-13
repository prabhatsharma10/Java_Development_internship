import java.util.Random;
import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        System.out.print("Enter the desired length of the password : ");
        int length = sc.nextInt();

        if (length <= 0) {
            System.out.println("Invalid length. Please enter a positive number.");
            return;
        }

        String numbers = "0123456789";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special = "!@#$%^&*()-_=+[]{}|;:',.<>?/";

        System.out.print("Include numbers? (true/false) : ");
        boolean includeNumbers = sc.nextBoolean();

        System.out.print("Include lowercase letters? (true/false) : ");
        boolean includeLowercase = sc.nextBoolean();

        System.out.print("Include uppercase letters? (true/false) : ");
        boolean includeUppercase = sc.nextBoolean();

        System.out.print("Include special characters? (true/false) : ");
        boolean includeSpecial = sc.nextBoolean();

        String charPool = "";

        if (includeNumbers) {
            charPool += numbers;
        }
        if (includeLowercase) {
            charPool += lowercase;
        }
        if (includeUppercase) {
            charPool += uppercase;
        }
        if (includeSpecial) {
            charPool += special;
        }

        if (charPool.isEmpty()) {
            System.out.println("You must select at least one character type.");
            return;
        }

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(charPool.length()); //generating random index out of 90
            password.append(charPool.charAt(randomIndex));       // appending character from charpool based on index
                                                                //charPool.charAt(randomIndex) --> returns character at randomIndex 

        }

        System.out.println("Generated password : " + password.toString() +"\n");  // toString --> immutable String.  toString() method is used to convert the StringBuilder into a String.
        sc.close();
    }
}
