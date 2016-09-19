package asign2;

import Inheritance.ArrayIntList;

import java.util.ArrayList;

/**
 * Created by hampus on 2016-09-17.
 */
public class Vehicle {
    private int _price;
    private int _maxPassengers;
    private double _space;
    private int _costPerPassenger;
    private ArrayList _passengers = new ArrayList();
    private int _numberOfPassangers;


    public Vehicle(int price, int maxPassengers, double space, int costPerPassenger, int numberOfPassangers){

        _price = price;
        _maxPassengers = maxPassengers;
        _space = space;
        _costPerPassenger = costPerPassenger;
        _numberOfPassangers = numberOfPassangers;

        for(int i = 0; i < numberOfPassangers; i++) {
            _passengers.add(new Passenger(_costPerPassenger));
        }

    }
    public int getNumberOfPassangers(){
        return _numberOfPassangers;
    }
    public void setCostPerPassenger(int costPerPassenger){
        _costPerPassenger = costPerPassenger;
    }

    public void setSpace(double space){
        _space = space;
    }

    public int getcostPerPassenger(){
        return _costPerPassenger;
    }

    public int getPrice(){
        return _price;
    }

    public int getMaxPassengers(){
        return _maxPassengers;
    }

    public double getSpace(){
        return _space;
    }

    public ArrayList<Passenger> getPassengers(){
        return _passengers;
    }


}
