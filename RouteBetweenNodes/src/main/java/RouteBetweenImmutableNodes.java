/*
    Route between nodes: Given a directed graph, design and algorithm to find out whether there is a route between two nodes
 */

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class RouteBetweenImmutableNodes {

    public static <T> boolean exists(Node<T> origin, Node<T> destiny) {
        assert (origin != null && destiny != null);

        Queue<Node> pendingToVisitNodes = new LinkedList<>();
        HashMap<Integer, Boolean> visitedElements = new HashMap();

        pendingToVisitNodes.add(origin);

        while (!pendingToVisitNodes.isEmpty()) {
            Node node = pendingToVisitNodes.poll();
            if (node.equals(destiny)) {
                return true;
            }
            if (visitedElements.getOrDefault(Integer.valueOf(node.hashCode()), false)) {
                continue;
            }
            visitedElements.put(node.hashCode(), true);
            for (Node<T> adjacent : (Collection<Node<T>>) node.getAdjacents()) {
                if (adjacent.equals(destiny)) {
                    return true;
                }
                pendingToVisitNodes.offer(adjacent);
            }
        }


        return false;
    }


}
