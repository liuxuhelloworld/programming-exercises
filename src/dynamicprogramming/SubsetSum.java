package dynamicprogramming;

import java.util.ArrayList;
import java.util.Scanner;

public class SubsetSum {
    public static boolean existsUseRecur(int[] arr, int target) {
        return existsUseRecur(arr, 0, arr.length-1, target);
    }

    private static boolean existsUseRecur(int[] arr, int i, int j, int target) {
        int len = j-i+1;

        if (target == 0) {
            return true;
        }

        if (len == 0 && target > 0) {
            return false;
        }

        if (arr[i] > target) {
            return existsUseRecur(arr, i+1, j, target);
        }

        return existsUseRecur(arr, i+1, j, target-arr[i])
                || existsUseRecur(arr, i+1, j, target);
    }

    public static boolean existsUseDp(int[] arr, int target) {
        int len = arr.length;

        int m = len + 1;
        int n = target + 1;
        boolean[][] dp = new boolean[m][n];

        for (int j = 1; j < n; j++) {
            dp[0][j] = false;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }

        return dp[len][target];
    }

    public static void main(String[] args) {
        while (true) {
            ArrayList<Integer> arrList = new ArrayList<>();

            System.out.println("Please input the integer array (0 for end):");
            Scanner input = new Scanner(System.in);
            while (input.hasNextInt()) {
                int v = input.nextInt();
                if (v == 0) {
                    break;
                }
                arrList.add(v);
            }

            System.out.println("Please input the target sum:");
            int target = input.nextInt();

            System.out.println("exists: " +
                existsUseRecur(arrList.stream().mapToInt(Integer::intValue).toArray(), target));

            System.out.println("exists: " +
                existsUseDp(arrList.stream().mapToInt(Integer::intValue).toArray(), target));
        }
    }
}
