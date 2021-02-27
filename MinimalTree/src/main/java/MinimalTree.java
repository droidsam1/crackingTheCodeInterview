/*
    Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write and algorithm to create
    a binary search tree with minimal height.
 */

public class MinimalTree {

    public static <T> BinaryTree<T> getMinimalHeightBinaryTree(T[] sortedArray) {
        return new BinaryTree<>(getLocalRootNode(0, sortedArray.length, sortedArray));
    }

    private static <T> BinaryTreeNode<T> getLocalRootNode(int from, int to, T[] sortedArray) {
        if (to == from || from > to) {
            return null;
        }
        int middle = (from + to) / 2;
        BinaryTreeNode localRootNode = new BinaryTreeNode(sortedArray[middle]);
        localRootNode.setLeft(getLocalRootNode(from, middle, sortedArray));
        localRootNode.setRight(getLocalRootNode(middle + 1, to, sortedArray));
        return localRootNode;
    }

}
