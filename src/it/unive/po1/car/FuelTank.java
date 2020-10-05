package it.unive.po1.car;

public class FuelTank {
    public FuelType type;
    public double amount;
    public static int numberOfTanks;
    public final int tankId;

    static{
        numberOfTanks = 0;
    }
    public FuelTank(FuelType type, double amount) {
        tankId = numberOfTanks;
        numberOfTanks++;
        this.type = type;
        this.amount = amount;
    }
    static void resetTanksCount (){
        numberOfTanks = 0;
    }
}