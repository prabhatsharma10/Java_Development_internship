import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        try{
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("\nChoose an option:");
            System.out.println("1. Encrypt a file");
            System.out.println("2. Decrypt a file");
            System.out.println("3. Exit");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    System.out.println("Enter the file name or path:");
                    String fileName = scanner.nextLine();
                    System.out.println("Enter the shift value (1-25):");
                    int shift = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                    encryptFile(fileName, shift);
                    break;
                case 2:
                    System.out.println("Enter the file name or path:");
                    fileName = scanner.nextLine();
                    System.out.println("Enter the shift value (1-25):");
                    shift = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                    decryptFile(fileName, shift);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
    }
    }

    public static void encryptFile(String fileName, int shift) {
        try {
            File file = new File(fileName);
            StringBuilder encryptedText;
            Scanner scanner = new Scanner(file);
                encryptedText = new StringBuilder();
                while(scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println("\nOriginal Content : " + line);
                    
                    for (char c : line.toCharArray()) {
                        if (Character.isLetter(c)) {
                            char base = Character.isUpperCase(c) ? 'A' : 'a';
                            encryptedText.append((char) ((c - base + shift) % 26 + base));
                        } else {
                            encryptedText.append(c);
                        }
                    }
                
            }

            String encryptedFileName = fileName;
            FileWriter writer = new FileWriter(encryptedFileName);
            writer.write(encryptedText.toString());
            writer.close();

            System.out.println("Encrypted Text : " + encryptedText.toString());
            System.out.println("Encrypted file saved as " + encryptedFileName);
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Error occur : " + e.getMessage());
        }
    }

    public static void decryptFile(String fileName, int shift) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            StringBuilder decryptedText = new StringBuilder();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("\nEncrypted Content : " + line);

                for (char c : line.toCharArray()) {
                    if (Character.isLetter(c)) {
                        char base = Character.isUpperCase(c) ? 'A' : 'a';
                        decryptedText.append((char) ((c - base - shift + 26) % 26 + base));
                    } else {
                        decryptedText.append(c);
                    }
                }
            }

            scanner.close();

            String decryptedFileName = fileName;
            FileWriter writer = new FileWriter(decryptedFileName);
            writer.write(decryptedText.toString());
            writer.close();

            System.out.println("Decrypted Text : " + decryptedText.toString());
            System.out.println("Decrypted file saved as " + decryptedFileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}