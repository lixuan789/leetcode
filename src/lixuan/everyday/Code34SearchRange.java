package lixuan.everyday;

public class Code34SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = searchRange(nums, 0, nums.length - 1, target - 1);
        if (  nums[left] == target) {
            int right = searchRange(nums, 0, nums.length - 1, target);
            if (left <= right) {
                return new int[]{left, right};
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 查找第一个大于target的数组下标
     *
     * @param nums
     * @param i
     * @param j
     * @param target
     * @return
     */
    private int searchRange(int[] nums, int i, int j, int target) {
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }
}
