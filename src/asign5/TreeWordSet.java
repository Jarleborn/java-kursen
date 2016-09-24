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
        return new TreeIterator();
    }

    private class TreeIterator implements Iterator<Word>{
        private Node n = null;

        public TreeIterator(){
             n = _root;
            while (n.left != null){
                Node tmp = n;
                n = n.left;
                n.paretn = tmp;
            }
        }

        @Override
        public boolean hasNext() {
            return n != null;
        }

        @Override
        public Word next() {
            n.visited = true;
            Node returning = n;
            if(n.right != null){
                n = n.right;
                if(n.paretn == null){
                    n.paretn = returning;
                }
                while (n.left != null ){
                    Node tmp = n;
                    n = n.left;
                    n.paretn = tmp;
                }
            }
            else{
                while (n.visited){
                    Node tmp = n;
                    n.visited = false;
                    if(n.paretn == null) {
                        n = null;
                        break;
                    }
                    n = tmp.paretn;
                }

            }

            return returning.word;


        }
    }

    @Override
    public String toString() {
        Iterator<Word> iterator = new TreeIterator();

        String toPrint = "";
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        return "kuken";
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
