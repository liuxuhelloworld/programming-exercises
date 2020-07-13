package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstUniqChar {
    public static int firstUniqChar(String s) {
        Set<Character> hasProcessed = new HashSet<>(s.length());

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (!s.substring(i+1).contains(String.valueOf(c))
                && !hasProcessed.contains(c)) {
                return i;
            } else {
                hasProcessed.add(c);
                while (i < s.length() && s.charAt(i) == c) {
                    i++;
                }
            }
        }

        return -1;
    }

    public static int firstUniqCharV2(String s) {
        int[] cnt = new int[26];

        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static int firstUniqCharV3(String s) {
        Map<Character, Integer> cnt = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            cnt.put(s.charAt(i), cnt.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (cnt.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqCharV3("aadadaad"));
        System.out.println(firstUniqCharV3("aaa"));
        System.out.println(firstUniqCharV3("leetcode"));
        System.out.println(firstUniqCharV3("loveleetcode"));
    }

}
