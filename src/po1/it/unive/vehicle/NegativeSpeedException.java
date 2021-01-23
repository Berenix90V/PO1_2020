package po1.it.unive.vehicle;

public class NegativeSpeedException extends Exception{

    private double speed;

    public NegativeSpeedException(String s){
        super(s);
    }
    public NegativeSpeedException(double a){
        super("Negative acceleration not allowed" + a);
        speed=a;
    }

    public double getSpeed() {
        return speed;
    }
}
