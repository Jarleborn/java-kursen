package hj222hi;

import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


/**
 * Created by hampus on 2016-10-05.
 */
public class MyDFS<E> implements DFS<E> {
    private int count = 0;

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {

        List<Node<E>> toBeReturned = new ArrayList<>();
        HashSet<Node<E>> hashSet = new HashSet<>();

        return dfsRecursive(toBeReturned, root, hashSet);
    }

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph) {
        List<Node<E>> toBeReturned = new ArrayList<>();
        HashSet<Node<E>> hashSet = new HashSet<>();

        if(graph.headCount() > 0 ){
            Iterator<Node<E>> heads = graph.heads();

            while (heads.hasNext()){
                toBeReturned = dfsRecursive(toBeReturned, heads.next(), hashSet);
            }
        }
        else{
            toBeReturned = dfsRecursive(toBeReturned, graph.getNodeFor(graph.allItems().get(0)), hashSet);
        }

        return toBeReturned;
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
        List<Node<E>> listToBeReturned = new ArrayList<>();
        HashSet<Node<E>> listOfVisited = new HashSet<>();

        return postOrderRecursive(listOfVisited, listToBeReturned, root);

    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g) {
        return null;
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
        return null;
    }

    @Override
    public boolean isCyclic(DirectedGraph<E> graph) {
        Iterator<Node<E>> it = graph.iterator();

        while (it.hasNext()){
            Node<E> source = it.next();
            Iterator<Node<E>> it2 = source.succsOf();
            while (it2.hasNext()){
                if(it2.next().hasSucc(source)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<Node<E>> topSort(DirectedGraph<E> graph) {
        return null;
    }



    //_Extras_____________________________________________Extras_______________________________________________________Extras_

    public List<Node<E>> dfsRecursive(List<Node<E>> list, Node<E> root, HashSet<Node<E>> hash){
        Iterator<Node<E>> succs = root.succsOf();
        root.num = list.size();
        list.add(root);
        hash.add(root);

        while(succs.hasNext()){
            Node<E> node = succs.next();
            if(hash.contains(root)){
                dfsRecursive(list, root, hash);
            }
        }
        return list;
    }

    public List<Node<E>> postOrderRecursive(HashSet<Node<E>> visited, List<Node<E>> listToBeReturned, Node<E> root){
        if(root != null){
            if(!visited.contains(root)){
                Iterator<Node<E>> succs = root.succsOf();
                visited.add(root);

                while (succs.hasNext()){
                    Node<E> n = succs.next();
                    if(!visited.contains(n)){
                        postOrderRecursive(visited, listToBeReturned, n);
                    }
                }
                root.num = listToBeReturned.size() + 1;
                listToBeReturned.add(root);
            }
        }
        return listToBeReturned;
    }
}
