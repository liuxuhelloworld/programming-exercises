package dynamicprogramming;

public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int len = nums.length;

        if (len == 0) {
            return 0;
        }

        int[] dp = new int[len];
        dp[0] = nums[0];

        int max = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}
