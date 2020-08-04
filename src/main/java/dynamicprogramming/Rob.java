package dynamicprogramming;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/57/
 */
public class Rob {
    public static int rob(int[] nums) {
        return robUsingRecursion(nums, 0, nums.length-1);
    }

    private static int robUsingRecursion(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }

        if (start == end) {
            return nums[start];
        }

        int robWithoutStart = robUsingRecursion(nums, start+1, end);
        int robWithStart = robUsingRecursion(nums, start+2, end) + nums[start];
        return Math.max(robWithoutStart, robWithStart);
    }

    //private static int robUsingDynamicProgramming(int[] nums) {
    //    if (nums.length == 0) {
    //        return 0;
    //    }
    //
    //    int[] dp = new int[nums]
    //}

    public static void main(String[] args) {
        System.out.println(rob(new int[] {1, 2, 3, 1}));
        System.out.println(rob(new int[] {2, 7, 9, 3, 1}));
    }
}
