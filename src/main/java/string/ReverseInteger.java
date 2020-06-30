package string;

/**
 * problem link: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/33/
 */
public class ReverseInteger {
    public static int reverse(int x) {
        long reverse = 0;

        int sign = x >= 0 ? 1 : -1;
        while (x != 0) {
            int remain = Math.abs(x % 10);
            reverse = reverse * 10 + remain;
            x = x / 10;
        }
        reverse *= sign;

        if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)reverse;
    }

    public static int reverse2(int x) {
        int sign = x >= 0 ? 1 : -1;
        long abs = Math.abs((long)x);
        long reverse = Long.parseLong(new StringBuilder(String.valueOf(abs)).reverse().toString());
        reverse *= sign;

        if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
            return 0;
        }

        return (int)reverse;
    }

    public static void main(String[] args) {
        System.out.println(reverse2(1534236469));
        System.out.println(reverse2(0));
        System.out.println(reverse2(123));
        System.out.println(reverse2(-123));
        System.out.println(reverse2(120));
        System.out.println(reverse2(Integer.MAX_VALUE));
        System.out.println(reverse2(Integer.MIN_VALUE));
    }
}
