package lixuan.math;

/**
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * <p>
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code367IsPerfectSquare {
    /**
     * 利用 1+3+5+7+9+…+(2n-1)=n^2，即完全平方数肯定是前n个连续奇数的和
     */
    public boolean isPerfectSquare(int num) {
        int num1 = 1;
        while (num > 0) {
            num -= num1;
            num1 += 2;
        }
        return num == 0;
    }

    /**
     * 牛顿迭代法，f(x)=x²-num
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare1(int num) {
        if (num < 2) return true;
        long x = num;
        while (x * x > num) {
            x = (x + num / x) / 2;
            if (x * x == num) {
                return true;
            }
        }
        return false;
    }

}
