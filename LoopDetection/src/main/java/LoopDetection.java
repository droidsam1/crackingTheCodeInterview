/*
    Given a circular linked list, implement and algorithm that returns the node at the beginning of the loop.
    Definition:
    Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node,
    so as to make a loop in the linked list,
    EXAMPLE:
    Input: A -> B -> C -> D -> E -> C(the same C as earlier
    Output: C

 */


import java.util.HashMap;
import java.util.Map;

//if there is no restriction in space....
public class LoopDetection {
    // the same here, we take advantage of default implementation of hashcode, it is based o memory location
    public static LinkedListNode getCorruptedNode(LinkedListNode list){
        Map<Integer, LinkedListNode> nodes = new HashMap<>();

        while(list!= null){
            if(nodes.get(list.hashCode()) != null){
                return list;
            }
            nodes.put(list.hashCode(), list);
            list = list.next;
        }
        return null;
    }

}
