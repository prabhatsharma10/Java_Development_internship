
import java.util.Scanner;

public class Task1 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        float dec;
        float temp, F, C;
        while(true){
            System.out.print("\nEnter temperature : ");
            temp = sc.nextFloat();
            System.out.println("1. Convert temperature into F\n2. Convert temperature into C\nOther to Exit");
            dec = sc.nextInt();
            if (dec == 1) {
                F = (float) ((temp * (9.0 / 5.0)) + 32);
                System.out.println("Temperature in Fahrenheit : " + F);
            }
            else if (dec == 2) {
                C = (float) ((temp - 32.0) * (5.0 / 9.0));
                System.out.println("Temperature in Celsius : " + C);
            } 
            else {
                System.out.println("Exiting....");
                break;
            }
        }
        sc.close();
    }
}
