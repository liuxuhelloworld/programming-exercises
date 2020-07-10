package array;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return ;
        }

        k = k % len;
        if (k == 0) {
            return ;
        }

        for (int i = 0; i < k; i++) {
            rotateOneElement(nums);
        }
    }

    private static void rotateOneElement(int[] nums) {
        if (nums.length == 0
            || nums.length == 1) {
            return ;
        }

        int last = nums[nums.length-1];
        for (int i = nums.length-2; i >= 0; i--) {
            nums[i+1] = nums[i];
        }

        nums[0] = last;
    }

    public static void rotateV2(int[] nums, int k) {
        int len = nums.length;

        if (len == 0) {
            return ;
        }

        k = k % len;
        if (k == 0) {
            return ;
        }

        reverse(nums, 0, len-k-1);
        reverse(nums, len-k, len-1);
        reverse(nums, 0, len-1);
    }

    private static void reverse(int[] nums, int left, int right) {
        for (int i = left, j = right; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void rotateV3(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return ;
        }

        k = k % len;
        if (k == 0) {
            return ;
        }

        int startIndex = 0;
        int moved = 0;
        while (moved < len) {
            int currentIndex = startIndex;
            int prevVal = nums[startIndex];

            do {
                int nextIndex = (currentIndex + k) % len;

                int tmpVal = nums[nextIndex];
                nums[nextIndex] = prevVal;
                prevVal = tmpVal;
                moved++;

                currentIndex = nextIndex;
            } while (currentIndex != startIndex);

            startIndex++;
        }
    }

    public static void main(String[] args) {
        rotateV3(new int[] {1, 2, 3, 4, 5, 6}, 3);
    }
}
