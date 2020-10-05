package it.unive.po1.car;

public class FuelType{
    String name;
    double costPerLiter;
    public double FUEL_CONS;

    public FuelType(String name, double costPerLiter, double FUEL_CONS) {
        this.name = name;
        this.costPerLiter = costPerLiter;
        this.FUEL_CONS = FUEL_CONS;
    }

    public FuelType(String name, double costPerLiter) {

        this(name, costPerLiter,0);
    }
    public FuelType(){

        this("unknown", 0, 0.05);
    }
}

