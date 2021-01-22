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

import java.util.*;

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
    public static void interfaces(){
        FuelType diesel = FuelType.createFuelType("diesel", 1.3, 0.3);

        Printable[] printables = new Printable[2];
        printables[0] = new Truck(100, diesel, 10);
        ((Truck) printables[0]).chargeLoad(10);
        printables[1] = new Square(3);
        printAll(printables);

        Truck truck = new Truck(0, diesel, 20);
        LoadableUnloadable obj = truck;
    }
    public static void dispatch(){
        FuelType diesel = FuelType.createFuelType("diesel", 1.3, 0.03);
        Vehicle v1 = new Car(20, diesel,300);
        Vehicle v4 = new Car(10, diesel,100);
        Vehicle v2 = new Truck(10, diesel,10);
        Vehicle v3 = new HorseCart(10);
        Vehicle v5=v1;
        Vehicle v6 = v2;
        //v1.accelerate(10);
        /*Racing.race(v1,v2,100);
        Racing.race(v3,v2,100);
        Racing.race(v1,v3,100);*/

        Racing common_race = new Racing();
        common_race.race(v1, v4, 100);
        common_race.race(new Car(10,diesel,10), new Bicycle(10,2,2), 100);
        common_race.race(new Bicycle(10,2,2), new Car(10,diesel,10),100);
        common_race.race(new Bicycle(10,2,2), new Bicycle(10,2,2), 100);

        common_race.race(v1,v4,100);
        common_race.race(v1,v2,100);

        Car.foo();
        Vehicle.foo();
        v1.foo();
    }

    public static void main(String[] args) throws Exception {

        FuelType diesel = FuelType.createFuelType("diesel", 1.3, 0.03);
        Car v1 = new Car(10, diesel,10);
        Car v2 = new Car(10, diesel,10);
        Truck v3 = new Truck(10, diesel,10);
        Vehicle v4 = new Vehicle(10);
        Vehicle v5 = new Vehicle(20);
        Vehicle v6 = new Vehicle(20);
        boolean eq = v4.equals(v5);
        boolean eq2 = v5.equals(v6); // sono = per come ho implementato la equals
        Vehicle v7 = v6.clone();


        Vehicle vehicle1 = new Vehicle(10);
        Vehicle vehicle2 = new Vehicle(20);
        Vehicle vehicle3 = new Vehicle(20);
        Vehicle vehicle4 = new Vehicle(30);

        Set set = new HashSet<>();
        set.add(vehicle1);
        set.add(vehicle2);
        set.add(vehicle4);
        set.add(vehicle3);
        // metodo brutto
        Iterator<Vehicle> it = set.iterator();
        while(it.hasNext()){
            Vehicle v = it.next();
            System.out.println(v.getSpeed());
        }
        // metodo bello per collezioni:
        for(Object v : set){
            System.out.println(v.toString());
        }
        /*
        System.out.println(v1.compareTo(v4));
        System.out.println(c.compareTo(v3));
        System.out.println(v3.compareTo(c));

        TreeSet<Vehicle> set = new TreeSet <Vehicle>();
        set.add(v1);
        set.add(v2);
        set.add(c);
        for(Vehicle v:set){
            System.out.println(v.getClass().getName() + " "+ v.getSpeed());
        }
         */
    }

}
