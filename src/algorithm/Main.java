package algorithm;

import algorithm.leetcode.tencent.arrayandstring.ThreeSum;

import java.util.List;

/**
 * Created by xuzixu on 2019/2/27.
 */
public class Main {
    public static void main(String[] args) {
//        int[] num1 = {1, 3};
//        int[] num2 = {2};
//        FindMedianSortedArrays test = new FindMedianSortedArrays();
//        double result = test.findMedianSortedArrays(num1, num2);
//        String s="9223372036854775808";
//        int result=new MyAtoi().myAtoi(s);

        int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        List<List<Integer>> result=new ThreeSum().threeSum(nums);
        System.out.print(result);
    }
}
