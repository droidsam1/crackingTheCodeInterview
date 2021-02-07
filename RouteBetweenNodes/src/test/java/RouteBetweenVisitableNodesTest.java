import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class RouteBetweenVisitableNodesTest {


    private NodeVisitable nodeOne = new NodeVisitable(1, new ArrayList<>());
    private NodeVisitable nodeTwo = new NodeVisitable(2, new ArrayList<>());
    private NodeVisitable nodeThree = new NodeVisitable(3, new ArrayList<>());
    private NodeVisitable nodeFour = new NodeVisitable(4, new ArrayList<>());
    private NodeVisitable nodeFive = new NodeVisitable(5, new ArrayList<>());
    private NodeVisitable nodeSix = new NodeVisitable(6, new ArrayList<>());
    private NodeVisitable lastNode = new NodeVisitable(7, new ArrayList<>());
    private NodeVisitable isolatedNode = new NodeVisitable(8, new ArrayList<>());


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
        Assertions.assertTrue(RouteBetweenVisitableNodes.exists(nodeOne, nodeTwo));
    }

    @Test
    void should_return_false_if_nodes_are_not_connected() {
        Assertions.assertFalse(RouteBetweenVisitableNodes.exists(lastNode, nodeOne));
    }

    @Test
    void should_return_false_if_nodes_of_the_nodes_is_isolated() {
        Assertions.assertFalse(RouteBetweenVisitableNodes.exists(nodeOne, isolatedNode));
    }

    @Test
    void should_return_true_if_nodes_are_connected() {
        Assertions.assertTrue(RouteBetweenVisitableNodes.exists(nodeOne, lastNode));
    }

    @Test
    void should_return_true_if_nodes_are_connected_throw_long_path() {
        Assertions.assertTrue(RouteBetweenVisitableNodes.exists(nodeThree, nodeTwo));
    }
}