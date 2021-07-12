package lixuan.sort;

import java.util.Arrays;

public class HeapSort {
    //调整堆
    private static void adjustHeap(int[] nums,int i,int len){
        int temp=nums[i];
        for (int j=2*i;j<len;j*=2){
            if (j<len-1&&nums[j]<nums[j+1]){
                j++;
            }
            if (temp>=nums[j]){
                break;
            }
            nums[i]=nums[j];
            i=j;
        }
        nums[i]=temp;
    }

    private static void heapSort(int[] nums){
        int n=nums.length;
        for (int i=n/2-1;i>=0;i--){//构建堆
            adjustHeap(nums,i,n);
        }
        for (int i=n-1;i>0;i--){
            int temp=nums[i];
            nums[i]=nums[0];
            nums[0]=temp;
            adjustHeap(nums,0,i);
        }
    }

    public static void main(String[] args) {
        int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}
