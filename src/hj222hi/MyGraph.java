package hj222hi;

import graphs.DirectedGraph;
import graphs.Node;


import java.util.*;

/**
 * Created by hampus on 2016-09-30.
 */
public class MyGraph<E> implements DirectedGraph<E>{

    private Map<E, MyNode<E>> _graph;
    private Set<Node<E>> _heads;
    private Set<Node<E>> _tails;

    public MyGraph(){
        _graph = new HashMap<E, MyNode<E>>();
        _heads = new HashSet<Node<E>>();
        _tails = new HashSet<Node<E>>();
    }

    @Override
    public MyNode<E> addNodeFor(E item) {
        //Fell exception BRE
        if(item == null){ throw new IndexOutOfBoundsException();}
        MyNode<E> node = null;
        if(!_graph.containsKey(item)){
           node = new MyNode<E>(item);
            _heads.add(node);
            _tails.add(node);
            _graph.put(item, node);
        }
        return node;
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
        if (item == null){throw new IndexOutOfBoundsException();}
        return _graph.containsKey(item);

    }

    @Override
    public int nodeCount() {
        return _graph.size();
    }

    @Override
    public Iterator<Node<E>> iterator() {

        HashMap h = new HashMap();

            h.putAll(_graph);

        return h.values().iterator();
    }

    @Override
    public Iterator<Node<E>> heads() {

        return _heads.iterator();
    }

    @Override
    public int headCount() {
        return _heads.size();
    }

    @Override
    public Iterator<Node<E>> tails() {
        return _tails.iterator();
    }

    @Override
    public int tailCount() {
        return _tails.size();
    }

    @Override
    public List allItems() {

        ArrayList list = new ArrayList();

        for(MyNode<E> node: _graph.values()  ) {
            list.add(node.item());
        }
        return list;
    }

    @Override
    public int edgeCount() {
        int edges = 0;

        for(MyNode<E> node: _graph.values()){
            edges += node.outDegree();
        }
        return edges;
    }

    @Override
    public void removeNodeFor(E item) {
        if(item == null || _graph.containsKey(item)){throw new IndexOutOfBoundsException();}

        MyNode<E> toBeRemoved = new MyNode<E>(item);

        for(MyNode<E> node: _graph.values()){
            if(node.hasSucc(toBeRemoved)){
                node.removeSucc(toBeRemoved);
            }
            if(node.hasPred(toBeRemoved)){
                node.removePred(toBeRemoved);
            }
        }
        toBeRemoved.disconnect();
        _graph.remove(item);
    }

    @Override
    public boolean containsEdgeFor(Object from, Object to) {
        if(from == null || to == null){throw new IndexOutOfBoundsException();}

        if(_graph.containsKey(from) && _graph.containsKey(to)){
            if(_graph.get(from).hasSucc(_graph.get(to))){
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean removeEdgeFor(Object from, Object to) {
        if(from == null || to == null){throw new IndexOutOfBoundsException(); }

        if(containsEdgeFor(from, to)){
            MyNode<E> fromNode = _graph.get(from);
            MyNode<E> toNode = _graph.get(to);
            fromNode.removeSucc(toNode);
            toNode.removePred(fromNode);
            if (fromNode.isHead()){_heads.add(fromNode);}
            if(fromNode.isTail()){ _tails.add(fromNode);}
            if (toNode.isHead()){_heads.add(toNode);}
            if(toNode.isTail()){ _tails.add(toNode);}

            return true;
        }
        return false;
    }


    //FIxa så att du använder metoden!!!
    @Override
    public String toString(){
        String toPrint = "";

        Iterator<MyNode<E>> iterator = _graph.values().iterator();
        while (iterator.hasNext()){
            toPrint += iterator.next();
        }
        return toPrint;
    }
}
