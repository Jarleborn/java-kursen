package asign5;

import java.util.Iterator;

/**
 * Created by hampus on 2016-09-23.
 */
public class TreeWordSet implements WordSet {

    private Node _root = null;
    private int _size = 0;
    @Override
    public void add(Word word) {
        if(_root == null){
            _root = new Node(word);
        }
        else if(!contains(word)){
            _root.add(word);
        }
        else {
            return;
        }
        _size++;
    }

    @Override
    public boolean contains(Word word) {
        if(_root == null){
            return false;
        }
        else {
            return _root.contains(word);
        }
    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    private class TreeIterator implements Iterator<Word>{
        Node n = null;

        public TreeIterator(){
            Node temp = n;
            n = n.left;
            n.paretn = temp;

        }
        @Override
        public boolean hasNext() {
            return n == null;
        }

        @Override
        public Word next() {
            n.visited = true;
            if(n.left != null){
                Node theNode = n.
            }

            if(node != null){

                Object theNode =  node.getNode();
                node = node.getNext();
                return theNode;
            }
            else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    private class Node {
        Word word;
        Node left = null;
        Node right = null;
        Node paretn = null;
        boolean visited = false;

        public Node (Word w){
            word = w;
        }
        public void add(Word w){
            if(w.compareTo(word) < 0){
                if(left == null){
                    left = new Node(w);
                }
                else{
                    left.add(w);
                }
            }
            else if(w.compareTo(word) > 0){
                if(right == null){
                    right = new Node (w);
                }
                else{
                    right.add(w);
                }
            }
        }

        public boolean contains (Word w){
            if (w.compareTo(word) < 0) {
                if(left == null){
                    return false;
                }
                else {
                    return left.contains(w);
                }
            }else if(w.compareTo(word) > 0){

                if(right == null){
                    return false;
                }else{
                    return right.contains(w);
                }
            }
            return true;
        }


    }
}
