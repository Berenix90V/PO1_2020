package it.unive.po1.car;

public class Main {
    public static void main(String[] args) throws Exception {
        LinkedList myList = new LinkedList();
        FuelType diesel = new FuelType();
        diesel.name = "diesel";
        diesel.costPerLiter = 1.3;
        diesel.FUEL_CONS = 0.3;
        FuelTank myTank = new FuelTank(diesel, 10);
        myTank.type = diesel;
        myTank.amount = 34.5;

        Car myCar = new Car();
        myCar.fuelType = diesel;
        //myCar: fuel = 0.0, speed = 0.0
        myCar.refuel(myTank);
        //myCar: fuel = 34.5, speed = 0.0
        myCar.accelerate(90.3);
        //myCar: fuel = 7.41, speed = 90.3
        myCar.fullBreak();
        //myCar: fuel = 7.41, speed = 0.0

        Car yourCar = new Car();
        yourCar.fuelType = diesel;
        FuelTank yourTank = new FuelTank(diesel, 19);
        yourTank.type = diesel;
        yourTank.amount = 34.5;
        yourCar.refuel(yourTank);
        System.out.println(myTank.tankId);

        //yourCar: fuel = 0.0, speed = 0.0
        //myCar: fuel = 33.9, speed = 0.0
        myList.item = myCar;
        LinkedList yourList = new LinkedList();
        yourList.item = yourCar;
        myList.next = yourList;
        int c = myList.count_items();
        FuelTank.resetTanksCount();
    }
}
