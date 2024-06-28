import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
            
        // if you're not from the US its: weight (kg) / height^2 (m)
        // if you're in the US its: same thing but in lbs and inches *703
        System.out.println("Welcome to BMI calculator!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you from the US? (y/n):");
        String yesorno = scanner.nextLine();
        while (!yesorno.equals("y") && !yesorno.equals("n")) {
            System.out.println("Invalid input. Please try again.");
            System.out.println("Are you from the US? (y/n):");
            yesorno = scanner.nextLine().strip().toLowerCase();
        }
        if (yesorno.equals("n")) {
            System.out.println("Enter your weight in kgs:");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please try again.");
                System.out.println("Enter your weight in kgs:");
                scanner.next();
            }
            // didnt know you can do nextDouble() until i saw him do it in the vid
            double weight = scanner.nextDouble();
            System.out.println("Enter your height in m:");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please try again.");
                System.out.println("Enter your height in m:");
                scanner.next();
            }
            double height = scanner.nextDouble();
            double bmi = weight / Math.pow(height, 2);
            DecimalFormat df = new DecimalFormat("0.0");
            System.out.println("Your BMI is: " + df.format(bmi));
        } else {
            System.out.println("Enter your weight in lbs:");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please try again.");
                System.out.println("Enter your weight in lbs:");
                scanner.next();
            }
            double weight = scanner.nextDouble();
            System.out.println("We will prompt you for your height in 2 parts");
            System.out.println("First enter ft, then enter inches");
            System.out.println("e.g. if I am 5'10, enter 5 at the first prompt and 10 at the second");
            System.out.println("Enter ft:");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please try again.");
                System.out.println("Enter ft:");
                scanner.next();
            }
            double ft = scanner.nextDouble();
            System.out.println("Enter inches:");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please try again.");
                System.out.println("Enter inches:");
                scanner.next();
            }
            double inches = scanner.nextDouble();
            double total_inches = (ft * 12) + inches;
            double bmi = (weight / Math.pow(total_inches, 2)) * 703;
            DecimalFormat df = new DecimalFormat("0.0");
            System.out.println("Your BMI is: " + df.format(bmi));
        }
        
    }
}
