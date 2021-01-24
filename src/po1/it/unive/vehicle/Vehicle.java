package po1.it.unive.vehicle;

import po1.it.unive.car.Car;

import java.util.Objects;

/**
 * Class @code Vehicle represents a vehicle
 */
public class Vehicle implements Comparable <Vehicle> {
    @Speed(forward = true) double speed;
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
    @Speed(forward = true)
    public double getSpeed() {
        return speed;
    }

    /**
     * Sets the field speed given a speed
     *
     * @param speed speed to be set
     */
    public void setSpeed(@Speed(forward = true) double speed) {
        this.speed = speed;
    }

    //Methods

    /**
     * Modify speed adding a given dv
     * @param dv speed to be added to speed field
     * @throws NegativeSpeedException the given acceleration is negative
     */
    public void accelerate(@Speed(forward = true) double dv) throws NegativeSpeedException{
        assert dv >=0;
        if(dv>=0)
            this.speed = dv;
        else throw new NegativeSpeedException(dv);
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
        if (this == o) return true; // se puntano allo stesso obj
        if (o == null || getClass()!= o.getClass() )
            return false; // sono 2 veicoli diversi
        if(!(o instanceof Vehicle))
            return false;           // sono 2 tipi diversi
        Vehicle vehicle = (Vehicle) o;
        return vehicle.speed == speed; // li confronto per fields (velocità)
    }

    @Override
    @SuppressWarnings("all")
    public Vehicle clone() throws CloneNotSupportedException {
        return new Vehicle(this.speed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(speed);
    }

    @Override
    public int compareTo(Vehicle o) {
        if (this.equals(o)) return 0;
        if(o==null || getClass()!= o.getClass()) {
            if (o instanceof Car)
                return 1;
            return -1; // sono 2 veicoli diversi, in realtà andrebbe fatta una scala di tipi
        }
        return (int) (this.speed-o.speed);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "speed=" + speed +
                '}';
    }
}
