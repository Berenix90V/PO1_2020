package po1.it.unive;

import org.w3c.dom.css.Rect;
import po1.it.unive.bicycle.Bicycle;
import po1.it.unive.car.LinkedList;
import po1.it.unive.car.Truck;
import po1.it.unive.vehicle.*;
import po1.it.unive.car.Car;
import po1.it.unive.car.fuel.FuelTank;
import po1.it.unive.car.fuel.FuelType;
import po1.it.unive.polygon.Quadrilateral;
import po1.it.unive.polygon.Rectangle;
import po1.it.unive.polygon.Rhombus;
import po1.it.unive.polygon.Square;

public class Main {
    private static String getStringArea(Quadrilateral q){
        return "The area is "+q.getArea();
    }
    private static String getStringPer(Quadrilateral q){
        return "The perimeter is "+q.getPerimeter();
    }

    static void splitLoad(double load, Loadable[] v) {
        for(int i = 0; i < v.length; i++)
            v[i].chargeLoad(load/v.length);
    }
    private static void printAll(Printable[] printables){
        for(int i=0; i<printables.length; i++)
            printables[i].print();
    }
    // main da esercizi sul libro
    public void cap2(){
        // Es. 2.3
        FuelType diesel = FuelType.createFuelType("diesel", 1.3, 0.3);
        Car myCar = new Car(0, diesel, 20);
        Car yourCar = new Car(0, diesel, 20);
        int yourId = yourCar.getId();
        System.out.println(yourId);

        // Es. LinkedList 2.16

        Car theirCar = new Car(0, diesel, 20);
        LinkedList myList = new LinkedList(myCar);
        LinkedList yourList = new LinkedList(yourCar);
        myList.setNext(yourList);
        LinkedList theirList = new LinkedList(theirCar);
        yourList.setNext(theirList);

        int c = myList.count_items();
        System.out.println(c);

    }

    // vari main usati finora in classe
    public static void cars(){
        FuelType diesel = FuelType.createFuelType("diesel", 1.3, 0.3);
        FuelType benzina = FuelType.createFuelType("benzina", 1.6, 0.9);
        FuelTank myTank = new FuelTank(diesel, 10);
        myTank.setAmount(34.5);

        Car myCar = new Car(0, diesel, 10);
        //myCar: fuel = 0.0, speed = 0.0
        myCar.refuel(myTank);
        //myCar: fuel = 34.5, speed = 0.0
        myCar.accelerate(90.3);
        //myCar: fuel = 7.41, speed = 90.3
        myCar.fullBreak();
        //myCar: fuel = 7.41, speed = 0.0

        Car yourCar = new Car(0, benzina, 0);
        FuelTank yourTank = new FuelTank(benzina, 19);
        yourTank.setAmount(34.5);
        yourCar.refuel(yourTank);
        //System.out.println(yourTank.tankId);
        FuelTank.resetTanksCount();
    }
    public static void polygons(){
        Rectangle rect = new Rectangle(2,3);
        System.out.println(getStringArea(rect));

        Square square = new Square(3);
        System.out.println(getStringArea(square));
        System.out.println(getStringPer(square));

        Rhombus rhom = new Rhombus(3,4, 5);
        System.out.println(getStringArea(rhom));
    }
    public static void racing(){
        FuelType diesel = FuelType.createFuelType("diesel", 1.3, 0.3);
        FuelTank tank1 = new FuelTank(diesel, 20);
        Vehicle v = new Car(0, diesel, 10);

        Car c = (Car) v;
        c.refuel(tank1);

        Racing.race(new Car(0, diesel, 10 ), new Car(0, diesel, 10 ), 100);
        Racing.race(new Truck(0, diesel, 10 ), new Truck(0, diesel, 10 ), 100);
        Racing.race(new Bicycle(0,2,2), new Bicycle(0,2,2), 100);
        Racing.race(new Car(0, diesel, 10 ), new Truck(0, diesel, 10 ), 100);
    }
    public static void casting(){
        FuelType diesel = FuelType.createFuelType("diesel", 1.3, 0.3);
        FuelTank tank1 = new FuelTank(diesel, 20);
        Vehicle v = null;
        if(Math.random()>0.5)
            v = new Car(0, diesel, 10);
        else v = new Bicycle(0, 1, 1);
        if(v instanceof Car)
            ((Car) v).refuel(10);
        HorseCart cart = new HorseCart(0);
        Truck truck = new Truck(100, diesel, 10);

        Loadable[] loadables = new Loadable[2];
        loadables[0]=cart;
        loadables[1] = truck;
        splitLoad(1000, loadables);
    }

    public static void main(String[] args) throws Exception {
        FuelType diesel = FuelType.createFuelType("diesel", 1.3, 0.3);

        Printable[] printables = new Printable[2];
        printables[0] = new Truck(100, diesel, 10);
        ((Truck) printables[0]).chargeLoad(10);
        printables[1] = new Square(3);
        printAll(printables);

        Truck truck = new Truck(0, diesel, 20);
        LoadableUnloadable obj = truck;
    }
}
