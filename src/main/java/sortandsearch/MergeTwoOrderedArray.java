package sortandsearch;

/**
 * problem link: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/8/sorting-and-searching/52/
 */
public class MergeTwoOrderedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m+n];

        int i = 0, j = 0;
        for (int k = 0; k < m+n; k++) {
            if (i >= m) {
                tmp[k] = nums2[j++];
            } else if (j >= n) {
                tmp[k] = nums1[i++];
            } else if (nums1[i] <= nums2[j]) {
                tmp[k] = nums1[i++];
            } else {
                tmp[k] = nums2[j++];
            }
        }

        for (int k = 0; k < m+n; k++) {
            nums1[k] = tmp[k];
        }
    }
}
