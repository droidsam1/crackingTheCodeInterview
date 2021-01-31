import java.util.Stack;

/*
    Write a program to sort a stack such that the smallest items are on the top. You can use an additional temporary
    stack, but you may not copy the elements into any other data structure(such as an array).
    The stack supports the following operations: push , pop, peek, and isEmpty.

 */

// With this implementation we have to choose what we want to keep in constant time, or writings or readings.
// I have choose to keep writings in constant time, and sort the stack on demand (peek or pop)
// PS: I have misunderstood this exercise as the only task asked was the method sort, not the entire implementation of
// a stack
public class SortStack<T extends Comparable<T>> {

    private Stack<T> entryStack;
    private Stack<T> outPutStack;


    public SortStack() {
        entryStack = new Stack<>();
        outPutStack = new Stack<>();
    }


    public T push(T item) {
        return entryStack.push(item);
    }


    public synchronized T pop() {
        sort();
        return outPutStack.pop();
    }


    public synchronized T peek() {
        sort();
        return outPutStack.peek();
    }


    public boolean isEmpty() {
        return entryStack.isEmpty() && outPutStack.isEmpty();
    }

    private void sort() {
        while (!entryStack.isEmpty()) {
            T element = entryStack.pop();
            if (outPutStack.isEmpty() || element.compareTo(outPutStack.peek()) < 0) {
                outPutStack.push(element);
            } else {
                boolean elementPushed = false;
                while (!outPutStack.isEmpty()) {
                    T outPutElement = outPutStack.peek();
                    if (!elementPushed && element.compareTo(outPutElement) > -1) {
                        entryStack.push(outPutStack.pop());
                    } else {
                        entryStack.push(element);
                        elementPushed = true;
                    }
                }
                if(!elementPushed){
                    entryStack.push(element);
                }
            }
        }
    }
}
