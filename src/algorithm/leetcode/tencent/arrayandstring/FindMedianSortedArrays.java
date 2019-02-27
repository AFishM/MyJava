package algorithm.leetcode.tencent.arrayandstring;

/**
 * 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空
 * <p>
 * 解答：
 * 找第一个数组的分隔点i和第二个数组的分隔点j，
 * 使得i和j的左边的数量等于右边，或者刚好大1
 * 并且左边的数比右边的小
 * Created by xuzixu on 2019/2/27.
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
         * 注释的部分，可有可无，在数据量大的时候，应该可以节省运行时间，
         * 数据量小就运行太多代码拖慢时间咯
         */
//        if (nums1 == null || nums1.length == 0) {
//            if (nums2.length % 2 == 0) {
//                return (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2.0;
//            }
//            return nums2[nums2.length / 2];
//        }
//        if (nums2 == null || nums2.length == 0) {
//            if (nums1.length % 2 == 0) {
//                return (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2.0;
//            }
//            return nums1[nums1.length / 2];
//        }
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            int[] tempNums = nums1;
            nums1 = nums2;
            nums2 = tempNums;
            int temp = m;
            m = n;
            n = temp;
        }
//        if (nums1[m - 1] <= nums2[0]) {
//            if (m == n) {
//                return (nums1[m - 1] + nums2[0]) / 2.0;
//            }
//            if ((m + n) % 2 == 0) {
//                return (nums2[(n - m) / 2 - 1] + nums2[(n - m) / 2]) / 2.0;
//            }
//            return nums2[(n - m) / 2];
//        }
//        if (nums2[n - 1] <= nums1[0]) {
//            if (m == n) {
//                return (nums2[n - 1] + nums1[0]) / 2.0;
//            }
//            if ((m + n) % 2 == 0) {
//                return (nums2[(n + m) / 2 - 1] + nums2[(n + m) / 2]) / 2.0;
//            }
//            return nums2[(n + m) / 2];
//        }
        int iMin = 0;
        int iMax = m;
        int halfLength = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLength - i;
            if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin++;
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax--;
            } else {
                int maxLeft;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }
                int minRight;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
