/*
    Route between nodes: Given a directed graph, design and algorithm to find out whether there is a route between two nodes
 */

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class RouteBetweenVisitableNodes {

    public static <T> boolean exists(NodeVisitable<T> origin, NodeVisitable<T> destiny) {
        assert (origin != null && destiny != null);

        Queue<NodeVisitable> pendingToVisitNodes = new LinkedList<>();

        pendingToVisitNodes.add(origin);

        while (!pendingToVisitNodes.isEmpty()) {
            NodeVisitable node = pendingToVisitNodes.poll();
            if (node.equals(destiny)) {
                return true;
            }
            if (node.isVisited()) {
                continue;
            }
            node.setVisited(true);
            for (NodeVisitable<T> adjacent : (Collection<NodeVisitable<T>>) node.getAdjacents()) {
                if (adjacent.equals(destiny)) {
                    return true;
                }
                pendingToVisitNodes.offer(adjacent);
            }
        }


        return false;
    }


}
