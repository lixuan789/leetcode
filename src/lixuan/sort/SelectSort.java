package lixuan.sort;

import java.util.Arrays;

public class SelectSort {
    /**
     * 选择排序
     * @param nums
     */
    private void selectSort(int[] nums){
        for (int i=0;i<nums.length-1;i++){
            int min=i;
            for (int j=i;j<nums.length;j++){
                if (nums[j]<nums[min]){
                    min=j;
                }
            }
            if (i!=min){
                int temp=nums[i];
                nums[i]=nums[min];
                nums[min]=temp;
            }
        }
    }

    public static void main(String[] args) {
        SelectSort test = new SelectSort();
        int[] nums = {38, 65, 97, 76, 13, 27, 49};
        test.selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
