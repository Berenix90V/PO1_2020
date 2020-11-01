package po1.it.unive.car;

import po1.it.unive.car.fuel.FuelType;

public class ThiefCar extends Car {

    /**
     * Constructor: set the ID, increment the field nextID and update the field highestId
     *
     * @param speed
     * @param fuelType
     * @param fuel
     */
    public ThiefCar(double speed, FuelType fuelType, double fuel) {
        super(speed, fuelType, fuel);
    }
    /*
    public void accelerate(double a){
        super.accelerate(a);
        super.refuel(100)
    }
    */
}
