package algorithm;

import algorithm.leetcode.tencent.arrayandstring.MyAtoi;

/**
 * Created by xuzixu on 2019/2/27.
 */
public class Main {
    public static void main(String[] args) {
//        int[] num1 = {1, 3};
//        int[] num2 = {2};
//        FindMedianSortedArrays test = new FindMedianSortedArrays();
//        double result = test.findMedianSortedArrays(num1, num2);
        String s="9223372036854775808";
        int result=new MyAtoi().myAtoi(s);
        System.out.print(result);
    }
}
