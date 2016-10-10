package hj222hi;

import graphs.BFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.lang.Integer;
/**
 * Created by hampus on 2016-10-05.
 */
public class MyBFS<Integer> implements BFS {
    @Override
    public List<Node> bfs(DirectedGraph graph, Node root) {
        return null;
    }

    @Override
    public List<Node> bfs(DirectedGraph graph) {
        return null;
    }

    public List<Node<Integer>> bfsRecursive(List<Node<Integer>> returningNodes, HashSet<Node<Integer>> hash, HashSet<Node<Integer>> visited){


        Iterator<Node<Integer>> visIterator = hash.iterator();
        HashSet<Node<Integer>> newHash = new HashSet<>();


        while (visIterator.hasNext()) {
            Node<Integer> n = visIterator.next();
            if (!visited.contains(n)) {
                n.num = visited.size();
                visited.add(n);
                returningNodes.add(n);
            }

            Iterator<Node<Integer>> succs = n.succsOf();
            while(succs.hasNext()){
                Node<Integer> newN = succs.next();
                if(!returningNodes.contains(newN)){
                    newHash.add(newN);
                }
            }

        }

        return returningNodes;
    }
}
