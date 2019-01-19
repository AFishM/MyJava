package leetcode.tencent;

public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {-1, 3};
        System.out.println("" + new FindMedianSortedArrays().findMedianSortedArrays(nums1, nums2));
    }

    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            if (nums2 == null || nums2.length == 0) {
                return 0;
            }
            return findMedianSortArray(nums2);
        }
        if (nums2 == null || nums2.length == 0) {
            return findMedianSortArray(nums1);
        }

        double middleOfNums1 = findMedianSortArray(nums1);
        double middleOfNums2 = findMedianSortArray(nums2);
        if (middleOfNums1 == middleOfNums2) {
            return middleOfNums1;
        }

        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        if (nums1Length == 1) {
            if (nums2Length == 1) {
                return ((double) (nums1[0] + nums2[0])) / 2;
            }
            return find(nums1[0], nums2, middleOfNums2);
        }
        if (nums2Length == 1) {
            return find(nums2[0], nums1, middleOfNums1);
        }

        int cutLength = nums1Length < nums2Length ? nums1Length / 2 : nums2Length / 2;
        int[] subNums1 = new int[nums1Length - cutLength];
        int[] subNums2 = new int[nums2Length - cutLength];
        if (middleOfNums1 < middleOfNums2) {
            System.arraycopy(nums1, cutLength, subNums1, 0, subNums1.length);
            System.arraycopy(nums2, 0, subNums2, 0, subNums2.length);
        } else {
            System.arraycopy(nums1, 0, subNums1, 0, subNums1.length);
            System.arraycopy(nums2, cutLength, subNums2, 0, subNums2.length);
        }
        return findMedianSortedArrays(subNums1, subNums2);
    }

    private double findMedianSortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("nums should not be empty");
        }
        int length = nums.length;
        if (length % 2 == 0) {
            return ((double) (nums[length / 2 - 1] + nums[length / 2])) / 2;
        }
        return nums[length / 2];
    }

    private double find(int i, int[] nums, double middleOfNums) {
        int numsLength = nums.length;
        int temp;
        if (numsLength % 2 == 0) {
            if (i < middleOfNums) {
                temp = nums[numsLength / 2 - 1];
                if (i > temp) {
                    return i;
                }
                return temp;
            }
            temp = nums[numsLength / 2];
            if (i < temp) {
                return i;
            }
            return temp;
        }
        if (i < middleOfNums) {
            temp = nums[numsLength / 2 - 1];
            if (i > temp) {
                return (i + middleOfNums) / 2;
            }
            return (temp + middleOfNums) / 2;
        }
        temp = nums[numsLength / 2 + 1];
        if (i < temp) {
            return (i + middleOfNums) / 2;
        }
        return (temp + middleOfNums) / 2;
    }
}
