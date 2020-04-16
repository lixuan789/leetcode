package lixuan.math;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 */
public class Code172TrailingZeroes {
    /**
     * 有多少个5
     *尾部的 0 由 2 * 5 得来，2 的数量明显多于 5 的数量，因此只要统计有多少个 5 即可。
     *
     * 对于一个数 N，它所包含 5 的个数为：N/5 + N/5^2 + N/5^3 + ...，
     * 其中 N/5 表示不大于 N 的数中 5 的倍数贡献一个 5，N/52 表示不大于 N 的数中 52 的倍数
     * 再贡献一个 5 ...。
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int res = 0;
        while (n != 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}
