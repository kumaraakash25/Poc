package tree;

public class TreeTraversal {
    public static void main(String[] args) {
        Tree tree = new Tree(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(2);
        inOrderTraversal(tree);
    }

    /**
     *     10
     *   5    15
     * 2
     *
     *
     *
     * @param tree
     */

    private static void inOrderTraversal(Tree tree) {
        if(tree.left != null) {
            inOrderTraversal(tree.left);
        }
        System.out.println(tree.value);
        if(tree.right != null) {
            inOrderTraversal(tree.right);
        }
    }
}
