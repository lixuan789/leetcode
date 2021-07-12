package lixuan.math;

public class Code50Pow {
    /**
     * 快速幂
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        boolean flag = false;
        if (n < 0) {
            flag = true;
            n = -n;
        }
        double res = 1.0;
        while (n > 0) {
            if ((n & 1) == 1) {
                res *= x;
            }
            x *= x;
            n >>= 1;
        }
        return flag ? 1 / res : res;
    }
}
