package po1.it.unive.car.fuel;

public class FuelTank {
    /**
     * The type of fuel contained in the tank
     */
    private FuelType type;
    /**
     * The amount of fuel in liters in the tank
     */
    private double amount;
    /**
     * A counter of how many tanks have been already created
     */
    private static int numberOfTanks;
    /**
     * The id of the tank
     */
    private final int tankId;
    // static blocks
    static{
        numberOfTanks = 0;
    }
    // constructors
    /**
     * Creates a tank of fuel. If the given amount is negative, it creaes an empty tank.
     *
     * @param type the type of fuel
     * @param amount the amount of fuel in the tank
     */
    public FuelTank(FuelType type, double amount) {
        tankId = setTankId();
        numberOfTanks++;
        this.type = type;
        this.amount = amount;
    }
    // getters and setters
    /**
     * Returns the type of fuel in the tank
     *
     * @return the type of fuel
     */
    public FuelType getType() {
        return type;
    }

    /**
     * Sets the type of fuel in the tank
     *
     */
    public void setType(FuelType type) {
        this.type = type;
    }

    /**
     * Returns the amount of fuel in liters in the tank
     *
     * @return the amount of fuel
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount of fuel in liters in the tank
     *
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Returns the number of tanks of a given fuel type
     *
     * @return the of tnanks created for a certain type of fuel
     */
    public static int getNumberOfTanks() {
        return numberOfTanks;
    }

    /**
     * Sets the number of tanks of a given fuel type
     *
     */
    public static void setNumberOfTanks(int numberOfTanks) {
        FuelTank.numberOfTanks = numberOfTanks;
    }

    public int getTankId() {
        return tankId;
    }
    private int setTankId(){
        return numberOfTanks;
    }
    // extra getters and setters
    /**
     * Returns the cost per liter of the fuel type o this tank
     *
     * @return the cost per liter
     */
    public double getFuelCost(){
        return this.type.getCostPerLiter();
    }
    // methods
    public static void resetTanksCount (){
        numberOfTanks = 0;
    }
    public FuelType getFuelType(){
        return this.type;
    }

}