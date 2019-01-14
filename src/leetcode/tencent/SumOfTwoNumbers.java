package leetcode.tencent;

import java.util.Arrays;

/**
 * 两数之和
 * 给定一个整数数组nums和一个目标值target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素
 * Created by xuzixu on 2019/1/14.
 */
public class SumOfTwoNumbers {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(new SumOfTwoNumbers().twoSum(nums, target)));
    }

    private int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indexs[0] = i;
                    indexs[1] = j;
                    break;
                }
            }
        }
        return indexs;
    }
}
