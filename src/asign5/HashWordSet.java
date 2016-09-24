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

        int place = getBucketNum(word);
        Node node = buckets[place];


        while(node != null){

            if(node.value.equals(word)){
                return;
            }
            else {

                node = node.next;
            }
        }
        node = new Node(word);
        node.next = buckets[place];
        buckets[place] = node;
        _size++;
        if(_size == buckets.length){
            rehash();
        }

    }
    public int getBucketNum(Word w){
        int hashCode = w.hashCode();
        if(hashCode < 0){
            hashCode = -hashCode;
        }
        return hashCode % buckets.length;
    }

    public void rehash(){
        Node[] temp = buckets;
        buckets = new Node[2*temp.length];
        _size = 0;

        for (Node n : temp){
            if( n == null) continue;
            while(n != null){
                add(n.value);
                n = n.next;
            }
        }
    }
    @Override
    public boolean contains(Word word) {
        int position = getBucketNum(word);
        Node node = buckets[position];
        while(node != null){
            if(node.value.equals(word)){
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
            if(n != null && n.next != null){
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
            if(n != null && n.next != null){
                n = n.next;
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
            return n.value;
        }
    }


    private class Node {
        Word value;
        Node next = null;

        public Node (Word word) {
            value = word;
        }

        public String toString() {
            return value.toString();
        }
    }
}






