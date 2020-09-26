public class Car {
    double speed;
    double fuel;
    FuelType fuelType;
    void refuel(FuelTank tank) throws Exception {
        if(! tank.type.equals(fuelType)) throw new Exception();
        fuel += tank.amount;
    }
    void accelerate(double a) {
        speed += a;
        fuel -= a*fuelType.FUEL_CONS;
    }
    void changeSpeed(double v) {
        speed = v;
    }
    void fullBreak() {
        speed = 0.0;
    }
}
