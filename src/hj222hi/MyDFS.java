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
public class MyDFS<E> implements DFS<Integer> {
    private int count = 0;

    @Override
    public List<Node<Integer>> dfs(DirectedGraph<Integer> graph, Node<Integer> root) {

        List<Node<Integer>> toBeReturned = new ArrayList<>();
        HashSet<Node<Integer>> hashSet = new HashSet<>();

        return dfsRecursive(toBeReturned, root, hashSet);
    }

    @Override
    public List<Node<Integer>> dfs(DirectedGraph<Integer> graph) {
        List<Node<Integer>> toBeReturned = new ArrayList<>();
        HashSet<Node<Integer>> hashSet = new HashSet<>();

        if(graph.headCount() > 0 ){
            Iterator<Node<Integer>> heads = graph.heads();

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
    public List<Node<Integer>> postOrder(DirectedGraph<Integer> g, Node<Integer> root) {
        List<Node<Integer>> listToBeReturned = new ArrayList<>();
        HashSet<Node<Integer>> listOfVisited = new HashSet<>();

        return postOrderRecursive(listOfVisited, listToBeReturned, root);

    }

    @Override
    public List<Node<Integer>> postOrder(DirectedGraph<Integer> g) {
        return null;
    }

    @Override
    public List<Node<Integer>> postOrder(DirectedGraph<Integer> g, boolean attach_dfs_number) {
        return null;
    }

    @Override
    public boolean isCyclic(DirectedGraph<Integer> graph) {
        Iterator<Node<Integer>> it = graph.iterator();

        while (it.hasNext()){
            Node<Integer> source = it.next();
            Iterator<Node<Integer>> it2 = source.succsOf();
            while (it2.hasNext()){
                if(it2.next().hasSucc(source)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<Node<Integer>> topSort(DirectedGraph<Integer> graph) {
        return null;
    }



    //_Extras_____________________________________________Extras_______________________________________________________Extras_

    public List<Node<Integer>> dfsRecursive(List<Node<Integer>> list, Node<Integer> root, HashSet<Node<Integer>> hash){
        Iterator<Node<Integer>> succs = root.succsOf();
        root.num = list.size();
        list.add(root);
        hash.add(root);

        while(succs.hasNext()){
            Node<Integer> node = succs.next();
            if(hash.contains(root)){
                dfsRecursive(list, root, hash);
            }
        }
        return list;
    }

    public List<Node<Integer>> postOrderRecursive(HashSet<Node<Integer>> visited, List<Node<Integer>> listToBeReturned, Node<Integer> root){
        if(root != null){
            if(!visited.contains(root)){
                Iterator<Node<Integer>> succs = root.succsOf();
                visited.add(root);

                while (succs.hasNext()){
                    Node<Integer> n = succs.next();
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
