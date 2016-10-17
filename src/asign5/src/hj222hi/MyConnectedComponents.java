package hj222hi;

import graphs.ConnectedComponents;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hampus on 2016-10-07.
 */
public class MyConnectedComponents<E> implements ConnectedComponents<E>{
    @Override
    public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {
        Collection<Node<E>> nodes;
        List<Node<E>> fromDFS;
        Collection<Collection<Node<E>>> nodeCollection = new HashSet<>();
        HashSet<Node<E>> visited = new HashSet<>();
        Boolean connected;
        MyDFS<E> dfs = new MyDFS<E>();
        Iterator<Node<E>> iterator = dg.iterator();

        while (iterator.hasNext()){
            connected = false;
            Node<E> n = iterator.next();
            if(!visited.contains(n)){
                fromDFS = dfs.dfs(dg, n);
                for (Node<E> node: fromDFS){
                    if(visited.contains(node)){
                        for(Collection<Node<E>> coll: nodeCollection){
                            if(coll.contains(node)){
                                connected = true;
                                visited.addAll(fromDFS);
                                coll.addAll(fromDFS);
                            }
                        }
                    }
                }

                if(!connected){
                    visited.addAll(fromDFS);
                    nodes = new HashSet<>();
                    nodes.addAll(fromDFS);
                    nodeCollection.add(nodes);
                }
            }
        }


        return nodeCollection;
    }
}
