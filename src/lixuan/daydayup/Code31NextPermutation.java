package lixuan.daydayup;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code31NextPermutation {
    /**
     * 例子：125643
     *      1.从后往前找到降序最开始的地方得到6，因为是降序怎么交换只能更小
     *      2.再往前找第一个小于6的数为5,即前一个数
     *      3.5与6之前最小的大于5的元素6交换
     *      4.从6的位置开始到最后进行排序（从小到大排序）
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i=nums.length-1;
        for (;i>=1;i--){
            if (nums[i]>nums[i-1]){
                break;
            }
        }
        if (i==0){
            quickSort(0,nums.length-1,nums);
        }else {
            int j=nums.length-1;
            for (;j>=i;j--){
                if (nums[j]>nums[i-1]){
                    break;
                }
            }
            myswap(i-1,j,nums);
            quickSort(i,nums.length-1,nums);
        }
    }

    private void quickSort(int i, int j, int[] nums) {
        if (i>=j){
            return;
        }
        int mid=priovt(i,j,nums);
        quickSort(i,mid-1,nums);
        quickSort(mid+1,j,nums);
    }

    private int priovt(int i, int j, int[] nums) {
        int num=nums[i];
        int left=i;
        for (int k=i+1;k<=j;k++){
            if (nums[k]<num){
                left++;
                myswap(left,k,nums);
            }
        }
        myswap(left,i,nums);
        return left;
    }

    private void myswap(int left, int i, int[] nums) {
        int temp=nums[left];
        nums[left]=nums[i];
        nums[i]=temp;
    }
}
