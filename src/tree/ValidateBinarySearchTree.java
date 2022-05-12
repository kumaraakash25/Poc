package tree;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        Tree tree = new Tree(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(2);
        tree.insert(5);
        tree.insert(13);
        tree.insert(22);
        tree.insert(1);
        tree.insert(29);

        boolean result = validateBinaryTree(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(result);
    }

    private static boolean validateBinaryTree(Tree tree, int minValue, int maxValue) {
        if (tree.value < minValue || tree.value > maxValue) return false;
        if (tree.left != null && !validateBinaryTree(tree.left, minValue, tree.value)) return false;
        if (tree.right != null && !validateBinaryTree(tree.right, tree.value, maxValue)) return false;
        return true;
    }
}
