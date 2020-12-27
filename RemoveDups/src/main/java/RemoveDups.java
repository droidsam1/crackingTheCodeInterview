/*
Write code to remove duplicates from an unsorted linked list.

FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class RemoveDups {

    /*
        In the book, they operate with their own version of LinkedList, the linkedListNode. The solutions for that case
        would consists in a hashtable for the first case, and with the runner technique for the second case. With the
        above pointer searching for duplicates and removing them in-place.
     */
    public static<T> LinkedList remove(LinkedList<T> linkedList){
       return new LinkedList<T>( new HashSet<>(linkedList));
    }
}
