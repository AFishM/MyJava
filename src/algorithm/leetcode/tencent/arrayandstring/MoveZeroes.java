package algorithm.leetcode.tencent.arrayandstring;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int notZeroNum = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[notZeroNum] = nums[i];
                notZeroNum++;
            }
        }
        for (int i = notZeroNum; i < length; i++) {
            nums[i] = 0;
        }
    }
}
