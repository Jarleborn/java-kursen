package Exercise4;

import java.util.Iterator;


/**
 * Created by hampus on 2016-09-10.
 */
public class Queue<E> implements QueueInterface<E> {

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
    public void enqueue(E element) {
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
    public E dequeue() throws IndexOutOfBoundsException{

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
    public E first() throws IndexOutOfBoundsException{
        if(head == null){
            throw new IndexOutOfBoundsException();
        }
        return head.getNode();
    }

    @Override
    public E last() throws IndexOutOfBoundsException{
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


    private class Node {
        private Node _next = null;
        private E _object;

        public Node(E object){
            _object = object;
        }

        public void setNode(E object){
            _object = object;
        }
        public E getNode(){
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

