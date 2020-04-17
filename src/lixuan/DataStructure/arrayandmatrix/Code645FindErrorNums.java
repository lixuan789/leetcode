package lixuan.DataStructure.arrayandmatrix;

import java.util.Arrays;

/**
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素
 * 复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * 你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * 注意:
 * 给定数组的长度范围是 [2, 10000]。
 * 给定的数组是无序的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-mismatch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code645FindErrorNums {
    /**
     * 使用一个数组记录一个数是否存在
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        boolean[] res = new boolean[n + 1];
        int[] ans = new int[2];
        for (int num : nums) {
            if (res[num] == false) {
                res[num] = true;
            } else {
                ans[0] = num;//重复的数
            }
        }
        for (int i = 1; i <= n; i++) {
            if (res[i] == false) {
                ans[1] = i;//缺失的数
                break;
            }
        }
        return ans;
    }

    /**
     * 主要思想是通过交换数组元素，使得数组上的元素在正确的位置上。
     * @param nums
     * @return
     */
    public int[] findErrorNums1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        return null;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
