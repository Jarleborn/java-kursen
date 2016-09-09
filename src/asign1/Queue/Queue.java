package asign1.Queue;

/**
 * Created by hampus on 2016-09-10.
 */
public class Queue implements QueueInterface {

    private int _size = 0;
    private Node head = null;
    private Node tail = null;

    @Override
    public int Size(){
        return _size;
    }

    @Override
    public boolean isEmpty(){
        if(size() == 0){
            return true;
        }
        return false;

    }

    @Override
    public void enqueue(Object element){

    }

    @Override
    public Object dequeue() throws IndexOutOfBoundsException{
        return new Object();
    }

    @Override
    public Object first() throws IndexOutOfBoundsException{
        return new Object();
    }

    @Override
    public Object last() throws IndexOutOfBoundsException{
        return new Object();
    }

    @Override
    public boolean contains(Object o){
        return true;
    }

    private class Node {
        private Node _next = null;
        private Object _object;

        public void setNode(Object object){
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

