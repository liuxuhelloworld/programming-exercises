package tree;

public class SortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTUsingRecursion(nums, 0, nums.length-1);
    }

    private static TreeNode sortedArrayToBSTUsingRecursion(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end-start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTUsingRecursion(nums, start, mid-1);
        root.right = sortedArrayToBSTUsingRecursion(nums, mid+1, end);
        return root;
    }

    //public static TreeNode sortedArrayToBST(int[] nums) {
    //    if (nums.length == 0) {
    //        return null;
    //    }
    //
    //    TreeNode root = null;
    //    for (int num : nums) {
    //        root = addOneNode(root, num);
    //    }
    //
    //    return root;
    //}
    //
    //private static TreeNode addOneNode(TreeNode root, int val) {
    //    if (root == null) {
    //        return new TreeNode(val);
    //    }
    //
    //    if (val >= root.val) {
    //        root.right = addOneNode(root.right, val);
    //    } else if (val < root.val) {
    //        root.left = addOneNode(root.left, val);
    //    }
    //    return fixBalance(root);
    //}
    //
    //private static TreeNode fixBalance(TreeNode root) {
    //    if (root == null) {
    //        return null;
    //    }
    //
    //    int leftHeight = height(root.left);
    //    int rightHeight = height(root.right);
    //    if (Math.abs(leftHeight - rightHeight) <= 1) {
    //        return root;
    //    } else {
    //        if (leftHeight < rightHeight) {
    //            return leftRotate(root);
    //        } else {
    //            return rightRotate(root);
    //        }
    //    }
    //}
    //
    //private static int height(TreeNode root) {
    //    if (root == null) {
    //        return 0;
    //    }
    //
    //    return Math.max(height(root.left), height(root.right)) + 1;
    //}
    //
    //private static TreeNode leftRotate(TreeNode root) {
    //    TreeNode newRoot;
    //    if (root.right.left == null) {
    //        newRoot = root.right;
    //        newRoot.left = root;
    //        root.right = null;
    //    } else {
    //        newRoot = root.right.left;
    //        newRoot.right = root.right;
    //        root.right.left = null;
    //        newRoot.left = root;
    //        root.right = null;
    //    }
    //    return newRoot;
    //}
    //
    //private static TreeNode rightRotate(TreeNode root) {
    //    TreeNode newRoot;
    //    if (root.left.right == null) {
    //        newRoot = root.left;
    //        newRoot.right = root;
    //        root.left = null;
    //    } else {
    //        newRoot = root.left.right;
    //        newRoot.left = root.left;
    //        root.left.right = null;
    //        newRoot.right = root;
    //        root.left = null;
    //    }
    //    return newRoot;
    //}

    public static void main(String[] args) {
        TreeNode node = sortedArrayToBST(new int[] {0, 1, 2, 3, 4, 5});
    }
}
