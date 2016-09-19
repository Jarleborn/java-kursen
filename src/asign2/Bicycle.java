package asign2;

import java.util.ArrayList;

/**
 * Created by hampus on 2016-09-18.
 */
public class Bicycle extends Vehicle {
    private static int _price = 40;
    private static double _space= 0.2;

    public Bicycle() {
        super(_price, 1, _space, 0, 1);
    }
}
