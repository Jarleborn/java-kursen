package hj222hi;

import graphs.DirectedGraph;
import graphs.Node;


import java.util.*;

/**
 * Created by hampus on 2016-09-30.
 */
public class MyGraph<E> implements DirectedGraph{

    private Map<E, MyNode<E>> _graph = new HashMap<E, MyNode<E>>();
    private Set<MyNode<E>> _heads = new HashSet<MyNode<E>>();
    private Set<MyNode<E>> _tails = new HashSet<MyNode<E>>();
    public MyGraph(){
        _graph = new HashMap<>();
        _heads = new HashSet<>();
        _tails = new HashSet<>();
    }

    @Override
    public MyNode addNodeFor(E item) {
        //Fell exception BRE
        if(item == null){ throw new IndexOutOfBoundsException();}

        if(!_graph.containsKey(item)){
            MyNode<E> node = new MyNode<E>(item);
            _heads.add(node);
            _tails.add(node);
            _graph.put(item, node);
        }

    }

    @Override
    public MyNode getNodeFor(E item) {
        if (item != null && !_graph.containsKey(item)){
            return _graph.get(item);
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean addEdgeFor(E from, E to) {

        if(from != null || to != null){
            MyNode From = (MyNode<E>) addNodeFor(from);
            MyNode To = (MyNode<E>) addNodeFor(to);

            if(From.hasSucc(To)){
                return false;
            }else {
                From.addSucc(To);
                To.addPred(From);

                _tails.remove(From);
                _heads.remove(To);

            }
        }else {
            throw new IndexOutOfBoundsException();
        }

        return false;
    }

    @Override
    public boolean containsNodeFor(E item) {
        return _graph.containsKey(item) || _graph.containsValue(item);
    }

    @Override
    public int nodeCount() {
        return _graph.size();
    }

    @Override
    public Iterator<MyNode> iterator() {
        return null;
    }

    @Override
    public Iterator<MyNode> heads() {
        return null;
    }

    @Override
    public int headCount() {
        return 0;
    }

    @Override
    public Iterator<MyNode> tails() {
        return null;
    }

    @Override
    public int tailCount() {
        return 0;
    }

    @Override
    public List allItems() {
        return null;
    }

    @Override
    public int edgeCount() {
        return 0;
    }

    @Override
    public void removeNodeFor(Object item) {

    }

    @Override
    public boolean containsEdgeFor(Object from, Object to) {
        return false;
    }

    @Override
    public boolean removeEdgeFor(Object from, Object to) {
        return false;
    }
}
