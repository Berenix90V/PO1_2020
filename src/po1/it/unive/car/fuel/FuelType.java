package po1.it.unive.car.fuel;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashMap;
import java.util.Map;
@XmlRootElement
@XmlType
public class FuelType{
    @XmlElement
    private String name;
    @XmlAttribute
    private final double costPerLiter;
    @XmlAttribute
    private final double FUEL_CONS;
    @XmlAttribute
    private static int numberOfTypes = 0;
    @XmlAttribute
    private final int id;

    /**
     * Creates and returns a fuel type. If a fuel type with the given name was previously created,
     * the method returns the existing instance (with the cost per liter and fuel consumption set
     * when this was created). Otherwise, it creates and returns a new fuel type caching it.
     *
     * @param name the name of the fuel type
     * @param costPerLiter the cost of one liter of fuel of this type
     * @param FUEL_CONS the consumption (km/l)
     * @return an instance of fuel type with the given name
     */
    static public FuelType createFuelType(String name, double costPerLiter, double FUEL_CONS){
        FuelType result = FuelTypeCache.getFuelTypeFromName(name);
        if(result==null) {
            result = new FuelType(name, costPerLiter, FUEL_CONS);
            FuelTypeCache.storeFuelType(result);
        }
        return result;
    }
    // constructors
    private FuelType(String name, double costPerLiter, double FUEL_CONS) {
        this.name = name;
        this.costPerLiter = costPerLiter;
        this.FUEL_CONS = FUEL_CONS;
        id = numberOfTypes++;
    }

    private FuelType(String name, double costPerLiter) {
        this(name, costPerLiter,0);
    }
    private FuelType(){
        this("unknown", 0, 0.05);
    }

    // getters and setters
    public String getFuelType(){
        return this.name;
    }

    public double getFUEL_CONS(){
        return this.FUEL_CONS;
    }


    /**
     *
     * @return the cost per liter
     */
    public double getCostPerLiter(){
        return this.costPerLiter;
    }
    /**
     * Return the name of the fuel type
     *
     * @return the name of the fuel type
     */
    public String getName() {
        return name;
    }

}

