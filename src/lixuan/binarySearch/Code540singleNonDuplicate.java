package lixuan.binarySearch;

/**
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code540singleNonDuplicate {
    /**
     * 令 index 为 Single Element 在数组中的位置。在 index 之后，数组中原来存在的成对状态被改变。
     * 如果 m 为偶数，并且 m + 1 < index，那么 nums[m] == nums[m + 1]；
     * m + 1 >= index，那么 nums[m] != nums[m + 1]。
     *
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1) {
                mid--;//只能偶数列进行判断
            }
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            }
            if (nums[mid] != nums[mid + 1]) {
                right = mid;
            }
        }
        return nums[left];
    }
}
