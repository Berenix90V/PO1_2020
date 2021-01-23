package po1.it.unive.bicycle;

import po1.it.unive.vehicle.NegativeSpeedException;
import po1.it.unive.vehicle.Vehicle;

public class Bicycle extends Vehicle{

    private double frontTirePressure, rearTirePressure;

    // constructors
    public Bicycle(double initialSpeed, double frontTirePressure, double rearTirePressure) {
        super(initialSpeed);
        this.frontTirePressure = frontTirePressure;
        this.rearTirePressure = rearTirePressure;
    }

    public Bicycle(double frontTirePressure, double rearTirePressure) {
        this.frontTirePressure = frontTirePressure;
        this.rearTirePressure = rearTirePressure;
    }

    // methods
    public double getFrontTirePressure(){
        return frontTirePressure;
    }
    public double getRearTirePressure(){
        return rearTirePressure;
    }
    public void accelerate(double dv) throws NegativeSpeedException {
        super.accelerate(dv);
    }
}
