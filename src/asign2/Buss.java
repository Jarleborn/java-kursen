package asign2;

/**
 * Created by hampus on 2016-09-18.
 */
public class Buss extends Vehicle{
    private static int _price = 200;
    private static int _maxPassengers = 20;
    private static double _space = 4;
    private static int _costPerPassenger = 10;
    private int _numberOfPassangers;

   public Buss(int numberOfPassangers){
       super(_price, _maxPassengers, _space, _costPerPassenger, numberOfPassangers);

       _numberOfPassangers = numberOfPassangers;
   }

}