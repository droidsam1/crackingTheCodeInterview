import java.util.Queue;

public class BinaryTree<T> {
    private final BinaryTreeNode root;


    public BinaryTree(final BinaryTreeNode<T> root) {
        this.root = root;
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }


    public long getHeight(){
        return getHeight(root);
    }

    private long getHeight(BinaryTreeNode<T> node){
        if(node == null){
            return -1;
        }
        return 1+ Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    }


}
