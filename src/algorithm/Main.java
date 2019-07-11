package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuzixu on 2019/2/27.
 */
public class Main {
    public static void main(String[] args) {
//        int[] i = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
//        System.out.println(Arrays.toString(new Main().plusOne(i)));
//        int[] a = {1, 2, 3};
//        int[] b = {4, 5, 6};
//        int[] c = {7, 8, 9};
//        int[][] d = {a, b, c};
//        System.out.print(new Main().spiralOrder(d));
//        System.out.println(new Main().generate(5));


        // initialize
//        String s1 = "Hello World";
//        System.out.println("s1 is \"" + s1 + "\"");
//        String s2 = s1;
//        System.out.println("s2 is another reference to s1.");
//        String s3 = new String(s1);
//        System.out.println("s3 is a copy of s1.");
//        // compare using '=='
//        System.out.println("Compared by '==':");
//        // true since string is immutable and s1 is binded to "Hello World"
//        System.out.println("s1 and \"Hello World\": " + (s1 == "Hello World"));
//        // true since s1 and s2 is the reference of the same object
//        System.out.println("s1 and s2: " + (s1 == s2));
//        // false since s3 is refered to another new object
//        System.out.println("s1 and s3: " + (s1 == s3));
//        // compare using 'equals'
//        System.out.println("Compared by 'equals':");
//        System.out.println("s1 and \"Hello World\": " + s1.equals("Hello World"));
//        System.out.println("s1 and s2: " + s1.equals(s2));
//        System.out.println("s1 and s3: " + s1.equals(s3));
//        // compare using 'compareTo'
//        System.out.println("Compared by 'compareTo':");
//        System.out.println("s1 and \"Hello World\": " + (s1.compareTo("Hello World") == 0));
//        System.out.println("s1 and s2: " + (s1.compareTo(s2) == 0));
//        System.out.println("s1 and s3: " + (s1.compareTo(s3) == 0));
//
//        System.out.println(s3);
//        System.out.print(new Main().addBinary("100", "110010"));
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 2;
        rotate(nums, k);
    }

    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int temp;
        for (int i = 0; i < k; i++) {
            temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }


    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLength = 0;
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                length++;
            } else {
                if (length > maxLength) {
                    maxLength = length;
                }
                length = 0;
            }
        }
        if (length > maxLength) {
            maxLength = length;
        }
        return maxLength;
    }

    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static String addBinary(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        if (aLength < bLength) {
            int c = aLength;
            aLength = bLength;
            bLength = c;
            String temp = a;
            a = b;
            b = temp;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int needAdd = 0;
        int sum;
        int aIndex = aLength - 1;
        for (int i = bLength - 1; i >= 0; i--, aIndex--) {
            sum = getValue(a, aIndex) + getValue(b, i) + needAdd;
            if (sum > 1) {
                needAdd = 1;
                if (sum == 2) {
                    sum = 0;
                } else {
                    sum = 1;
                }
            } else {
                needAdd = 0;
            }
            stringBuilder.insert(0, sum);
        }
        for (int i = aIndex; i >= 0; i--) {
            sum = getValue(a, i) + needAdd;
            if (sum > 1) {
                needAdd = 1;
                if (sum == 2) {
                    sum = 0;
                } else {
                    sum = 1;
                }
            } else {
                needAdd = 0;
            }
            stringBuilder.insert(0, sum);
        }
        if (needAdd > 0) {
            stringBuilder.insert(0, needAdd);
        }
        return stringBuilder.toString();
    }

    private static int getValue(String s, int index) {
        if (s.charAt(index) == '0') {
            return 0;
        }
        return 1;
    }

    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int rightSum = 0;
        for (int i = 1; i < nums.length; i++) {
            rightSum = rightSum + nums[i];
        }
        if (rightSum == 0) {
            return 0;
        }
        int leftSum = 0;
        for (int i = 1; i < nums.length; i++) {
            leftSum = leftSum + nums[i - 1];
            rightSum = rightSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        int biggestNum = 0;
        int biggestNumIndex = -1;
        int secondNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > biggestNum) {
                secondNum = biggestNum;
                biggestNum = nums[i];
                biggestNumIndex = i;
            } else if (nums[i] > secondNum) {
                secondNum = nums[i];
            }
        }
        if (biggestNum >= secondNum * 2) {
            return biggestNumIndex;
        }
        return -1;
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 < 10) {
                digits[i] = digits[i] + 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] i = new int[digits.length + 1];
        System.arraycopy(digits, 0, i, 1, digits.length);
        i[0] = 1;
        return i;
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int[] result = new int[row * column];
        int rowIndex = 0;
        int columnIndex = 0;
        boolean isUp = true;
        for (int i = 0; i < result.length; i++) {
            result[i] = matrix[rowIndex][columnIndex];
            if (isUp) {
                if (rowIndex == 0) {
                    isUp = false;
                    if (columnIndex == column - 1) {
                        rowIndex++;
                    } else {
                        columnIndex++;
                    }
                } else if (columnIndex == column - 1) {
                    isUp = false;
                    rowIndex++;
                } else {
                    rowIndex--;
                    columnIndex++;
                }
            } else {
                if (columnIndex == 0) {
                    isUp = true;
                    if (rowIndex == row - 1) {
                        columnIndex++;
                    } else {
                        rowIndex++;
                    }
                } else if (rowIndex == row - 1) {
                    isUp = true;
                    columnIndex++;
                } else {
                    rowIndex++;
                    columnIndex--;
                }
            }
        }
        return result;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int num = row * column;
        int listIndex = 0;
        int ring = 0;
        int rowIndex = 0;
        int columnIndex = 0;
        int direction = 0;//0向右 1向下 2向左 3向上
        while (listIndex < num) {
            result.add(matrix[rowIndex][columnIndex]);
            switch (direction) {
                case 0:
                    if (columnIndex + ring < column - 1) {
                        columnIndex++;
                    } else {
                        direction = 1;
                        rowIndex++;
                    }
                    break;
                case 1:
                    if (rowIndex + ring < row - 1) {
                        rowIndex++;
                    } else {
                        direction = 2;
                        columnIndex--;
                    }
                    break;
                case 2:
                    if (columnIndex - ring > 0) {
                        columnIndex--;
                    } else {
                        direction = 3;
                        rowIndex--;
                    }
                    break;
                case 3:
                    if (rowIndex - ring > 1) {
                        rowIndex--;
                    } else {
                        ring++;
                        direction = 0;
                        columnIndex++;
                    }
                    break;
            }
            listIndex++;
        }
        return result;
    }

    public List<Integer> generate(int numRows) {

        ArrayList<Integer> row = new ArrayList<Integer>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
        }
        return row;
    }

    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> row = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
        }
        return row;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode late = head;

        try {
            while (true) {
                fast = fast.next.next;
                late = late.next;
                if (fast.val == late.val) {
                    return true;
                }
            }
        } catch (NullPointerException e) {
            return false;
        }
    }
}
