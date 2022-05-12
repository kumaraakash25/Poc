package tree;

public class NodeDepth {
    public static void main(String[] args) {
        Tree tree = new Tree(10);
        tree.insert(2);
        tree.insert(12);
        tree.insert(1);
        tree.insert(5);
        tree.insert(4);
        tree.insert(12);
        tree.insert(15);

        /**
         *                  10
         *              2        12
         *          1       5        15
         *              4
         */

        int depth = countLevel(tree, 0);
        System.out.println(depth);
    }

    private static int countLevel(Tree tree, int depth) {
        if (tree == null) return 0;
        return depth + countLevel(tree.left, depth + 1) + countLevel(tree.right, depth + 1);
    }
}
