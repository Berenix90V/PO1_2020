package po1.it.unive.car;

/**
 * Class @code Truck represents a truck
 */
public class Truck extends Car {
    /**
     * Amount of load on the truck
     */
    private double load;
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
}
