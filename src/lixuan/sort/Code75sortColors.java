package lixuan.sort;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，
 * 并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * <p>
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code75sortColors {
    /**
     * 方法一：三向切分快速排序
     * 在三向切分快速排序中，每次切分都将数组分成三个区间：
     * 小于切分元素、等于切分元素、大于切分元素，而该算法是将数组分成三个区间：等于红色、等于白色、等于蓝色。
     * @param nums
     */
    public void sortColors(int[] nums) {
        for (int i=0;i<nums.length;i++){
            if(nums[i]==1){
                swap(nums,0,i);
                break;
            }
        }
        int lt=0;
        int i=lt+1;
        int gt=nums.length-1;
        int pivot=nums[0];
        while (i<=gt){
            if(nums[i]<pivot){
                swap(nums,i++,lt++);
            }else if(nums[i]>pivot){
                swap(nums,i,gt--);
            }else {
                i++;
            }
        }
    }

    /**
     * 优化
     * @param nums
     */
    public void sortColors1(int[] nums) {
        int zero=0,one=0,two=nums.length-1;
        while (one<=two){
            if(nums[one]==0){
                swap(nums,zero++,one++);
            }else if(nums[one]==2){
                swap(nums,one,two--);
            }else {
                one++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}
