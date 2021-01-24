package po1.it.unive.car;

import po1.it.unive.Printable;
import po1.it.unive.car.fuel.FuelType;
import po1.it.unive.vehicle.Loadable;
import po1.it.unive.vehicle.LoadableUnloadable;

/**
 * Class @code Truck represents a truck
 */
 public final class Truck extends Car implements LoadableUnloadable, Printable {
    /**
     * Amount of load on the truck
     */
    private double load;

    /**
     * Constructor: set the ID, increment the field nextID and update the field highestId
     *
     * @param speed
     * @param fuelType
     * @param fuel
     */
    public Truck(double speed, FuelType fuelType, double fuel) {
        super(speed, fuelType, fuel);
    }
    // getters and setters
    /**
     * Returns the load value
     *
     * @return load value
     */
    public double getLoad() {
        return load;
    }

    /**
     * Set the value of the load
     *
     * @param load load to be set
     */
    public void setLoad(double load) {
        this.load = load;
    }
    // Methods
    /**
     * Modify the load adding the given amount
     *
     * @param load amount to be added to load
     */
    public void chargeLoad(double load){
        this.load += load;
    }

    @Override
    public double getMaxLoad() {
        return 3000;
    }

    @Override
    public void print() {
        System.out.print("This is a truck with "+load+" ksg, at speed "+this.getSpeed());
    }

    @Override
    public void unchargeLoad(double l) {
        if(load>=l){
            load -= l;
        }
        else load = 0;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "load=" + load +
                ", speed=" + getSpeed() +
                '}';
    }
}
