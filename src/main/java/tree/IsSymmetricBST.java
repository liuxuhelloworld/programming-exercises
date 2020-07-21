package tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetricBST {
    public static boolean isSymmetric(TreeNode root) {
        //return isSymmetricUsingRecur(root, root);
        return isSymmetricWithoutRecur(root);
    }

    private static boolean isSymmetricUsingRecur(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val
            && isSymmetricUsingRecur(p.left, q.right)
            && isSymmetricUsingRecur(p.right, q.left);
    }

    private static boolean isSymmetricWithoutRecur(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return true;
        }

        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            if (p == null && q == null) {
                continue;
            }

            if (p == null || q == null || p.val != q.val) {
                return false;
            }

            queue.offer(p.left);
            queue.offer(q.right);

            if (p != q) {
                queue.offer(p.right);
                queue.offer(q.left);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
    }
}
