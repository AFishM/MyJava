package algorithm;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args){
        int[] arrays={1,8,5,4,9,10,34,21,23};
        selectSort(arrays);
        System.out.println(Arrays.toString(arrays));
    }

    /**
     * 在乱序数组中，假设第一位数最小，依次让后面的数与之比较，若遇到比它小的数就交换位置，一趟下来第一个数就是序列中最小的数，然后从第二个数开始重复操作
     */
    private static void selectSort(int[] arrays) {
        int position;
        int temp;
        for (int i = 0; i < arrays.length - 1; i++) {
            position = i;
            temp = arrays[i];
            for (int j = i + 1; j < arrays.length; j++) {
                if (temp > arrays[j]) {
                    position = j;
                    temp = arrays[j];
                }
            }
            if (position != i) {
                arrays[position] = arrays[i];
                arrays[i] = temp;
            }
        }
    }
}
