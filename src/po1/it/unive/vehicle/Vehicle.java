package po1.it.unive.vehicle;

import po1.it.unive.car.Car;

import java.util.Objects;

/**
 * Class @code Vehicle represents a vehicle
 */
public class Vehicle implements Comparable <Vehicle> {
    protected double speed;
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
    public void accelerate(double dv){
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

    public static void foo() {
        System.out.println("Vehicle 1");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ) return false;
        if(!(o instanceof Vehicle))
            return false;
        Vehicle vehicle = (Vehicle) o;
        return vehicle.speed == speed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(speed);
    }

    @Override
    public int compareTo(Vehicle o) {
        if (this.equals(o)) return 0;
        if(o==null || getClass()!= o.getClass())
            return 1;
        if(o instanceof Car)
            return 1;
        return (int) (this.speed-o.speed);
    }
}
