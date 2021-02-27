import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimalTreeTest {

    private Integer[] testArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    private Integer[] smallTestArray = new Integer[]{1, 2, 3};

    private Integer[] oneNodeArray = new Integer[]{1};



    public <T> long getTheoreticalMinimalHeight(T[] testArray) {
        return (long) Math.floor(Math.log(testArray.length) / Math.log(2));
    }

    @Test
    void getMinimalHeightBinaryTree() {
        BinaryTree<Integer> tree = MinimalTree.getMinimalHeightBinaryTree(testArray);
        assertEquals(tree.getHeight(), getTheoreticalMinimalHeight(testArray));
    }


    @Test
    void heightOfMinimalBinaryTreeIsEqualsToTheoreticalMinimal() {
        BinaryTree<Integer> tree = MinimalTree.getMinimalHeightBinaryTree(smallTestArray);
        assertEquals(tree.getHeight(), getTheoreticalMinimalHeight(smallTestArray));
    }

    @Test
    void heightOfMinimalBinaryTreeIsEqualsToZeroInCaseArrayLengthIsOne() {
        BinaryTree<Integer> tree = MinimalTree.getMinimalHeightBinaryTree(oneNodeArray);
        assertEquals(0, getTheoreticalMinimalHeight(oneNodeArray));
        assertEquals(tree.getHeight(), getTheoreticalMinimalHeight(oneNodeArray));

    }
}