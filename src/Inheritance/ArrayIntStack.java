package Inheritance;

/**
 * Created by hampus on 2016-09-17.
 */
public class ArrayIntStack extends AbstractIntCollection implements IntStack {
    @Override
    public void push(int n) {

            if (size() == values.length) {
                resize();
            }

            int place = values[0];
            values[0] = n;
            for (int i = n; i < size(); i++) {
                int tmp = values[i + 1];
                values[i + 1] = place;
                place = tmp;
            }
            size++;

    }
    @Override
    public int pop() throws IndexOutOfBoundsException {
        int returning = values[0];
        for (int i = 0; i < size() ; i++) {
            values[i] = values[i + 1];
        }
        size--;
        return returning;
    }

    @Override
    public int peek() throws IndexOutOfBoundsException {
        if(size() == 0){
            throw  new IndexOutOfBoundsException();
        }
        else {
            return values[0];
        }
    }


    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){

        String stringToPrint = "";
        for (int i = 0; i < size(); i++) {
            stringToPrint += values[i];
            stringToPrint += ", ";
        }

        return stringToPrint;
    }
}
