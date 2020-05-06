package lixuan.sort;

import java.util.Arrays;

public class MergeSort {
    private void mergeSort(int[] nums,int low,int high){
        if (low<high){
            int mid=low+(high-low)/2;
            mergeSort(nums,low,mid);
            mergeSort(nums,mid+1,high);
            merge(nums,low,mid,high);
        }
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int n=high-low+1;
        int[] temp=new int[n];
        int k=0;
        int i=low;
        int j=mid+1;
        while (i<=mid&&j<=high){
            if (nums[i]<nums[j]){
                temp[k++]=nums[i++];
            }else {
                temp[k++]=nums[j++];
            }
        }
        while (i<=mid){
            temp[k++]=nums[i++];
        }
        while (j<=high){
            temp[k++]=nums[j++];
        }
        for (int d=0;d<n;d++){
            nums[d+low]=temp[d];
        }
    }

    public static void main(String[] args) {
        MergeSort test = new MergeSort();
        int[] nums = {38, 65, 97, 76, 13, 27, 49};
        test.mergeSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
