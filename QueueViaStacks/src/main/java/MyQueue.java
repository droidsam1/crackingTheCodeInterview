/*
    Implement a MyQueue class which implements a queue using two stacks
 */

import java.util.EmptyStackException;
import java.util.Stack;

public class MyQueue<T> {
    private Stack<T> entryStack;
    private Stack<T> outStack;


    public MyQueue() {
        this.entryStack = new Stack<T>();
        this.outStack = new Stack<T>();
    }

    public boolean add(T element) {
        entryStack.push(element);
        return true;
    }

    public T poll() {
        prepareOutStack();
        throwExceptionIfOutStackIsEmpty();
        return outStack.pop();
    }

    public T peek() {
        prepareOutStack();
        throwExceptionIfOutStackIsEmpty();
        return outStack.peek();
    }

    private void throwExceptionIfOutStackIsEmpty(){
        if(outStack.isEmpty()){
            throw new EmptyQueueException();
        }
    }

    private void prepareOutStack() {
        if (outStack.isEmpty()) {
            dumpEntryStackIntoOutStack();
        }
    }

    private void dumpEntryStackIntoOutStack() {
        while (!entryStack.isEmpty()) {
            outStack.push(entryStack.pop());
        }
    }

}

class EmptyQueueException extends RuntimeException {

}