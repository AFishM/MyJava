package algorithm.leetcode.tencent.arrayandstring;

public class RemoveDuplicates {
    public static int[] arg = {1, 1, 2};

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int temp = nums[0];
        int index = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] != temp) {
                temp = nums[i];
                nums[index] = temp;
                index++;
            }
        }
        return index;
    }
}
