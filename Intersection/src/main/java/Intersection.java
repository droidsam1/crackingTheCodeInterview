/*
    Given two (singly) linked lists, determine if the two lists intersect.
     Return the intersection node. Note that the intersection is defined based on reference, not value. That is, if
     the kth node of the first linked list is the exact same node(by reference) as the jth node of the second
     linked list, then they are intersecting.
 */

import java.util.HashMap;
import java.util.Map;


/*
    Note: If we are not restricted by space, then we can use hash tables or maps to solve this problem. In this case I have
    used hashmap because hashcode default implementation provided by the JDK is based on memory location
 */
public class Intersection {

    public static LinkedListNode getIntersectNode(LinkedListNode inputList, LinkedListNode anotherInputList){
        if (inputList == null || anotherInputList == null){
            return null;
        }
        Map<Integer, LinkedListNode> elementsInInputList = new HashMap<>();

        while(inputList!=null){
            elementsInInputList.put(inputList.hashCode(), inputList);
            inputList = inputList.next;
        }

        while(anotherInputList!=null){
            if(elementsInInputList.get(anotherInputList.hashCode()) != null){
                return anotherInputList;
            }
            anotherInputList = anotherInputList.next;
        }
        return null;
    }
}
