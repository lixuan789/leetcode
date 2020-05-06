package lixuan.sort;

import java.util.Arrays;

/**
 * 希尔排序：先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，
 * 再对全体记录进行依次直接插入排序。
 */
public class ShellSort {
    private void shellSort(int[] nums) {
        int n = nums.length;
        int d = n / 2;
        while (d >= 1) {
            shellSort(nums, d);
            d /= 2;
        }
    }

    private void shellSort(int[] nums, int dk) {
        for (int i = dk; i < nums.length; ++i) {
            if (nums[i] < nums[i - dk]) {            //若第i个元素大于i-1元素，直接插入。小于的话，移动有序表后插入
                int j = i - dk;
                int num = nums[i];            //复制为哨兵，即存储待排序元素
                while (j >= 0 && num < nums[j]) {        //查找在有序表的插入位置
                    nums[j + dk] = nums[j];
                    j -= dk;             //元素后移
                }
                nums[j + dk] = num;            //插入到正确位置
            }
        }
    }

    public static void main(String[] args) {
        ShellSort test = new ShellSort();
        int[] nums = {38, 65, 97, 76, 13, 27, 49};
        test.shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
