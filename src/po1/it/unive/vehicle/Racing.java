package po1.it.unive.vehicle;

import po1.it.unive.car.Car;

public class Racing {
    /*
    static public int race(Vehicle v1, Vehicle v2, double length) {
        v1.fullBreak();
        v2.fullBreak();

        double distanceV1 = 0, distanceV2=0;
        while(true) {
            distanceV1 += v1.getSpeed();
            distanceV2 += v2.getSpeed();
            if(distanceV1 >= length || distanceV2 >= length) {
                if(distanceV1 > distanceV2) return 1;
                else return 2;
            }
            try {
                v1.accelerate((Math.random()-0.3)*10);
            } catch (NegativeSpeedException e) {
                //e.printStackTrace();
                System.err.println("Unexpected negative speed when accelerated vehicle 1: " + e.getSpeed());
            }

            try {
                v2.accelerate((Math.random()-0.3)*10);
            } catch (NegativeSpeedException e) {
                //e.printStackTrace();
                System.err.println("Unexpected negative speed when accelerated vehicle 2: " + e.getSpeed());
            }

        }

     */
    // altro modo di implementare è racchiudere tutto nel blocco try catch

    /**
     *
     * @param v1
     * @param v2
     * @param length
     * @return 1 if the winner is the first vehicle, 2 if it's the second one, -1 if an error occurs
     */
    static public int race(Vehicle v1, Vehicle v2, double length) {
        try {
            v1.fullBreak();
            v2.fullBreak();

            double distanceV1 = 0, distanceV2 = 0;
            while (true) {
                distanceV1 += v1.getSpeed();
                distanceV2 += v2.getSpeed();
                if (distanceV1 >= length || distanceV2 >= length) {
                    if (distanceV1 > distanceV2) return 1;
                    else return 2;
                }

                v1.accelerate((Math.random() - 0.3) * 10);
                v2.accelerate((Math.random() - 0.3) * 10);


            }
        } catch(NegativeSpeedException e){
            System.err.println("A negative exception happened");
            return -1;
        }
        finally{
            v1.fullBreak();
            v2.fullBreak();
        }
    }
    /*
    static public int race(Vehicle v1, Car v2, double length){
        return  0;
    }
    static public int race(Car v1, Vehicle v2, double length){
        return  0;
    }
    static public int race(Car v1, Car v2, double length){
        return 0;
    }

     */
}
