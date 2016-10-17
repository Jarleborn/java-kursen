package asign5;

import java.util.Iterator;

/**
 * Created by hampus on 2016-09-23.
 */
public class HashWordSet implements WordSet {

    private Node[] buckets = new Node[8];

    private int _size;

    @Override
    public void add(Word word) {
//Adding a new word as longe as its a new one
        int place = getBucketNum(word);
        Node node = buckets[place];


        while(node != null){

            if(node._value.equals(word)){
                return;
            }
            else {

                node = node._next;
            }
        }
        node = new Node(word);
        node._next = buckets[place];
        buckets[place] = node;
        _size++;
        if(_size == buckets.length){
            rehash();
        }

    }
    public int getBucketNum(Word w){

        //gets the number of the bucket containing a spesific word
        int hashCode = w.hashCode();
        if(hashCode < 0){
            hashCode = -hashCode;
        }
        return hashCode % buckets.length;
    }

    public void rehash(){
        //Rehashing when it's out of space
        Node[] temp = buckets;
        buckets = new Node[2*temp.length];
        _size = 0;

        for (Node n : temp){
            if( n == null) continue;
            while(n != null){
                add(n._value);
                n = n._next;
            }
        }
    }
    @Override
    public boolean contains(Word word) {

        //Checking if the Hashset contains a specific word;
        int position = getBucketNum(word);
        Node node = buckets[position];
        while(node != null){
            if(node._value.equals(word)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public Iterator iterator()  {
        return new hashIterator();
    }

    private class hashIterator implements Iterator<Word>{
        private Node n;
        private int buketIndex;

        @Override
        public boolean hasNext() {
            //return trus if there is a another number next in line
            if(n != null && n._next != null){
                return true;
            }
            for (int i = buketIndex + 1; i < buckets.length ; i++) {
                if(buckets[i] != null){
                    return true;
                }
            }
            return false;
        }

        @Override
        public Word next() {
        //gets the next number
            if(n != null && n._next != null){
                n = n._next;
            }
            else{
                do {
                    buketIndex++;
                    if(buketIndex > buckets.length){
                        throw new IndexOutOfBoundsException();
                    }
                    n = buckets[buketIndex];
                }while (n == null);

            }
            return n._value;
        }
    }


    private class Node {
        Word _value;
        Node _next = null;

        public Node (Word word) {
            _value = word;
        }

        public String toString() {
            return _value.toString();
        }
    }
}






