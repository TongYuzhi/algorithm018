import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        int[] count = new int[26];

        for (int i = 0; i < pLen; i++) {
            count[p.charAt(i) - 'a']++;
        }

        List<Integer> res = new ArrayList<>();

        int[] window = new int[26];
        int left = 0;
        int right = 0;

        while (right < sLen) {
            int curRight = s.charAt(right++) - 'a';
            window[curRight]++;

            while (window[curRight] > count[curRight]) {
                int curLeft = s.charAt(left++) - 'a';
                window[curLeft]--;
            }
            if (right - left == pLen) {
                res.add(left);
            }
        }
        return res;
    }
}
// @lc code=end

/**
 * 
 * public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        int sLen = s.length();

        int[] count = new int[26];

        for (int i = 0; i < pLen; i++) {
            count[p.charAt(i) - 'a']++;
        }

        List<Integer> res = new ArrayList<>();

        int[] window = new int[26];
        int left = 0;  //指向窗口最左边的字母
        int right = 0; //指向下一个要加进窗口的字母

        while (right < sLen) {
            int curRight = s.charAt(right++) - 'a';
            window[curRight]++;

            // 新加进来的字母不符合要求，所以通过移出窗口左端的元素
            // 来使得这个窗口报废掉
            while (window[curRight] > count[curRight]) {
                int curLeft = s.charAt(left++) - 'a';
                window[curLeft]--;
            }

            if (right - left == pLen) {
                res.add(left);
            }
        }
        return res;
    }
 */

/**
 *  slow but works, fake windows
 * 
 * public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        int sLen = s.length();

        int[] count = new int[26];

        for (int i = 0; i < pLen; i++) {
            count[p.charAt(i) - 'a']++;
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= sLen - pLen; i++) {
            int[] tempCount = Arrays.copyOf(count, count.length);
            int j = i;

            for (; j < sLen && j < pLen + i; j++) {
                if (--tempCount[s.charAt(j) - 'a'] < 0) {
                    break;
                }
            }
            if (j >= pLen + i) {
                res.add(i);
            }
        }
        return res;
    }
 */

/**
 *  my first solution, TLE... 
 * 
 * public List<Integer> findAnagrams(String s, String p) {
        char[] pa = p.toCharArray();
        Arrays.sort(pa);
        String ori = new String(pa);

        int len = p.length();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= s.length() - len; i++) {
            char[] arr = s.substring(i, i + len).toCharArray();
            Arrays.sort(arr);
            String target = new String(arr);

            if (target.equals(ori)) {
                res.add(i);
            }
        }
        return res;
    }
 */
