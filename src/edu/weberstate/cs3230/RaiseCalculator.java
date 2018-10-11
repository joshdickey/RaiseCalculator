package edu.weberstate.cs3230;

public class RaiseCalculator{
    private double wage;
    private double raise;
    private int multiplyer;

    public RaiseCalculator(double wage, double raise){
        this.wage = wage;
        this.raise = raise;
    }

    public RaiseCalculator(double wage, double raise, int years){
        this.wage = wage;
        this.raise = raise;
        this.multiplyer = years;
    }

    public double calculateRaiseOnce(){

        double wageIncrease = (wage * raise);
        return wage + wageIncrease;
    }

    public double calculateRaise(){

        double wageIncrease;
        double newWage = wage;
        boolean firstMark = false;
        boolean secondMark = false;

        if (multiplyer > 1) {
            for (int i = 0; i < multiplyer; i++) {

                wageIncrease = newWage * raise;
                newWage = newWage + wageIncrease;

                System.out.println(newWage);
                if (newWage > 43.27 && !secondMark){
                    System.out.println("Over $90,000");
                    secondMark = true;

                }
                if(newWage > 38.46 && newWage < 43.27 && !firstMark){
                    System.out.println("Over $80,000");
                    firstMark = true;
                }
            }
        }else {
           newWage = calculateRaiseOnce();
        }

        return newWage;
    }

    public void setWage(double wage){
        this.wage = wage;
    }
}
