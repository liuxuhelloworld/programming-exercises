package dynamicprogramming;

/**
 * problem link: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/55/
 */
public class StockMaxProfit {
    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }

        return max;
    }

    /* out of memory error
    public static int maxProfitV2(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        int[][] profit = new int[n+1][n+1];
        for (int gap = 1; gap < n; gap++) {
            for (int i = 1; i <= n-gap; i++) {
                profit[i][i+gap] = maxOfThree(profit[i][i+gap-1], profit[i+1][i+gap], prices[i+gap-1]-prices[i-1]);
            }
        }

        return profit[1][n];
    }

    private static int maxOfThree(int x, int y, int z) {
        if (x > y) {
            if (x > z) {
                return x;
            } else {
                return z;
            }
        } else {
            if (y > z) {
                return y;
            } else {
                return z;
            }
        }
    }
     */

    public static int maxProfitV3(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(prices[i] - minPrice, maxProfit);
            }
        }

        return maxProfit;
     }

    public static void main(String[] args) {
        System.out.println(maxProfitV3(new int[] {}));
        System.out.println(maxProfitV3(new int[] {7, 1, 5, 3, 4, 6}));
        System.out.println(maxProfitV3(new int[] {7, 6, 4, 3, 1}));
    }
}
