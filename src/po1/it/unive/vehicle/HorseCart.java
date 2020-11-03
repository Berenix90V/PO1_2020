package po1.it.unive.vehicle;

public class HorseCart extends Vehicle implements Loadable{
    private double load;
    private double maxLoad = 100;
    public HorseCart(double speed){
        super(speed);
    }
    public void chargeLoad(double l){
        if(l<=maxLoad)
            load +=l;
        else System.out.println("Too much weight");
    }

    @Override
    public double getMaxLoad() {
        return this.maxLoad;
    }

    @Override
    public void setLoad(double l) {

    }

    @Override
    public double getLoad() {
        return 0;
    }
}
