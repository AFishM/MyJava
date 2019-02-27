package algorithm;

import algorithm.leetcode.tencent.arrayandstring.FindMedianSortedArrays;

/**
 * Created by xuzixu on 2019/2/27.
 */
public class Main {
    public static void main(String[] args) {
        int[] num1 = {1, 3};
        int[] num2 = {2};
        FindMedianSortedArrays test = new FindMedianSortedArrays();
        double result = test.findMedianSortedArrays(num1, num2);
        System.out.print(result);
    }
}
