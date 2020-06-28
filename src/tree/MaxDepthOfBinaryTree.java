package tree;

/**
 * problem link: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/47/
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    void setLeft(TreeNode left) {
        this.left = left;
    }

    void setRight(TreeNode right) {
        this.right = right;
    }
}
public class MaxDepthOfBinaryTree {
    public static int maxDepth(TreeNode root) {
        return maxDepthUsingRecursion(root);
    }

    private static int maxDepthUsingRecursion(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(maxDepthUsingRecursion(node.left), maxDepthUsingRecursion(node.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        root.setLeft(node1);
        root.setRight(node2);
        node2.setLeft(node3);
        node2.setRight(node4);

        System.out.println(maxDepth(root));
    }
}
