package tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class InvertBinaryTree {

    public static void main(String[] args) {
        Tree tree = new Tree(10);                             //           10
        tree.insert(2);                                            //       2           12
        tree.insert(12);                                           //    1       5           15
        tree.insert(5);                                            //                             18
        tree.insert(1);                                            //
        tree.insert(15);                                           //
        tree.insert(18);

        invertTree(tree);
        System.out.println(tree);
    }


    private static void invertTree(Tree tree) {
        Queue<Tree> queue = new ArrayDeque<>();
        queue.add(tree);

        while (queue.size() > 0) {
            Tree currentNode = queue.remove();
            Tree leftNode = currentNode.left;
            currentNode.left = currentNode.right;
            currentNode.right = leftNode;

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }

        }
    }
}
