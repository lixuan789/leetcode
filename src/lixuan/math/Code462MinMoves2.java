package lixuan.math;

import javax.print.DocFlavor;
import java.util.Arrays;

/**
 * 给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1。
 * 您可以假设数组的长度最多为10000。
 * <p>
 * 例如:
 * 输入:
 * [1,2,3]
 * <p>
 * 输出:
 * 2
 * <p>
 * 说明：
 * 只有两个动作是必要的（记得每一步仅可使其中一个元素加1或减1）：
 * <p>
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 */
public class Code462MinMoves2 {
    /**
     * 什么时候均方差最小？
     * 移动距离最小的方式是所有元素都移动到中位数。
     *
     * @param nums
     * @return
     */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int move = 0;
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            move += nums[h] - nums[l];
            l++;
            h--;
        }
        return move;
    }

    /**
     * 使用快速排序找到中位数
     *
     * @param nums
     * @return
     */
    public int minMoves21(int[] nums) {
        int n = nums.length;
        int move = 0;
        int mid = findMid(nums, n / 2);
        for (int num : nums) {
            move += (Math.abs(num - mid));
        }
        return move;
    }

    private int findMid(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (k == j) {
                return nums[k];
            }
            if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int i, int j) {
        int privot = nums[i];
        while (i < j) {
            while (j > i && nums[j] >= privot) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= privot) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = privot;
        return i;
    }

}
