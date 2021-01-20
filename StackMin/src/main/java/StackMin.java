import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Stack;

/*
    How would you design a stack which, in addition to push and pop, has a function min which returns the
     minimum element? Push, pop and min should all operate in O(1) time.
 */
public class StackMin extends Stack<Integer> {

    private final LinkedList<Integer> mins;

    public StackMin() {
        super();
        this.mins = new LinkedList<Integer>();
    }

    @Override
    public Integer push(Integer item) {
        if (mins.isEmpty() || item < mins.peek()) {
            mins.push(item);
        }
        return super.push(item);
    }

    @Override
    public synchronized Integer pop() {
        Integer element = super.pop();
        if (!mins.isEmpty() && element.equals(min())) {
            mins.pop();
        }
        return element;
    }

    public Integer min() {
        if (this.mins.isEmpty()) {
            throw new java.util.EmptyStackException();
        } else {
            return mins.peek();
        }
    }
}
