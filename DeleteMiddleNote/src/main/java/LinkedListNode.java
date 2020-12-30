import java.util.Objects;

public class LinkedListNode<T> {
        public LinkedListNode next;
        public T data;


        public LinkedListNode(T d) {
            data = d;
        }

        public void setNext(LinkedListNode node) {
            next = node;
        }

        public void appendToTail(LinkedListNode node){
            LinkedListNode last = this;
            while(last.next!=null){
                last = last.next;
            }
            last.next = node;
        }

}
