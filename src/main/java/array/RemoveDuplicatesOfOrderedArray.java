package array;

/**
 * problem link: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/
 */
public class RemoveDuplicatesOfOrderedArray {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int j = 0;
        int target = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current == target) {
                continue;
            } else {
                nums[++j] = current;
                target = current;
            }
        }

        return j+1;
    }

    public static void main(String[] args) {
        int size;
        int[] nums;

        nums = new int[0];
        size = removeDuplicates(nums);

        nums = new int[] {0};
        size = removeDuplicates(nums);

        nums = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        size = removeDuplicates(nums);
    }
}
