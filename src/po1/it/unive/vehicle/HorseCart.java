package po1.it.unive.vehicle;

public class HorseCart extends Vehicle implements Loadable{
    private double load;
    public HorseCart(double speed){
        super(speed);
    }
    public void chargeLoad(double l){
        load +=l;
    }
}
