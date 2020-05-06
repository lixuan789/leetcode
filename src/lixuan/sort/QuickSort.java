package lixuan.sort;

import java.util.Arrays;

public class QuickSort {
    /**
     * 快速排序
     * @param nums
     * @param low
     * @param high
     */
    private void quickSort(int[] nums,int low,int high){
        if (low<high){
            int mid=partition(nums,low,high);
            quickSort(nums, low, mid-1);
            quickSort(nums, mid+1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot=nums[low];
        while (low<high){
            while (low<high&&nums[high]>=pivot){
                high--;
            }
            if (low<high){
                nums[low]=nums[high];
            }
            while (low<high&&nums[low]<=pivot){
                low++;
            }
            if (low<high){
                nums[high]=nums[low];
            }
        }
        nums[low]=pivot;
        return low;
    }

    public static void main(String[] args) {
        QuickSort test = new QuickSort();
        int[] nums = {38, 65, 97, 76, 13, 27, 49};
        test.quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
