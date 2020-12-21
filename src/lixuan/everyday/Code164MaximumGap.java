package lixuan.everyday;

import java.util.Arrays;

/**
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * <p>
 * 如果数组元素个数小于 2，则返回 0。
 */
public class Code164MaximumGap {
    /**
     * 桶排序：线性时间和空间复杂度。超出内存限制
     *
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int length = 0;
        for (int num : nums) {
            length = Math.max(length, num);
        }
        boolean[] count = new boolean[length + 1];
        for (int num : nums) {
            count[num] = true;
        }
        boolean first = true;
        int pre = 0;
        int ans = 0;
        for (int i = 1; i <= length; i++) {
            if (count[i]) {
                if (first) {
                    pre = i;
                    first = false;
                } else {
                    int dis = i - pre;
                    ans = Math.max(ans, dis);
                    pre = i;
                }
            }
        }
        return ans;
    }


    /**
     * 基数排序：先按个位数排序-十位数。。
     *
     * @param nums
     * @return
     */
    public int maximumGap1(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int[] buf = new int[n];
        int exp = 1;
        int max = Arrays.stream(nums).max().getAsInt();
        while (max >= exp) {
            int[] cnt = new int[10];//统计各位数的数量
            for (int num : nums) {
                int digit = (num / exp) % 10;
                cnt[digit]++;
            }
            for (int i = 1; i < 10; i++) {
                cnt[i] += cnt[i - 1];//每个数的最后位置
            }
            for (int i = n - 1; i >= 0; i--) {
                int digit = (nums[i] / exp) % 10;
                buf[cnt[digit] - 1] = nums[i];
                cnt[digit]--;
            }
            System.arraycopy(buf, 0, nums, 0, n);
            exp *= 10;
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, nums[i] - nums[i - 1]);
        }
        return ans;
    }

    /**
     * 桶排序
     *
     * @param nums
     * @return
     */
    public int maximumGap2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        int size = Math.max(1, (max - min) / (n - 1));//每个桶的大小
        int length = (max - min) / size + 1;//桶的个数
        int[][] bucket = new int[length][2];
        for (int i = 0; i < length; i++) {
            Arrays.fill(bucket[i], -1);
        }
        for (int i = 0; i < n; i++) {
            int idx = (nums[i] - min) / size;
            if (bucket[idx][0] == -1) {
                bucket[idx][0] = bucket[idx][1] = nums[i];
            } else {
                bucket[idx][0] = Math.min(bucket[idx][0], nums[i]);
                bucket[idx][1] = Math.max(bucket[idx][1], nums[i]);
            }
        }
        int ans = 0;
        int pre = -1;
        for (int i = 0; i < length; i++) {
            if (bucket[i][0] == -1) {
                continue;
            }
            if (pre != -1) {
                ans = Math.max(ans, bucket[i][0] - bucket[pre][1]);
            }
            pre = i;
        }
        return ans;
    }

}
