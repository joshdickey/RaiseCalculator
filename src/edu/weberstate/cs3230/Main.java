package edu.weberstate.cs3230;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a starting wage: ");
        double startingWage = reader.nextDouble(); // Scans the next token of the input as an int.

        reader.close();
        int years = 5;


        double wageAtEightPercent, wageAtSixPercent, wageAtFourPercent;

        boolean firstMark = false;
        boolean secondMark = false;

        RaiseCalculator yearlyRaiseCalc = new RaiseCalculator(startingWage, .08, years);

        RaiseCalculator yearlyRaiseSixPercent = new RaiseCalculator(startingWage, .06, years);
        RaiseCalculator yearlyRaiseFourPercent = new RaiseCalculator(startingWage, .04, years);

        String headFormat = "%-10s %-10s %-10s %-10s\n";
        String format = "%-10s %-10.2f %-10.2f %-10.2f\n";
        System.out.printf(headFormat, "Year","At .08", "At .06" , "At .04");
        for (int i = 0; i <50; i++) {
            System.out.print("-");
        }
        System.out.println();

        int year = 2019;
        for (int i = 0; i < years; i++) {
            wageAtEightPercent = yearlyRaiseCalc.calculateRaiseOnce();
            wageAtSixPercent = yearlyRaiseSixPercent.calculateRaiseOnce();
            wageAtFourPercent = yearlyRaiseFourPercent.calculateRaiseOnce();

            System.out.printf( format,year, wageAtEightPercent , wageAtSixPercent, wageAtFourPercent );

            yearlyRaiseCalc.setWage(wageAtEightPercent);
            yearlyRaiseSixPercent.setWage(wageAtSixPercent);
            yearlyRaiseFourPercent.setWage(wageAtFourPercent);
            year++;
        }
        System.out.println();
        System.out.println("33.65 = $70,000\t\t36.06 = $75,000");
        System.out.println("38.46 = $80,000\t\t40.87 = $85,000");
        System.out.println("43.27 = $90,000\t\t45.67 = $95,000");
        System.out.println("48.08 = $100,000");
    }
}
