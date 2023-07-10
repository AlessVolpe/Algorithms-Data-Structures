package Recursion.DrawRuler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int inches, tickLenght;

        System.out.print("Enter the lenght of the ruler in Inches: ");
        if (!input.hasNextInt()) {
            System.out.println("Input is not a number");
            System.exit(1);
        }
        inches = Integer.parseInt(input.nextLine());

        System.out.print("Enter the lenght of the biggest tick: ");
        if (!input.hasNextInt()) {
            System.out.println("Input is not a number");
            System.exit(1);
        }
        tickLenght = Integer.parseInt(input.nextLine());

        DrawRuler.drawRuler(inches, tickLenght);

        input.close();
    }
}
