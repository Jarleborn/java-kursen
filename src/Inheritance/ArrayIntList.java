package Inheritance;

import java.lang.reflect.Array;


/**
 * Created by hampus on 2016-09-15.
 */
public class ArrayIntList extends AbstractIntCollection implements IntList {

    public void add(int n){
        if(values.length == size()){
            resize();
        }
        values[size()] = n;
        size++;
    }
    public void addAt(int n, int index) throws IndexOutOfBoundsException{

        try {
            if(checkIndex(index, size())) {
                if(size() == values.length){
                    resize();
                }

                int place = values[index];
                values[index] = n;
                for (int i = index; i < size() ; i++) {
                    int tmp = values[i + 1];
                    values[i + 1 ] = place;
                    place = tmp;
                }
                size++;
            }
        } catch (Exception e) {
            throw new IndexOutOfBoundsException();
        }


    }
    public void remove(int index) throws IndexOutOfBoundsException{
        try {
            for (int i = index; i < size(); i++) {
                values[i] = values[i +1];
            }
            size--;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int get(int index) throws IndexOutOfBoundsException{

        try {
            return values[index];
        } catch (Exception e) {
            throw new IndexOutOfBoundsException();
        }


    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }
    public int indexOf(int n){
        for (int i = 0; i < size() ; i++) {
            if(values[i] == n){
                return i;
            }
        }
        return -1;
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
