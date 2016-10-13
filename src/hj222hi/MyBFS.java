package hj222hi;

import graphs.BFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hampus on 2016-10-05.
 */
public class MyBFS<E> implements BFS {
    @Override
    public List<Node<E>> bfs(DirectedGraph graph, Node root) {
        HashSet<Node<E>> visited = new HashSet<>();
        HashSet<Node<E>> hashSet = new HashSet<>();
        List<Node<E>> returningNodes = new ArrayList<>();

        hashSet.add(root);

        return bfsRecursive(returningNodes, hashSet, visited);
    }

    @Override
    public List<Node> bfs(DirectedGraph graph) {
        List<Node<E>> returningNodes = new ArrayList<>();
        HashSet<Node<E>> hashSet = new HashSet<>();
        HashSet<Node<E>> visited = new HashSet<>();

        if(graph.headCount() > 0){
            Iterator<Node<E>> headIterator = graph.heads();
            while (headIterator.hasNext()){
                Node<E> n = headIterator.next();

                if(!visited.contains(n)){
                    n.num = visited.size();
                    hashSet.add(n);
                    returningNodes.add(n);
                    returningNodes = bfsRecursive(returningNodes, hashSet, visited);
                }
            }
        }

        hashSet.add(graph.getNodeFor(graph.allItems().get(0)));
        returningNodes = bfsRecursive(returningNodes, hashSet, visited);
        return null;
    }

    public List<Node<E>> bfsRecursive(List<Node<E>> returningNodes, HashSet<Node<E>> hash, HashSet<Node<E>> visited){


        Iterator<Node<E>> hashIterator = hash.iterator();
        HashSet<Node<E>> newHash = new HashSet<>();


        while (hashIterator.hasNext()) {
            Node<E> n = hashIterator.next();
            if (!visited.contains(n)) {
                n.num = visited.size();
                visited.add(n);
                returningNodes.add(n);
            }

            Iterator<Node<E>> succs = n.succsOf();
            while(succs.hasNext()){
                Node<E> newN = succs.next();
                if(!returningNodes.contains(newN)){
                    newHash.add(newN);
                }
            }

        }

        if(!newHash.isEmpty()){
            bfsRecursive(returningNodes, newHash, visited);
        }

        return returningNodes;
    }
}
