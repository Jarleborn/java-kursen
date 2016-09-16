package asign1.Queue;

import java.util.Iterator;


/**
 * Created by hampus on 2016-09-10.
 */
public class Queue implements QueueInterface {

    private int _size = 0;
    private Node head = null;
    private Node tail = null;

    @Override
    public int size(){
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
        if(head == null){
            head = new Node(element);
            tail = head;
        }
        else{
            tail.setNext(new Node(element));
            tail = tail.getNext();
        }

        _size++;
    }

    @Override
    public Object dequeue() throws IndexOutOfBoundsException{

        if(head != null){
            Node nodeThatWillLeave = head;
            head = nodeThatWillLeave.getNext();
            _size--;
            return nodeThatWillLeave.getNode();
        }
        else{
            throw new IndexOutOfBoundsException();
        }

    }

    @Override
    public Object first() throws IndexOutOfBoundsException{
        if(head == null){
            throw new IndexOutOfBoundsException();
        }
        return head.getNode();
    }

    @Override
    public Object last() throws IndexOutOfBoundsException{
        if(tail == null){
            throw new IndexOutOfBoundsException();
        }
        return tail.getNode();
    }

    public Iterator iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Object>{
        private Node node = head;

        public  boolean hasNext(){
            if(node == null){
                return false;
            }
                return true;
        }
        public Object next() throws IndexOutOfBoundsException{
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

    @Override
    public boolean contains(Object o){
        return true;
    }

    private class Node {
        private Node _next = null;
        private Object _object;

        public Node(Object object){
            _object = object;
        }

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

