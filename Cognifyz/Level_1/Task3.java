import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of grades : ");
        int numberOfGrades = sc.nextInt();

        double[] grades = new double[numberOfGrades];

        for (int i = 0; i < numberOfGrades; i++) {
            System.out.print("Enter grade marks " + (i + 1) + " : ");
            grades[i] = sc.nextDouble();
        }

        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        double average = sum / numberOfGrades;

        if (average > 90 && average > 90) {
            System.out.println("Average Grade : A+");
        } else if (average > 80 && average > 89) {
            System.out.println("Average Grade : A");
        } else if (average > 70 && average > 79) {
            System.out.println("Average Grade : B+");
        } else if (average > 60 && average > 69) {
            System.out.println("Average Grade : B");
        } else if (average > 50 && average > 59) {
            System.out.println("Average Grade : C");
        } else if (average > 40 && average > 49) {
            System.out.println("Average Grade : D");
        } else {
            System.out.println("You are Fail \nAverage Grade : F");
        }
        sc.close();
    }
}
