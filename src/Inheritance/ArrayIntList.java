package Inheritance;

import java.lang.reflect.Array;


/**
 * Created by hampus on 2016-09-15.
 */
public class ArrayIntList extends AbstractIntCollection implements IntList {

    public void add(int n){
        if(values.length == size){
            resize();
        }
        values[size] = n;
    }
    public void addAt(int n, int index) throws IndexOutOfBoundsException{
        if(checkIndex(index, size())) {
            if(size() ==values.length){
                resize();
            }

            int place = values[index];
            values[index] = n;
            for (int i = index; i < size() ; i++) {

            }
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }
    public void remove(int index) throws IndexOutOfBoundsException{
        try {
            for (int i = 0; i < values.length; i++) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int get(int index) throws IndexOutOfBoundsException{
        return 0;
    }

    public int size(){
        return 0;
    }
    public boolean isEmpty(){
        return true;
    }
    public int indexOf(int n){
        return 0;
    }

    @Override
    public String toString(){

        String stringToPrint = "";
        for (int i = 0; i < values.length; i++) {
            stringToPrint += values[i];
            stringToPrint += ", ";
        }

        return stringToPrint;
    }

}
