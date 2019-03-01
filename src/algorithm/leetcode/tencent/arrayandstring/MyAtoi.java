package algorithm.leetcode.tencent.arrayandstring;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * 说明：
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，qing返回  INT_MAX (231 − 1) 或 INT_MIN (−231)
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
