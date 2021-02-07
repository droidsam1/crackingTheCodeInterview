import java.util.Collection;

public class NodeVisitable<T>{
    private T value;
    private Collection<NodeVisitable<T>> adjacents;

    public NodeVisitable(T value, Collection<NodeVisitable<T>> adjacents) {
        this.value = value;
        this.adjacents = adjacents;
    }

    public T getValue() {
        return value;
    }

    public Collection<NodeVisitable<T>> getAdjacents() {
        return adjacents;
    }


    private boolean visited;

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
