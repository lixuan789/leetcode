package lixuan.sort;

import java.util.Arrays;

/**
 * 直接插入排序
 */
public class InsertSort {
    private int[] insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            int num = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > num) {
                nums[j + 1] = nums[j];//后移
                j--;
            }
            nums[j + 1] = num;
        }
        return nums;
    }

    public static void main(String[] args) {
        InsertSort test = new InsertSort();
        int[] nums = {38, 65, 97, 76, 13, 27, 49};
        int[] a = test.insertSort(nums);
        System.out.println(Arrays.toString(a));
    }
}
