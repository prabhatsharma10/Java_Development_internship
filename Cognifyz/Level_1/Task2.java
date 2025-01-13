import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a word or phrase
        System.out.print("\nEnter a word or phrase to check if it is a palindrome : ");
        String input = scanner.nextLine();

        // Clean the input by removing spaces and punctuation, and converting to
        // lowercase
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Check if the cleaned input is a palindrome
        boolean isPalindrome = true;
        int length = cleanedInput.length();
        for (int i = 0; i < length / 2; i++) {
            if (cleanedInput.charAt(i) != cleanedInput.charAt(length - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        // Display the result
        if (isPalindrome) {
            System.out.println("The input is a palindrome."+"\n");
        } else {
            System.out.println("The input is not a palindrome."+ "\n");
        }
        scanner.close();
    }
}
