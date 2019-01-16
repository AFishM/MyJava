package leetcode.tencent.arrayandstring;

/**
 * 最长回文子串
 * Created by xuzixu on 2019/1/15.
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(longestPalindrome("babad"));
        long end = System.currentTimeMillis() - start;
        System.out.println(end);
    }

    /**
     * 自己1948ms的
     * @param s
     * @return
     */
    private static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int length = s.length();
        String result = null;
        int maxLength = 0;
        String temp;
        int tempLength;
        for (int i = 0; i < length - 1; i++) {//i是遍历的下标
            tempLength = length - i;
            if (maxLength >= tempLength) {
                return result;
            }
            while (tempLength >= 1) {
                temp = s.substring(i, i + tempLength);
                if (isPalindrome(temp) && tempLength > maxLength) {
                    result = temp;
                    maxLength = tempLength;
                }
                tempLength--;
                if (maxLength >= tempLength) {
                    break;
                }
            }
        }
        return result;
    }

    private static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (chars[i] != chars[length - 1 - i]) {
                return false;
            }
        }
        return true;
    }


    /**
     * 人家6ms的
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        if (s == null)
            throw new IllegalArgumentException();
        if (s.length() < 2)
            return s;
        char[] arr = s.toCharArray();
        int[] ret = new int[2];
        for (int i = 0; i < arr.length; i++) {
            i = loop(arr, i, ret);
        }
        return s.substring(ret[0], ret[1]);
    }

    private static int loop(char[] arr, int low, int[] ret) {
        int high = low;
        while (high < arr.length - 1 && arr[high + 1] == arr[low]) high++;
        int res = high;

        while (low >= 0 && high < arr.length && arr[low] == arr[high]) {
            low--;
            high++;
        }
        if (high - low - 1 > ret[1] - ret[0]) {
            ret[1] = high;
            ret[0] = low + 1;
        }
        return res;
    }
}
