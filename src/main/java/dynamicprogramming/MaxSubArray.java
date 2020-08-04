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

    public static void maxSubArrayPrintIndex(int[] nums) {
        int len = nums.length;

        if (len == 0) {
            return ;
        }

        int[] dp = new int[len];
        dp[0] = nums[0];

        int[] trace = new int[len];
        trace[0] = 1;

        int max = nums[0];
        int maxSubArrayStart = -1, maxSubArrayEnd = -1;
        for (int i = 1; i < len; i++) {
            if (dp[i-1] > 0) {
                dp[i] = dp[i-1] + nums[i];
                trace[i-1] = 1;
            } else {
                dp[i] = nums[i];
                trace[i-1] = 0;
            }
            if (dp[i] > max) {
                max = dp[i];
                maxSubArrayEnd = i;
            }
        }

        for (int i = maxSubArrayEnd; i >= 0; i--) {
            if (trace[i-1] != 1) {
                maxSubArrayStart = i;
                break;
            }
        }

        System.out.printf("%d, %d", maxSubArrayStart, maxSubArrayEnd);
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));

        maxSubArrayPrintIndex(new int[] {-2,1,-3,4,-1,2,1,-5,4});
    }
}
