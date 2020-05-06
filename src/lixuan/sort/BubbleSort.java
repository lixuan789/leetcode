package lixuan.sort;

import java.util.Arrays;

public class BubbleSort {
    /**
     * 冒泡排序
     *
     * @param nums
     */
    private void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 改进
     *
     * @param nums
     */
    private void bubbleSort1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = false;
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    /**
     * 用pos记录已经排序到的位置
     *
     * @param nums
     */
    private void bubbleSort2(int[] nums) {
        int i = nums.length - 1;  //初始时,最后位置保持不变
        while (i > 0) {
            int pos = 0; //每趟开始时,无记录交换
            for (int j = 0; j < i; j++)
                if (nums[j] > nums[j + 1]) {
                    pos = j; //记录交换的位置
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            i = pos; //为下一趟排序作准备
        }
    }

    /**
     * 双向冒泡
     * @param nums
     */
    private void bubbleSort3(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while (low<high){
            for (int i=low;i<high;i++){
                if (nums[i]>nums[i+1]){
                    int temp=nums[i];
                    nums[i]=nums[i+1];
                    nums[i+1]=temp;
                }
            }
            high--;
            for (int i=high;i>low;i--){
                if (nums[i]<nums[i-1]){
                    int temp=nums[i];
                    nums[i]=nums[i-1];
                    nums[i-1]=temp;
                }
            }
            low++;
        }
    }


    public static void main(String[] args) {
        BubbleSort test = new BubbleSort();
        int[] nums = {38, 65, 97, 76, 13, 27, 49};
        test.bubbleSort3(nums);
        System.out.println(Arrays.toString(nums));
    }
}
