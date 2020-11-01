package po1.it.unive.car;

import po1.it.unive.car.fuel.FuelTank;
import po1.it.unive.car.fuel.FuelType;

public class Main {
    public static void main(String[] args) throws Exception {
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

        // Es. 2.3
        /*
        int yourId = yourCar.getId();
        System.out.println(yourId);
        */
        // Es. LinkedList 2.16
        /*
        Car theirCar = new Car();
        LinkedList myList = new LinkedList(myCar);
        LinkedList yourList = new LinkedList(yourCar);
        myList.setNext(yourList);
        LinkedList theirList = new LinkedList(theirCar);
        yourList.setNext(theirList);

        int c = myList.count_items();
        System.out.println(c);
        */



    }
}
