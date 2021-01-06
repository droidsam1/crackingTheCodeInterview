/*
    Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes
    greater than or equal to x. If x is contained within the list, the value of x only need to be after the element
    less than x. The partition element x can appear anywhere in the "right partition"; it does not need to appear
     between the left and right partitions
     EXAMPLE
     Input: 3-> 5-> 8 -> 5 -> 10 -> 2 -> 1 [partition =5]
     Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8


          Input: 3-> 5-> 8 -> 4 -> 10 -> 2 -> 1 [partition =4]

 */

public class Partition {

    public static <T extends Integer> LinkedListNode partition(LinkedListNode head, Integer element) {


        LinkedListNode<Integer> node = head;
        LinkedListNode<Integer> middleNode =null;

        while (middleNode == null && !node.data.equals(element)) {
            node = node.next;
        }

        if(!node.data.equals(element)){
            return head;
        }


        middleNode = node;
        node = head;

        LinkedListNode<Integer> headOfLeftSide = null;
        LinkedListNode<Integer> tailOfLeftSide = null;

        LinkedListNode<Integer> headOfRightSide = null;
        LinkedListNode<Integer> tailOfRightSide = null;

        while(node !=null){
            if(node == middleNode){
                node = node.next;
                continue;
            }

            if(node.data< middleNode.data){
                if(tailOfLeftSide == null){
                    tailOfLeftSide = node;
                    headOfLeftSide = node;
                }else{
                    tailOfLeftSide.next = node;
                    tailOfLeftSide = tailOfLeftSide.next;
                }
            }else{
                if(tailOfRightSide == null){
                    tailOfRightSide = node;
                    headOfRightSide = node;
                }else{
                    tailOfRightSide.next = node;
                    tailOfRightSide = tailOfRightSide.next;

                }
            }
            node = node.next;
        }

        if(tailOfRightSide == null){
            tailOfRightSide = middleNode;
        }

        tailOfRightSide.next = null;

        if(tailOfLeftSide == null){
            tailOfLeftSide = middleNode;
        }else{
            tailOfLeftSide.next = middleNode;
        }
        middleNode.next = headOfRightSide;

        return headOfLeftSide;
    }
}
