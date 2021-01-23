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

    public static void metodiobject(String[] args) throws Exception {

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

    }
    public static void collections(String[] args) throws Exception {
        FuelType diesel = FuelType.createFuelType("diesel", 1.3, 0.03);
        Vehicle vehicle1 = new Vehicle(10);
        Vehicle vehicle2 = new Vehicle(20);
        Vehicle vehicle3 = new Vehicle(20);
        Vehicle vehicle4 = new Vehicle(30);
        Set<Vehicle> set = new HashSet<>();
        set.add(vehicle1);
        set.add(vehicle2);
        set.add(vehicle4);
        set.add(vehicle3);

        // metodo bello per collezioni:
        for(Vehicle v : set){
            System.out.println(v.getSpeed());
        }
        System.out.println(vehicle1.compareTo(vehicle4)); // v1<v4
        System.out.println(vehicle4.compareTo(vehicle1)); // v4>v1
        System.out.println(vehicle2.compareTo(vehicle3)); // v2==v3
        Car c = new Car(30, diesel, 20);
        System.out.println(c.compareTo(vehicle2)); // c
        System.out.println(vehicle2.compareTo(c)); //

        Vehicle vehicle5 = new Vehicle(40);
        TreeSet <Vehicle> set2 = new TreeSet<Vehicle>();
        set2.add(vehicle1);
        set2.add(vehicle4);
        set2.add(vehicle2);
        set2.add(vehicle5);
        // se modifico uno degli elementi in un secondo momento mi ritrovo con 2
        // veicoli alla stessa v
        vehicle5.setSpeed(20);
        // stampa in modo ordinato
        for(Vehicle v : set2)
            System.out.println(v.getClass().getName()+" "+v.getSpeed());
    }
    public static void stringhe(String[] args) throws Exception {
        String s = "abc";
        int n = 123;
        Object o = "def";
        FuelType diesel = FuelType.createFuelType("diesel", 1.3, 0.03);

        System.out.println(s.charAt(1));
        String s1 = s.concat("def");
        String s2 = s+"def";


        Vehicle v1 = new Vehicle(10);
        Car v4 =  new Car(30, diesel, 20);
        Truck v2 = new Truck(20, diesel, 20);
        Vehicle v5 = new Vehicle(40);
        String sv1 = v1.toString();
        String sv2 = v2.toString();
        String sv4 = v4.toString();
        String sv5 = v5.toString();
        System.out.println(sv1);

        String a = "abc";
        String a1 = new String("abc");//same of a
        String b = a + "def"; //"abcdef"
        String c = a.concat("def"); //"abcdef"
        String d = c.replace('a', 'g'); //"gbcdef"
        String e = c.substring(0, 3); //"abc"
        String[] f = c.split("d"); //{"abc", "ef"}
    }
    public static void primitivetypes(String[] args) throws Exception {
        boolean b = true;
        byte z = 1;
        int i = 123;
        double d = 1.23;
        float f = 1.23F;
        //f = d; non si può: f float (32) <- d double (62)
        //z = i; non si può: z byte (8) <- i int (16)
        i = z; // i int (32) <- z byte (8)
        d = f; // d double (64) <- f float (32)
        Object o = 5; // lo accetta
        // riconosce automaticamente che l'obj oi è un int
        Integer oi = 2;
        int in = oi;
    }
    public static void main(String[] args) throws NegativeSpeedException {
        Vehicle v = null;
        /*
        // NullPointer Exception
        v.getSpeed();
        // ArithmeticException: / by zero
        int i = 10/0;
        // ArrayIndexOutOfBoundException
        Vehicle[] arr = new Vehicle[1];
        v = arr[2];
        */
        //Anche questa mi dà un nullpointer:
        /*
        Car c = new Car(0, null, 10);
        c.accelerate(10);
        */
        FuelType diesel = FuelType.createFuelType("diesel", 1.3, 0.03);
        Car c = new Car(0, diesel, 10);
        c.accelerate(-10);

    }

}
