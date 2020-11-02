package po1.it.unive.car;

import po1.it.unive.vehicle.Vehicle;
import po1.it.unive.car.fuel.FuelTank;
import po1.it.unive.car.fuel.FuelType;

/**
 * Class @code Car represents a car
 */
public class Car extends Vehicle {

    /**
     * Amount of fuel in the car
     */
    private double fuel;
    /**
     * Type of fuel of the car
     */
    private FuelType fuelType;
    /**
     * ID of the next car
     */
    private static int nextId=1;
    /**
     * ID of the car
     */
    private final int carId;
    /**
     * Higher ID of all the existing cars
     */
    private static int highestId = 0;

    // Constructors

    /**
     * Constructor: set the ID, increment the field nextID and update the field highestId
     */
    public Car(double speed, FuelType fuelType, double fuel){
        super(Math.max(0, speed));
        this.fuel = Math.max(0, fuel);
        this.fuelType = fuelType;
        // Es.2.3
        this.carId = nextId;
        nextId++;
        // Es.2.9
        if(highestId<this.carId){
            highestId = this.carId;
        }
    }
    // getter and setter

    /**
     * Get carID value
     *
     * @return carID
     */
    public int getId(){
        return this.carId;
    }
    /**
     * Get highestId value
     *
     * @return highestId
     */
    public int getHighestId(){
        return highestId;
    }
    /**
     * Get nextId value
     *
     * @return nextId
     */
    public int getNextId(){
        return nextId;
    }
    /**
     * Get speed value
     *
     * @return speed
     */
    public double getSpeed() {

        return super.getSpeed();
    }
    /**
     * Set speed value given a speed
     *
     * @param speed the speed to be set
     */
    public void setSpeed(double speed) {

        super.setSpeed(speed);
    }
    // Methods
    /**
     * Get fuel amount of the car
     *
     * @return fuel value
     */
    public double getFuel(){
        return fuel;
    }
    /**
     * Set fuel amount of the car given one
     *
     * @param fuel amount of fuel to be set
     */
    public void setFuel(double fuel){
        this.fuel = fuel;
    }

    /**
     * Get the fuel type of the car
     *
     * @return fuelTypecof the car
     */
    public FuelType getFuelType(){
        return fuelType;
    }

    /**
     * Set the fuel type of the car
     *
     * @param fuelType to be set
     */
    public void setFuelType(FuelType fuelType){
        this.fuelType = fuelType;
    }
    /**
     * Returns the cost per liter of the fuel type o this car
     *
     * @return the cost per liter
     */
    public double getFuelCost(){
        return this.fuelType.getCostPerLiter();
    }

    /**
     * Refuel the car given a tank: if the type of fuel is correct refuel and empty the tank, else return
     *
     * @param tank tank to be used to refuel
     *
     */
    public void refuel(FuelTank tank) {
        if(! tank.getFuelType().equals(fuelType))return;
        else{
            fuel += tank.getAmount();
            tank.setAmount(0);
        }

    }

    public void refuel(double amount)
    {
        fuel += amount;
    }

    /**
     * If there's enough fuel accelerate of a given amount dv, else accelerate 'til there's fuel
     *
     * @param dv amount of speed to be added
     */
    final public void accelerate(double dv) {
        double consumption = dv*fuelType.getFUEL_CONS();
        if(consumption <= fuel){
            super.accelerate(dv);
            fuel -= dv*consumption;
        }
        else{
            double dv2 = getFuel()/fuelType.getFUEL_CONS(); // how much can I accelerate given the fuel I have
            this.setSpeed(super.getSpeed() +dv2);
            setFuel(0);
        }
    }

    /**
     * If there is no fuel the speed is decreased by 10%
     *
     * @return true if fuel is empty, false
     */
    public boolean isFuelEmpty() {
        if(fuel <= 0) {
            super.setSpeed(super.getSpeed() * 0.90);
            return true;
        }
        else return false;
    }

    // Es.2.15
    /**
     * Change speed setting it to a new value v
     * @param v speed to be set
     */
    void changeSpeed(double v) {
        double a = v-super.getSpeed();
        this.accelerate(a);
    }



}
