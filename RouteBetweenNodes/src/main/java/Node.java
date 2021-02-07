import java.util.Collection;

public class Node<T>{

    private T value;
    private Collection<Node<T>> adjacents;

    public Node(T value, Collection<Node<T>> adjacents) {
        this.value = value;
        this.adjacents = adjacents;
    }

    public T getValue() {
        return value;
    }

    public Collection<Node<T>> getAdjacents() {
        return adjacents;
    }
}
