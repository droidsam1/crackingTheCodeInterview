/*
    3.1 Describe how you could use a single array to implement three stacks
 */
public class ThreeInOne {

    private final int stackSize;
    private final int numberOfStacks;
    private final Integer[] array;
    private final int[] numberOfElementsPerStack;


    public ThreeInOne(int stackSize) {
        this.stackSize = stackSize;
        this.numberOfStacks = 3;
        this.array = new Integer[stackSize * numberOfStacks];
        this.numberOfElementsPerStack = new int[numberOfStacks];
    }


    public void push(int element, int stackNum) throws StackNumberOutOfBoundsException, StackIsFullException {
        checkStackNumber(stackNum);
        if ( numberOfElementsPerStack[stackNum] == stackSize) {
            throw new StackIsFullException();
        }

        int topOfStackIndex = getTopOfStackIndex(stackNum);
        array[topOfStackIndex] = element;
        numberOfElementsPerStack[stackNum]++;
    }

    public int pop(int stackNum) throws StackNumberOutOfBoundsException, StackIsEmptyException {
        checkStackNumber(stackNum);
        if(isEmpty(stackNum)){
            throw new StackIsEmptyException();
        }
        int topOfStackIndex = getTopOfStackIndex(stackNum) + 1;
        Integer data =   array[topOfStackIndex];
        array[topOfStackIndex] = null;
        numberOfElementsPerStack[stackNum]--;
        return data;
    }

    public Integer peek(int stackNum) throws StackNumberOutOfBoundsException, StackIsEmptyException {
        checkStackNumber(stackNum);
        if(isEmpty(stackNum)){
            throw new StackIsEmptyException();
        }
        int topOfStackIndex = getTopOfStackIndex(stackNum) + 1;
        return array[topOfStackIndex];
    }

    public boolean isEmpty(int stackNum) throws StackNumberOutOfBoundsException {
        checkStackNumber(stackNum);
        return getTopOfStackIndex(stackNum) == stackNum * stackSize + stackSize -1 &&numberOfElementsPerStack[stackNum] ==0;
    }

    private int getTopOfStackIndex(int stackNum){
        return stackNum * stackSize + ((stackSize-1) - numberOfElementsPerStack[stackNum]);
    }

    private void checkStackNumber(int stackNum) throws StackNumberOutOfBoundsException {
        if (stackNum >= numberOfStacks || stackNum < 0) {
            throw new StackNumberOutOfBoundsException();
        }
    }


    public class StackNumberOutOfBoundsException extends Exception {
        //TODO
    }

    public class StackIsFullException extends Exception {
        //TODO
    }

    public class StackIsEmptyException extends Exception {
        //TODO
    }
}



