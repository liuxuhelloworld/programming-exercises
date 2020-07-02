package tree;

public class TreeNode {
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
