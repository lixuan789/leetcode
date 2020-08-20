package lixuan.binarySearch;

/**
 * 寻找旋转排序数组中的最小值
 */
public class Code153FindMin {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                return findMin(nums, left, right);
            }
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    private int findMin(int[] nums, int left, int right) {
        for (int i = left; i < right; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[left];
    }
}
