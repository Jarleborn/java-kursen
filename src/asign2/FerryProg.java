package asign2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by hampus on 2016-09-17.
 */
public class FerryProg implements Ferry {
    private int maxPassengerCapacite = 200;
    private int maxSpaceCapacite = 40;
    private ArrayList<Passenger> _passengers;
    private ArrayList<Vehicle> _venichles;
    private int earnedMoney = 0;
    private double usedSpace = 0;

    public FerryProg(){
        _passengers = new ArrayList<Passenger>();
        _venichles = new ArrayList<Vehicle>();
    }
    @Override
    public int countPassengers() {

        return _passengers.size();
    }

    @Override
    public int countVehicleSpace() {

        return (int)usedSpace;
    }

    @Override
    public int countMoney() {
        return earnedMoney;
    }

    @Override
    public void embark(Vehicle v) {
        if(hasSpaceFor(v) && v.getPassengers().size() <= maxPassengerCapacite - countPassengers()){
            ArrayList passengersInVenichle = v.getPassengers();

            for(Passenger p: v.getPassengers()) {
                embark(p);
            }
            earnedMoney+= v.getPrice();
            usedSpace += v.getSpace();
            _venichles.add(v);
        }

    }

    @Override
    public void embark(Passenger p) {
        if(hasRoomFor(p)){
            _passengers.add(p);
            earnedMoney += p.getCost();
        }
        else {
            System.err.println("The boat is full sorry");
        }
    }

    @Override
    public void disembark() {
        _venichles.clear();
        _passengers.clear();
        earnedMoney = 0;
        usedSpace = 0;


    }

    @Override
    public boolean hasSpaceFor(Vehicle v) {
        if(v.getPassengers().size() > v.getMaxPassengers()) {
            return false;
        }
        else if(usedSpace + v.getSpace() <= maxSpaceCapacite && !_venichles.contains(v)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean hasRoomFor(Passenger p) {
        if(_passengers.size() >= maxPassengerCapacite){
            return false;
        }
        return true;
    }


    @Override
    public Iterator<Vehicle> iterator() {
        return new Iterator<Vehicle>() {
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < _venichles.size();
            }

            @Override
            public Vehicle next() {
                return _venichles.get(count++);
            }
        };
    }

    public String toString(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String textToPrintOut = "";

        textToPrintOut += "Ferry deporting at 8pm "+ dateFormat.format(date) + "\n";
        textToPrintOut += "Number of passengers "+ countPassengers() + "/"+ maxPassengerCapacite + "\n";
        textToPrintOut += "Number of venichles "+ _venichles.size()  + " \n";
        textToPrintOut += "Used vehicle space           : " + Math.ceil(usedSpace) + "/" + maxSpaceCapacite + " \n";
        textToPrintOut += "Money earned               : " + earnedMoney + " kr \n";
        textToPrintOut += "\n\n";

        return textToPrintOut;
    }
}
