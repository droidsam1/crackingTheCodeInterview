/*
   Implement an algorithm to delete a node in the middle(i.e. any node but the first and last node, not necessarily
   the exact middle) of a singly linked list, given only access to that node

   example:
   input: the node c from the linked list a->b->c->d->e->f
   output: nothing is returned, but the new linked list looks like a->b->d->e->f

 */
public class DeleteMiddleNode {
    public static void delete(LinkedListNode middleNode) {
        LinkedListNode nextNode = middleNode.next;
        if (nextNode != null) {
            middleNode.data = nextNode.data;
            middleNode.next = nextNode.next;
        }
    }
}
