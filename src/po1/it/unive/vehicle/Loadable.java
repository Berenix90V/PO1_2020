package po1.it.unive.vehicle;

public interface Loadable {

    default public void chargeLoad(double l){
        if(this.getLoad() + l< this.getMaxLoad())
            this.setLoad(this.getLoad()+l);
        else System.out.println("Too much weight");
    }

    public double getMaxLoad();

    public void setLoad(double l);
    public double getLoad();
}

