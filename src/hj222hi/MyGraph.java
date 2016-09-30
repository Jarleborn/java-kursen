package hj222hi;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by hampus on 2016-09-30.
 */
public class MyGraph implements DirectedGraph{
    private MyGraph graph;
    public MyGraph(){
        graph =  new MyGraph();
    }

    @Override
    public Node addNodeFor(Object item) {
        return null;
    }

    @Override
    public Node getNodeFor(Object item) {
        return null;
    }

    @Override
    public boolean addEdgeFor(Object from, Object to) {
        return false;
    }

    @Override
    public boolean containsNodeFor(Object item) {
        return false;
    }

    @Override
    public int nodeCount() {
        return 0;
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
