package lixuan.hot100;

public class maxProduct {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        int[] maxi = new int[n];
        int[] mini = new int[n];
        maxi[0] = nums[0];
        mini[0] = nums[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            maxi[i] = Math.max(nums[i], Math.max(maxi[i - 1] * nums[i], mini[i - 1] * nums[i]));
            mini[i] = Math.min(nums[i], Math.min(maxi[i - 1] * nums[i], mini[i - 1] * nums[i]));
            res = Math.max(res, maxi[i]);
        }
        return res;
    }
}
