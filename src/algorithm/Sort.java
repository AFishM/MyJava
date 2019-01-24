package algorithm;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arrays = {1, 8, 5, 4, 9, 10, 34, 21, 23};
//        selectSort(arrays);
        insertSort(arrays);
        System.out.println(Arrays.toString(arrays));
    }

    /**
     * 选择排序
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

    /**
     * 插入排序
     * 如同玩扑克牌一样，每次摸牌都将它与手中的牌比较，始终将牌放在比它大的牌前面，比它小的牌后面。这样当牌全部摸到手上后，就是一个有序的序列
     */
    private static void insertSort(int[] arrays) {
        int temp;
        for (int i = 1; i < arrays.length; i++) {
            temp = arrays[i];
            int j = i - 1;
            while (j >= 0 && arrays[j] > temp) {
                arrays[j + 1] = arrays[j];
                j--;
            }
            arrays[j + 1] = temp;
        }
    }


}
