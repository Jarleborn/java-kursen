package hj222hi;

import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


/**
 * Created by hampus on 2016-10-05.
 */
public class MyDFS<E> implements DFS<E> {

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {

        List<Node<E>> toBeReturned = new ArrayList<>();
        return dfsRecursive(toBeReturned, root);
    }

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph) {
        List<Node<E>> toBeReturned = new ArrayList<>();
        

        if(graph.headCount() > 0 ){
            Iterator<Node<E>> heads = graph.heads();

            while (heads.hasNext()){
                toBeReturned = dfsRecursive(toBeReturned, heads.next());
            }
            
        }
        else{
        	toBeReturned =  dfsRecursive(toBeReturned, graph.getNodeFor(graph.allItems().get(0)));
        }

        return toBeReturned;
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
        List<Node<E>> listToBeReturned = new ArrayList<>();
        HashSet<Node<E>> listOfVisited = new HashSet<>();

        return postOrderRecursive(listOfVisited, listToBeReturned, root);

    }

   /* @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g) {
        return null;
    }*/

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
    	HashSet<Node<E>> visitedList = new HashSet<>();
		List<Node<E>> returnList = new ArrayList<>();
		Iterator<Node<E>> heads = g.heads();

		while (heads.hasNext()) {
			returnList = postOrderRecursive(visitedList, returnList, heads.next());
			
		}
		return returnList;
		
		
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
        if(!isCyclic(graph)){
        	List<Node<E>> list = new ArrayList<>();
        	HashSet<Node<E>> listedOfNodes = new HashSet<Node<E>>();
        	
        	if(graph.headCount() > 0){
        		Iterator<Node<E>> iterator = graph.heads();
        		while (iterator.hasNext()) {
					list = postOrderRecursive(listedOfNodes, list,  iterator.next());
					
				}
        	}
        	else{
        		Node<E> _nextItem = graph.getNodeFor(graph.allItems().get(0));
                list = postOrderRecursive(listedOfNodes,list,_nextItem);
        	}
        	
        	
        	Collections.reverse(list);
        	return list;
        }
        throw new RuntimeException("Grap has to be notcyclic");
    }



    //_Extras_____________________________________________Extras_______________________________________________________Extras_

    public List<Node<E>> dfsRecursive(List<Node<E>> list, Node<E> root){
        Iterator<Node<E>> succs = root.succsOf();
        root.num = list.size();
        if(!list.contains(root)){
        	list.add(root);
        }      
        while(succs.hasNext()){
            Node<E> node = succs.next();
            if(!list.contains(node)){
                dfsRecursive(list, node);
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
                    if(!listToBeReturned.contains(n)){
                        postOrderRecursive(visited, listToBeReturned, n);
                    }
                }
                root.num = listToBeReturned.size()+1;
                listToBeReturned.add(root);
            }
        }
        return listToBeReturned;
    }

	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g) {
		List<Node<E>> nodes = new ArrayList<>();
		HashSet<Node<E>> visitedList = new HashSet<>();
        if(g.headCount() > 0)
        {
            Iterator<Node<E>> nodeiterator = g.heads();
            while(nodeiterator.hasNext()) //Iterate heads if avalible, else specific node
            {
                Node<E> nextItem = nodeiterator.next();
                nodes = postOrderRecursive(visitedList, nodes, nextItem);

            }
        }
        else
        {

            Node<E> _nextItem = g.getNodeFor(g.allItems().get(0));
            nodes =  postOrderRecursive(visitedList,nodes,_nextItem);
        }
        return nodes;

	}
}
