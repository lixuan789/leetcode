package lixuan.DataStructure.arrayandmatrix;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 说明：
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class Code283MoveZeroes {
    /**
     * 双指针:将数组分为2个区域，i之前是元素不为0的元素
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int i = -1;//0-i为不为0的元素区域，并保持原来的顺序
        int n = nums.length;
        for (int j = 0; j < n; j++) {
            if (nums[j] != 0) {
                i++;
                nums[i] = nums[j];
            }
        }
        for (int j = i + 1; j < n; j++) {
            nums[j] = 0;
        }
    }
}
