package algorithm.leetcode.tencent.arrayandstring;

/**
 * Created by xuzixu on 2019/2/28.
 */
public class MyAtoi {
    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int index = 0;
        int length = str.length();
        while (str.charAt(index) == ' ') {
            index++;
            if (index >= length) {
                return 0;
            }
        }

        boolean isNegative = false;
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            index++;
            isNegative = true;
        }

        long result = 0;
        char c;
        while (index < length) {
            c = str.charAt(index);
            if (c == ' ' || c < '0' || c > '9') {
                break;
            }
            result = result * 10 + (c - '0');
            if (isNegative && -result <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (!isNegative && result >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            index++;
        }
        return (int) (isNegative ? -result : result);
    }
}
