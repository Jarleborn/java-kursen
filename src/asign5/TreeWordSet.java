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
            //If right is assigned set n to that one
            if(n.right != null){
                n = n.right;
                //If parent is unset set the initial node as parent
                if(n.paretn == null){
                    n.paretn = returning;
                }
                //While left is not null set save inital as parent and save left over the initaial
                while (n.left != null ){

                    Node tmp = n;
                    n = n.left;
                    n.paretn = tmp;
                }
            }
            else{
                //If right is null
                while (n.visited){
                    //and initial node is visited
                    //set it to nonvisitied
                    Node tmp = n;
                    n.visited = false;
                    //if parent is unset set initial as null and breake the loop
                    if(n.paretn == null) {
                        n = null;
                        break;
                    }
                    //if parent is set save over the initial with the parent
                    n = tmp.paretn;
                }

            }

            return returning.word;


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
