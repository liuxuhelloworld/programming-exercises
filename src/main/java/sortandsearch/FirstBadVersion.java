package sortandsearch;

/**
 * problem link: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/8/sorting-and-searching/53/
 */
public class FirstBadVersion {
    public static int firstBadVersion(int n) {
        int low = 1, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        if (isBadVersion(high)) {
            return high;
        } else {
            return -1;
        }
    }

    private static boolean isBadVersion(int n) {
        if (n >= 1702766719) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        firstBadVersion(2126753390);
    }
}
