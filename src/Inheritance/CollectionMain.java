package Inheritance;

/**
 * Created by hampus on 2016-09-16.
 */
public class CollectionMain {

    public static void main(String[] args) {

        try {
            // Testing ArrayIntList
            System.out.println("Testing ArrayIntList\n");
            ArrayIntList list = new ArrayIntList();




            // addAt

            list.add(8);
            list.addAt(9, 5);
            System.out.println("Whole list: " + list.toString());
            System.out.println("Add 5 at index 1: ");
            list.addAt(5, 1);
            System.out.println("Whole list: " + list.toString());

        }
        catch(IndexOutOfBoundsException e) {
            e.getMessage();
            System.out.println("Index is out of bounds!");
        }
    }
}
