package lixuan.sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，
 *  而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code215findKthLargest {
    /**
     * 方法一：使用最小堆
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(k,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });//最小堆
        for (int i=0;i<nums.length;i++){
            minQueue.add(nums[i]);
            if(minQueue.size()>k){
                minQueue.poll();
            }
        }
        return minQueue.peek();
    }

    /**
     * 方法二：使用快速排序的partition
     * @param nums
     * @param k
     * @return
     */
    private static Random random = new Random(System.currentTimeMillis());
    public int findKthLargest1(int[] nums, int k) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int left=0;
        int right=nums.length-1;
        int target=nums.length-k;
        while (true){
            int index = partition(nums, left, right);
            if(index==target){
                return nums[index];
            }else if(index<k){
                left=index+1;
            }else {
                right=index-1;
            }
        }

    }

    private int partition(int[] nums, int i, int j) {
        if(i<j){
            int randomIndex=i+random.nextInt(j-i)+1;
            int temp=nums[i];
            nums[i]=nums[randomIndex];
            nums[randomIndex]=temp;
        }
        int pivot=nums[i];
        /*while (i<j){
            while (i<j&&nums[j]>pivot){
                j--;
            }
            nums[i]=nums[j];
            while (i<j&&nums[i]<pivot){
                i++;
            }
            nums[j]=nums[i];
        }
        nums[i]=pivot;
        return i;*/
        int left=i;
        for (int k=i+1;k<=j;k++){
            if(nums[k]<pivot){
                left++;
                int swap=nums[k];
                nums[k]=nums[left];
                nums[left]=swap;
            }
        }
        int swap=nums[left];
        nums[left]=pivot;
        pivot=swap;
        return left;
    }

}
