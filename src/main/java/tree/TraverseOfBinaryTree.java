package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TraverseOfBinaryTree {
    public static void visit(TreeNode node) {
        System.out.println(node.val);
    }

    public static void preOrderTraverse(TreeNode node) {
        if (node == null) {
            return ;
        }

        visit(node);
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    public static void preOrderTraverseWithoutRecursion(TreeNode node) {
        if (node == null) {
            return ;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            visit(cur);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public static void inOrderTraverse(TreeNode node) {
        if (node == null) {
            return ;
        }

        inOrderTraverse(node.left);
        visit(node);
        inOrderTraverse(node.right);
    }

    public static void inOrderTraverseWithoutRecursion(TreeNode node) {
        if (node == null) {
            return ;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            visit(cur);
            cur = cur.right;
        }
    }

    public static void postOrderTraverse(TreeNode node) {
        if (node == null) {
            return ;
        }

        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        visit(node);
    }

    public static void postOrderTraverseWithoutRecursion(TreeNode node) {
        if (node == null) {
            return ;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        TreeNode last = node;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();

            boolean hasChild = (cur.left != null || cur.right != null);
            boolean hasVisitedAllChild = (last == cur.right
                || (last == cur.left && cur.right == null));

            if (!hasChild || hasVisitedAllChild) {
                cur = stack.pop();
                visit(cur);
                last = cur;
            } else {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
    }

    public static void bfsTraverse(TreeNode node) {
        if (node == null) {
            return ;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                visit(cur);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(6);

        root.setLeft(node1);
        root.setRight(node2);
        node2.setLeft(node3);
        node2.setRight(node4);

        preOrderTraverse(root);
        preOrderTraverseWithoutRecursion(root);
        inOrderTraverse(root);
        inOrderTraverseWithoutRecursion(root);
        postOrderTraverse(root);
        postOrderTraverseWithoutRecursion(root);
        bfsTraverse(root);

    }
}
