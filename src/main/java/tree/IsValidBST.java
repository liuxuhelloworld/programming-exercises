package tree;

import java.util.Stack;

/**
 * problem link: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/48/
 */
public class IsValidBST {
    private static TreeNode last = null;

    public static boolean isValidBST(TreeNode root) {
        //last = null;
        //return isValidBSTUsingRecursion(root);
        //return isValidBSTUsingRecursionV2(root, null, null);
        return isValidBSTWithoutRecursion(root);
    }

    private static boolean isValidBSTUsingRecursion(TreeNode node) {
        if (node == null) {
            return true;
        }

        if (node.left != null) {
            if (!isValidBSTUsingRecursion(node.left)) {
                return false;
            }
        }

        if (last != null
            && node.val <= last.val) {
            return false;
        }

        last = node;
        if (node.right != null) {
            if (!isValidBSTUsingRecursion(node.right)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isValidBSTUsingRecursionV2(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        if (!isValidBSTUsingRecursionV2(node.left, lower, node.val)) {
            return false;
        }
        if (!isValidBSTUsingRecursionV2(node.right, node.val, upper)) {
            return false;
        }

        return true;
    }

    private static boolean isValidBSTWithoutRecursion(TreeNode node) {
        if (node == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        long last = Long.MIN_VALUE;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur.val <= last) {
                return false;
            }
            last = cur.val;
            cur = cur.right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(36);
        TreeNode node1 = new TreeNode(-6);
        TreeNode node2 = new TreeNode(-21);

        root.setLeft(node1);
        node1.setLeft(node2);

        System.out.println(isValidBST(root));
    }
}
