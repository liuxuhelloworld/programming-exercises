package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TraverseOfBinaryTree {
    public void visit(TreeNode node) {
        System.out.println(node);
    }

    public void preOrderTraverse(TreeNode node) {
        if (node == null) {
            return ;
        }

        visit(node);
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    public void preOrderTraverseWithoutRecursion(TreeNode node) {
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

    public void inOrderTraverse(TreeNode node) {
        if (node == null) {
            return ;
        }

        inOrderTraverse(node.left);
        visit(node);
        inOrderTraverse(node.right);
    }

    public void inOrderTraverseWithoutRecursion(TreeNode node) {
        if (node == null) {
            return ;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            while (cur.left != null) {
                cur = cur.left;
                stack.push(cur);
            }
            cur = stack.pop();
            visit(cur);
            if (cur.right != null) {
                cur = cur.right;
                stack.push(cur);
            }
        }
    }

    public void postOrderTraverse(TreeNode node) {
        if (node == null) {
            return ;
        }

        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        visit(node);
    }

    public void postOrderTraverseWithoutRecursion(TreeNode node) {
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

    public void bfsTraverse(TreeNode node) {
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
}
