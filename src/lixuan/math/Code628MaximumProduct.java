package lixuan.math;

/**
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: 24
 */
public class Code628MaximumProduct {
    /**
     * 找到最大的三个数
     *
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        int one = Integer.MIN_VALUE;
        int two = Integer.MIN_VALUE;
        int three = Integer.MIN_VALUE;
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;//最小的2个负数
        for (int num : nums) {
            if (num > one) {
                if (num <= two) {
                    one = num;
                }
                if (num > two && num <= three) {
                    one = two;
                    two = num;
                }
                if (num > three) {
                    one = two;
                    two = three;
                    three = num;
                }
            }
            if (num < 0) {
                if (num <= b) {
                    a = b;
                    b = num;
                }
                if (num > b && num <= a) {
                    a = num;
                }
            }
        }
        int num1 = one * two * three;
        int num2 = Integer.MIN_VALUE;
        if (a < 0 && b < 0 && three > 0) {
            num2 = a * b * three;
        }
        return Math.max(num1, num2);
    }

    public int maximumProduct1(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
    }
}
