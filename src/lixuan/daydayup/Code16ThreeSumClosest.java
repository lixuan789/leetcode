package lixuan.daydayup;

import java.util.Arrays;

public class Code16ThreeSumClosest {
    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
     * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
     * 返回这三个数的和。假定每组输入只存在唯一答案。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum-closest
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        boolean flag = false;
        for (int i = 0; i < nums.length - 2; i++) {
            int sum = target - nums[i];
            int s = i + 1;
            int e = nums.length - 1;
            while (s < e) {
                int num = nums[s] + nums[e];
                if (num < sum) {
                    if (ans>(sum-num)){
                        ans = (sum - num);
                        flag = false;
                    }
                    s++;
                } else if (num == sum) {
                    return target;
                } else {
                    if (ans>(num-sum)){
                        ans = (num - sum);
                        flag = true;
                    }
                    e--;
                }
            }
        }
        if (flag) {//ans=num-sum=(b+c)-(target-a)=a+b+c--target
            return target + ans;
        } else {//ans=sum-num=target-(a+b+c)
            return target - ans;
        }
    }
}
