package po1.it.unive.vehicle;

/**
 * Class @code Vehicle represents a vehicle
 */
public abstract class Vehicle {
    private double speed;
    // Constructors
    /**
     * It initializes the vehicle with a given speed
     * @param initialSpeed initial speed
     */
    public Vehicle(double initialSpeed){
        this.speed = initialSpeed;
    }
    /**
     * It initializes the vehicle with initial speed = 0
     *
     */
    public Vehicle() {
        this(0);
    }

    //getters and setters

    /**
     * Returns the speed of the vehicle
     *
     * @return speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Sets the field speed given a speed
     *
     * @param speed speed to be set
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    //Methods

    /**
     * Modify speed adding a given dv
     * @param dv speed to be added to speed field
     */
    protected void accelerate(double dv){
        if(dv>=0)
            this.speed = dv;
        else
            this.speed = 0;
    }

    /**
     * Make the car stop
     *
     */
    public void fullBreak() {
        setSpeed(0);
    }


}
