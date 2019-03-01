package algorithm.leetcode.tencent.arrayandstring;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""
 * <p>
 * 输入: ["flower","flow","flight"]，输出: "fl"
 * 输入: ["dog","racecar","car"]，输出: ""，解释: 输入不存在公共前缀。
 * Created by xuzixu on 2019/3/1.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String result = "";
        char c;
        for (int index = 0; index < strs[0].length(); index++) {
            c = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (index == strs[i].length()) {
                    return result;
                }
                if (c != strs[i].charAt(index)) {
                    return result;
                }
            }
            result = result + c;
        }
        return result;
    }
}
