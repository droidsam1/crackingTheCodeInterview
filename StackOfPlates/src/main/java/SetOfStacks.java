/*
    Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life, we would
    likely start a new stack when the previous stack exceeds some threshold. Implement a data structure SetStacks
     that mimics this. SetOfStacks should be composed of several stacks and should create a new stack once the previous
     one exceeds capacity. SetOfStacks.push() and SetOffStacks.pop() should behave identically to a single stack
     (that is, pop() should return the same values as it would if there were just a single stack).
     FOLLOW UP
     Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 */
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;


/*
    For the followUp question, I am allowing that empty spots throw several stacks to avoid reordering all stacks
    after a call to popAt. This should keep popAt running at constant time O(1), and having scattered empty spaces as a
    counterpart
 */
public class SetOfStacks<T> extends Stack<T>{

    private final int threshold;
    private int numberOfElements;
    private List<Stack<T>> stacks;


    public SetOfStacks(final int threshold) {
        super();
        this.stacks = new ArrayList();
        this.stacks.add(new Stack<>());
        this.threshold = threshold;
    }

    public T push(T item) {
        Stack<T> destinationStack = getCurrentStack();
        if (destinationStack == null) {
            destinationStack = new Stack();
            stacks.add(destinationStack);
        }
        destinationStack.push(item);
        numberOfElements++;
        return item;
    }

    public synchronized T pop() {
        validateNotEmptyStack();
        T item = getStackOfLastPushedItem().pop();
        numberOfElements--;
        return item;
    }

    public synchronized T peek() {
        validateNotEmptyStack();
        return getStackOfLastPushedItem().peek();
    }

    public boolean empty() {
        validateNotEmptyStack();
        return numberOfElements == 0;
    }

    @Override
    public synchronized int size() {
        return numberOfElements;
    }

    public T popAt(int index) {
        validateNotEmptyStack();
        if (index > stacks.size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        T item = stacks.get(index).pop();
        numberOfElements--;
        return item;
    }

    private Stack<T> getCurrentStack() {
        int currentIndex = numberOfElements / threshold;
        if(currentIndex < stacks.size()){
            return stacks.get(numberOfElements / threshold);
        }
        return null;
    }

    private Stack<T> getStackOfLastPushedItem() {
        return stacks.get((numberOfElements -1) / threshold);
    }

    private void validateNotEmptyStack() {
        if (numberOfElements == 0) {
            throw new EmptyStackException();
        }
    }
}