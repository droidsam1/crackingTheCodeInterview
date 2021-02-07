import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class RouteBetweenImmutableNodesTest {


    private Node nodeOne = new Node(1, new ArrayList<>());
    private Node nodeTwo = new Node(2, new ArrayList<>());
    private Node nodeThree = new Node(3, new ArrayList<>());
    private Node nodeFour = new Node(4, new ArrayList<>());
    private Node nodeFive = new Node(5, new ArrayList<>());
    private Node nodeSix = new Node(6, new ArrayList<>());
    private Node lastNode = new Node(7, new ArrayList<>());
    private Node isolatedNode = new Node(8, new ArrayList<>());


    @BeforeEach
    private void buildTestDirectionalGraph() {
        nodeOne.getAdjacents().addAll(Arrays.asList(nodeTwo, nodeThree));
        nodeTwo.getAdjacents().addAll(Arrays.asList(nodeFour));
        nodeThree.getAdjacents().addAll(Arrays.asList(nodeFour));
        nodeFour.getAdjacents().addAll(Arrays.asList(nodeFive));
        nodeFive.getAdjacents().addAll(Arrays.asList(nodeThree, nodeSix));
        nodeSix.getAdjacents().addAll(Arrays.asList(nodeOne, lastNode));
    }

    @Test
    void should_return_true_if_nodes_are_neighbours() {
        Assertions.assertTrue(RouteBetweenImmutableNodes.exists(nodeOne, nodeTwo));
    }

    @Test
    void should_return_true_if_nodes_are_connected_in_chained_searches() {
        Assertions.assertTrue(RouteBetweenImmutableNodes.exists(nodeTwo, nodeOne));
        Assertions.assertTrue(RouteBetweenImmutableNodes.exists(nodeSix, nodeFive));
    }

    @Test
    void should_return_false_if_nodes_are_not_connected() {
        Assertions.assertFalse(RouteBetweenImmutableNodes.exists(lastNode, nodeOne));
    }

    @Test
    void should_return_false_if_nodes_of_the_nodes_is_isolated() {
        Assertions.assertFalse(RouteBetweenImmutableNodes.exists(nodeOne, isolatedNode));
    }

    @Test
    void should_return_true_if_nodes_are_connected() {
        Assertions.assertTrue(RouteBetweenImmutableNodes.exists(nodeOne, lastNode));
    }

    @Test
    void should_return_true_if_nodes_are_connected_throw_long_path() {
        Assertions.assertTrue(RouteBetweenImmutableNodes.exists(nodeThree, nodeTwo));
    }
}