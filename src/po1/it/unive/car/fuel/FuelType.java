package po1.it.unive.car.fuel;

import java.util.HashMap;
import java.util.Map;

public class FuelType{
    private String name;
    private final double costPerLiter;
    private final double FUEL_CONS;
    private static int numberOfTypes = 0;
    private final int id;

    // static blocks
    private static Map<String, FuelType> alreadyCreatedFuelTypes = new HashMap<>();
    static public FuelType createFuelType(String name, double costPerLiter, double FUEL_CONS){
        FuelType result = FuelTypeCache.getFuelTypeFromName(name);
        if(result==null) {
            result = new FuelType(name, costPerLiter, FUEL_CONS);
            FuelTypeCache.storeFuelType(result);
        }
        return result;
    }
    // constructors
    private FuelType(String name, double costPerLiter, double FUEL_CONS) {
        this.name = name;
        this.costPerLiter = costPerLiter;
        this.FUEL_CONS = FUEL_CONS;
        id = numberOfTypes++;
    }

    private FuelType(String name, double costPerLiter) {
        this(name, costPerLiter,0);
    }
    private FuelType(){
        this("unknown", 0, 0.05);
    }

    // getters and setters
    public String getFuelType(){
        return this.name;
    }

    public double getFUEL_CONS(){
        return this.FUEL_CONS;
    }


    /**
     *
     * @return the cost per liter
     */
    public double getCostPerLiter(){
        return this.costPerLiter;
    }
    /**
     * Return the name of the fuel type
     *
     * @return the name of the fuel type
     */
    public String getName() {
        return name;
    }

}

