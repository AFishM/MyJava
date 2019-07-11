package algorithm.leetcode.tencent.arrayandstring;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        int numsLength = nums.length;
        int posSize = 0;
        int[] posNums = new int[numsLength];
        int negSize = 0;
        int[] negNums = new int[numsLength];
        int temp;
        int zeroSize;
        for (int i = 0; i < nums.length; i++) {
            temp = nums[i];
            if (temp > 0) {
                posNums[posSize] = temp;
                posSize++;
            } else if (temp < 0) {
                negNums[negSize] = temp;
                negSize++;
            }
        }
        zeroSize = numsLength - posSize - negSize;
        if (zeroSize >= 3) {
            result.add(Arrays.asList(0, 0, 0));
        }
        if (posSize == 0 || negSize == 0) {
            return result;
        }
        Arrays.sort(posNums, 0, posSize);
        Arrays.sort(negNums, 0, negSize);
        Set<Integer> posNumSet = new HashSet<>();
        Map<Integer, Integer> posPosMap = new HashMap<>();
        Map<Integer, Integer> posNegMap = new HashMap<>();
        int a;
        int b;
        int c;
        for (int i = 0; i < posSize; i++) {
            a = posNums[i];
            if (posNumSet.contains(a)) {
                continue;
            }
            posNumSet.add(a);
            for (int j = 0; j < negSize; j++) {
                b = negNums[j];
                if (posNegMap.containsKey(a) && posNegMap.get(a) == b) {
                    continue;
                }
                posNegMap.put(a, b);
                c = 0 - a - b;
                if (c > 0) {
                    if (posPosMap.containsKey(a) && posPosMap.get(a) == c) {
                        continue;
                    }
                    posPosMap.put(a, c);
                    for (int k = i + 1; k < posSize; k++) {
                        if (c == posNums[k]) {
                            result.add(Arrays.asList(a, b, c));
                            break;
                        }
                    }
                } else if (c < 0) {
                    for (int k = j + 1; k < negSize; k++) {
                        if (c == negNums[k]) {
                            result.add(Arrays.asList(a, b, c));
                            break;
                        }
                    }
                } else if (zeroSize > 0) {
                    result.add(Arrays.asList(a, b, c));
                }
            }
        }
        return result;


//        int n = nums[0];
//        boolean sameNum = true;
//        for (int i = 1; i < nums.length; i++) {
//            if (n != nums[i]) {
//                sameNum = false;
//                break;
//            }
//        }
//        if (sameNum) {
//            if (n == 0) {
//                List<Integer> list = new ArrayList<>();
//                list.add(0);
//                list.add(0);
//                list.add(0);
//                result.add(list);
//            }
//            return result;
//        }
//        int a;
//        int b;
//        int c;
//        for (int i = 0; i < nums.length; i++) {
//            a = nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                b = nums[j];
//                for (int k = j + 1; k < nums.length; k++) {
//                    c = nums[k];
//                    if ((a + b + c) == 0) {
//                        int temp;
//                        int tempa = a;
//                        int tempb = b;
//                        int tempc = c;
//                        if (tempa > tempb) {
//                            temp = tempa;
//                            tempa = tempb;
//                            tempb = temp;
//                        }
//                        if (tempb > tempc) {
//                            temp = tempb;
//                            tempb = tempc;
//                            tempc = temp;
//                        }
//                        if (tempa > tempb) {
//                            temp = tempa;
//                            tempa = tempb;
//                            tempb = temp;
//                        }
//                        int z;
//                        for (z = 0; z < result.size(); z++) {
//                            List<Integer> list = result.get(z);
//                            if (list.get(0) == tempa && list.get(1) == tempb && list.get(2) == tempc) {
//                                break;
//                            }
//                        }
//                        if (z == result.size()) {
//                            List<Integer> list = new ArrayList<>();
//                            list.add(tempa);
//                            list.add(tempb);
//                            list.add(tempc);
//                            result.add(list);
//                        }
//                    }
//                }
//            }
//        }
//        return result;
    }
}
