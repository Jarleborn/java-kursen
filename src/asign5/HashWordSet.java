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
     int key = word.hashCode();
        Node node = buckets[getBucketNum(word)];
        while(node != null){
            if(node.getNode().equals(word)){
                return;
            }
            else {
                node = node.getNext();
            }

            node = new Node(word);
            node.setNext(buckets[getBucketNum(word)]);
            buckets[getBucketNum(word)] = node;
            _size++;
            if(_size == buckets.length){
                rehash();
            }
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
                add(n._object);
                n = n.getNext();
            }
        }
    }
    @Override
    public boolean contains(Word word) {
        int position = getBucketNum(word);
        Node node = buckets[position];
        while(node != null){
            if(node._object.equals(word)){
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
    public Iterator iterator() {
        Iterator iterator = new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };
        return iterator;
    }


    private class Node {
        private Node _next = null;
        private Word _object;

        public Node(Word object){
            _object = object;
        }

        public void setNode(Word object){
            _object = object;
        }
        public Object getNode(){
            return _object;
        }

        public void setNext(Node node){
            _next = node;
        }

        public Node getNext(){
            return _next;
        }


    }
}






