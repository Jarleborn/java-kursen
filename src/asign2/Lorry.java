package asign2;

/**
 * Created by hampus on 2016-09-18.
 */
public class Lorry extends Vehicle {

    private static int _price = 300;
    private static int _maxPassengers = 2;
    private static double _space = 8;
    private static int _costPerPassenger = 12;
    private int _numberOfPassangers;

    public Lorry(int numberOfPassangers) {
        super(_price, _maxPassengers, _space, _costPerPassenger, numberOfPassangers);
        _numberOfPassangers = numberOfPassangers;
    }
}
