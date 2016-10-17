package hj222hi;

import graphs.DirectedGraph;
import graphs.GML;
import graphs.Node;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by hampus on 2016-09-30.
 */
public class MyGML<E> extends GML<E> {

    public MyGML(DirectedGraph<E> dGraph){
        super(dGraph);
    }
    @Override
    public String toGML() {
        Map<Node<E>, Integer> map = new HashMap<>();
        String stringToGML = "graph\n[";
        int id = 0;

        for(E i: graph.allItems()){
            Node<E> n = graph.getNodeFor(i);
            stringToGML += "\n\tnode\n\t["+ "\n\t\tid " +id+ "\n\t\tlabel \"" + n + "\"" + "\n\t]";
            map.put(n, id);
            id++;
        }
        id = 0;
        for(E i: graph.allItems()){
            Node<E> n = graph.getNodeFor(i);

            Iterator<Node<E>> it = n.succsOf();

            while(it.hasNext()){
                stringToGML += "\n\tedge\n\t[" +"\n\t\tsource " + map.get(n) +"\n\t\ttarget " + map.get(it.next()) + "\n\t]";
            }
            stringToGML += "\n]";
        }

        return stringToGML;
    }
}
