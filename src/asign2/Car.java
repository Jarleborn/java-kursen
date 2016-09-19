package asign2;

import java.util.ArrayList;

/**
 * Created by hampus on 2016-09-18.
 */
public class Car extends Vehicle {
    private static int _price = 100;
    private static int _maxPassengers = 4;
    private static double _space = 1;
    private static int _costPerPassenger = 15;
    private int _numberOfPassangers;

    public Car(int numberOfPassangers){
        super(_price, _maxPassengers, _space, _costPerPassenger, numberOfPassangers);
        _numberOfPassangers = numberOfPassangers;


    }

}

//public Vehicle(int price, int maxPassengers, double space, int costPerPassenger, int numberOfPassangers){