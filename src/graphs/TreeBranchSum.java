package graphs;

import java.util.*;

public class TreeBranchSum {
    // This is the class of the input root. Do not edit it.

    public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();
        findSum(0, root, result);

        return result;
    }

    private static void findSum(int sum, BinaryTree node, List<Integer> result) {
        if (node == null) return;
        sum = sum + node.value;
        if (node.left == null && node.right == null) {
            result.add(sum);
        }
        findSum(sum, node.left, result);
        findSum(sum, node.right, result);
    }

    public static void main(String[] args) {
        BinaryTree b = new BinaryTree(1);
        BinaryTree b1 = new BinaryTree(2);
        BinaryTree b2 = new BinaryTree(3);
        BinaryTree b3 = new BinaryTree(4);
        BinaryTree b4 = new BinaryTree(5);
        BinaryTree b5 = new BinaryTree(6);

        b.left = b1;
        b.right = b2;
        b1.left = b3;
        b1.right = b4;

        /**
         *                      1
         *                  2       3
         *               4     5
         *
         */
        branchSums(b);
    }

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

}
