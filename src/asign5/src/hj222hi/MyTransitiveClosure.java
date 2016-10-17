package hj222hi;


import graphs.DirectedGraph;
import graphs.Node;
import graphs.TransitiveClosure;

import java.util.*;

/**
 * Created by hampus on 2016-10-07.
 */
public class MyTransitiveClosure<E> implements TransitiveClosure<E>{
    @Override
    public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {

        MyDFS<E> dfs = new MyDFS<E>();
        Iterator<Node<E>> iterator = dg.iterator();
        Map<Node<E>, Collection<Node<E>>> map = new HashMap<>();
        Collection<Node<E>> nodes = new HashSet<>();

        while (iterator.hasNext()){
            Node<E> n = iterator.next();
            nodes = dfs.dfs(dg, n);
            map.put(n, nodes);
        }
        return map;
    }
}
