package dynamicprogramming;

/**
 * problem link: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/54/
 */
public class ClimbStairs {
    public static int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }

        int[][] cnt = new int[n+1][n+1];

        for (int gap = 1; gap <= n; gap++) {
            for (int i = 0; i < n+1-gap; i++) {
                int j = i + gap;

                if (j - i == 1) {
                    cnt[i][j] = 1;
                } else if (j - i == 2) {
                    cnt[i][j] = 2;
                } else {
                    cnt[i][j] = cnt[i][j-2] + cnt[i][j-1];
                }
            }
        }

        return cnt[0][n];
    }

    public static int climbStairsUsingRollingArray(int n) {
        if (n <= 0) {
            return 0;
        }

        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }

        return r;
    }

    public static void main(String[] args) {
        System.out.println(climbStairsUsingRollingArray(1));
        System.out.println(climbStairsUsingRollingArray(2));
        System.out.println(climbStairsUsingRollingArray(3));
        System.out.println(climbStairsUsingRollingArray(4));
        //System.out.println(climbStairs(100)); overflow
    }
}
