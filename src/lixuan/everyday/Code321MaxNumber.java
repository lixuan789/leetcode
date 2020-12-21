package lixuan.everyday;

import java.util.Arrays;

public class Code321MaxNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[k];
        int start = Math.max(0, k - n), end = Math.min(k, m);
        for (int i = start; i <= end; i++) {
            int[] maxSuquence1 = maxSuquence(nums1, i);
            int[] maxSuquence2 = maxSuquence(nums2, k - i);
            int[] merge = merge(nums1, nums2);
            if (compare(merge, 0, res, 0) > 0) {
                System.arraycopy(merge, 0, res, 0, k);
            }
        }
        return res;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m == 0) {
            return nums2;
        }
        if (n == 0) {
            return nums1;
        }
        int[] res = new int[m + n];
        int index1 = 0, index2 = 0;
        for (int i = 0; i < m + n; i++) {
            if (compare(nums1, index1, nums2, index2) > 0) {
                res[i] = nums1[index1++];
            } else {
                res[i] = nums2[index2++];
            }
        }
        return res;
    }

    private int compare(int[] nums1, int index1, int[] nums2, int index2) {
        int m = nums1.length;
        int n = nums2.length;
        while (index1 < m && index2 < n) {
            int difference = nums1[index1] - nums2[index2];
            if (difference != 0) {
                return difference;
            }
            index1++;
            index2++;
        }
        return 0;
    }

    /**
     * 选取k个数：最大子序列
     *
     * @param nums
     * @param k
     * @return
     */
    private int[] maxSuquence(int[] nums, int k) {
        int[] stack = new int[k];
        int top = -1;
        int rem = nums.length - k;//移除元素的个数
        for (int i = 0; i < nums.length; i++) {
            while (top >= 0 && stack[top] < nums[i] && rem > 0) {
                top--;
                rem--;
            }
            if (top < k - 1) {
                stack[++top] = nums[i];
            } else {
                rem--;
            }
        }
        return stack;
    }

    public static void main(String[] args) {
        int[] nums = {9, 1, 2, 5, 8, 3};
        Code321MaxNumber maxNumber = new Code321MaxNumber();
        int[] ints = maxNumber.maxSuquence(nums, 2);
        System.out.println(Arrays.toString(ints));
    }
}
