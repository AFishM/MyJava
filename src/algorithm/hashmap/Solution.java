package algorithm.hashmap;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1};

        new Solution().topKFrequent(nums, 1);
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        int length = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        int num;
        int frequent;
        for (int i = 0; i < length; i++) {
            num = nums[i];
            frequent = map.getOrDefault(num, 0);
            map.put(num, frequent + 1);
        }
        HashSet<Integer>[] temp = new HashSet[length + 1];
        for (int key : map.keySet()) {
            frequent = map.get(key);
            if (frequent != 0) {
                if (temp[frequent] == null) {
                    temp[frequent] = new HashSet<>();
                }
                temp[frequent].add(key);
            }
        }
        List<Integer> result = new ArrayList<>(k);
        HashSet<Integer> set;
        for (int i = length; i > 0; i--) {
            if ((set = temp[i]) != null) {
                result.addAll(set);
                if (result.size() >= k) {
                    return result;
                }
            }
        }
        return result;
    }

    static class Tree {
        int value;
        Tree left;
        Tree right;
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int length = A.length;
        HashMap<Integer, Integer> abSum = new HashMap<>();
        int sum;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                sum = A[i] + B[j];
                abSum.put(sum, abSum.getOrDefault(sum, 0) + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                sum = -C[i] - D[j];
                count = count + abSum.getOrDefault(sum, 0);
            }
        }
        return count;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int fromIndex = -1;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (map.containsKey(c)) {
                int findIndex = map.get(c);
                map.put(c, i);
                if (findIndex <= fromIndex) {
                    continue;
                }
                int length = i - 1 - fromIndex;
                if (length > result) {
                    result = length;
                }
                if (findIndex + result >= chars.length - 1) {
                    break;
                }
                fromIndex = findIndex;
            } else {
                map.put(c, i);
                int length = i - fromIndex;
                if (length > result) {
                    result = length;
                }
            }
        }
        return result;
    }

    public int numJewelsInStones(String J, String S) {
        char[] charsJ = J.toCharArray();
        char[] charsS = S.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (char c : charsJ) {
            set.add(c);
        }
        int result = 0;
        for (char c : charsS) {
            if (set.contains(c)) {
                result++;
            }
        }
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, List<TreeNode>> map = new HashMap<>();
        leftToRight(root, map);
        List<TreeNode> list = new ArrayList<>();
        for (List<TreeNode> nodeList : map.values()) {
            if (nodeList.size() > 1) {
                list.add(nodeList.get(0));
            }
        }
        return list;
    }

    private String leftToRight(TreeNode root, HashMap<String, List<TreeNode>> map) {
        String s = "";
        if (root != null) {
            s = s + "l" + leftToRight(root.left, map);
            s = s + root.val;
            s = s + "r" + leftToRight(root.right, map);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(root);
        }
        return s;
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null) {
            return false;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : nums) {
            if (hashSet.contains(i)) {
                return true;
            }
            hashSet.add(i);
        }
        return false;
    }

    public int singleNumber(int[] nums) {
        if (nums == null) {
            return -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (int i : map.keySet()) {
            if (map.get(i) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 解题思路：
     * 1. 使用位运算 ^(XOR)的特性，两个相同的数进行XOR值为0，0与一个数进行异或运算值为此数，0 XOR A = A
     */
//    public int singleNumber(int[] nums) {
//        int result = 0;
//        for (int num : nums) {
//            result ^= num;
//        }
//        return result;
//    }
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        if (nums1.length < nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                set1.add(i);
            }
        }
        int[] result = new int[set1.size()];
        int index = 0;
        for (int i : set1) {
            result[index] = i;
            index++;
        }
        return result;
    }

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
            int temp = n;
            n = 0;
            while (temp >= 10) {
                n = (int) Math.pow(temp % 10, 2) + n;
                temp = temp / 10;
            }
            n = (int) Math.pow(temp % 10, 2) + n;
        }
        return true;
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public boolean isIsomorphic(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            char sc = chars[i];
            char tc = chart[i];
            if (map.containsKey(sc)) {
                if (map.get(sc) != tc) {
                    return false;
                }
            } else if (map.containsValue(tc)) {
                return false;
            } else {
                map.put(sc, tc);
            }
        }
        return true;
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int sum = Integer.MAX_VALUE;
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            String s = list2[i];
            if (map.containsKey(s)) {
                int tempSum = map.get(s) + i;
                if (tempSum < sum) {
                    sum = tempSum;
                    result.clear();
                    result.add(s);
                } else if (tempSum == sum) {
                    result.add(s);
                }
            }
        }
        return result.toArray(new String[0]);
    }

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        ArrayList<Character> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (map.containsKey(c)) {
                int index = map.get(c);
                if (index != -1) {
                    list.remove((Character) c);
                    map.put(c, -1);
                }
            } else {
                list.add(c);
                map.put(c, i);
            }
        }
        if (list.isEmpty()) {
            return -1;
        }
        return map.get(list.get(0));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (int i : nums2) {
            if (map.containsKey(i)) {
                list.add(i);
                int count = map.get(i);
                if (count == 1) {
                    map.remove(i);
                } else {
                    map.put(i, count - 1);
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    class Logger {

        /**
         * Initialize your data structure here.
         */
        public Logger() {

        }

        HashMap<String, Integer> map = new HashMap<>();

        /**
         * Returns true if the message should be printed in the given timestamp, otherwise returns false.
         * If this method returns false, the message will not be printed.
         * The timestamp is in seconds granularity.
         */
        public boolean shouldPrintMessage(int timestamp, String message) {
            if (!map.containsKey(message)) {
                map.put(message, timestamp);
                return true;
            }
            if (timestamp - map.get(message) < 10) {
                return false;
            }
            map.put(message, timestamp);
            return true;
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        boolean notAdd;
        for (String s : strings) {
            notAdd = true;
            for (String key : map.keySet()) {
                if (isSameString(s, key)) {
                    map.get(key).add(s);
                    notAdd = false;
                    break;
                }
            }
            if (notAdd) {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(s, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    private boolean isSameString(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int c = charsA[0] - charsB[0];
        if (c < 0) {
            c = c + 26;
        }
        int distance;
        for (int i = 1; i < charsA.length; i++) {
            distance = charsA[i] - charsB[i];
            if (distance < 0) {
                distance = distance + 26;
            }
            if (distance != c) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        HashMap<Character, List<Index>> map = new HashMap<>();
        char c;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                c = board[i][j];
                if (c == '.') {
                    continue;
                }
                Index index = new Index(i, j);
                if (map.containsKey(c)) {
                    List<Index> list = map.get(c);
                    for (Index index1 : list) {
                        if (index.i == index1.i || index.j == index1.j || index.which33 == index1.which33) {
                            return false;
                        }
                    }
                    list.add(index);
                } else {
                    List<Index> indexList = new ArrayList<>();
                    indexList.add(index);
                    map.put(c, indexList);
                }
            }
        }
        return true;
    }

    private static class Index {
        int i;
        int j;
        int which33;

        Index(int i, int j) {
            this.i = i;
            this.j = j;
            onWhich33();
        }

        void onWhich33() {
            if (i < 3) {
                if (j < 3) {
                    which33 = 1;
                } else if (j < 6) {
                    which33 = 2;
                } else {
                    which33 = 3;
                }
            } else if (i < 6) {
                if (j < 3) {
                    which33 = 4;
                } else if (j < 6) {
                    which33 = 5;
                } else {
                    which33 = 6;
                }
            } else {
                if (j < 3) {
                    which33 = 7;
                } else if (j < 6) {
                    which33 = 8;
                } else {
                    which33 = 9;
                }
            }
        }
    }
}
