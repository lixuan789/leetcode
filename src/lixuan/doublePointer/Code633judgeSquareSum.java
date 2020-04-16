package lixuan.doublePointer;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a² + b² = c。
 */
public class Code633judgeSquareSum {
    /**
     * 本题的关键是右指针的初始化，实现剪枝，从而降低时间复杂度。设右指针为 x，左指针固定为 0，
     * 为了使 02 + x2 的值尽可能接近 target，我们可以将 x 取为 sqrt(target)。
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        int low = 0, high = (int) Math.sqrt(c) ;
        while (low <= high) {
            int num = low * low + high * high;
            if (num == c) {
                return true;
            } else if (num < c) {
                low++;
            } else {
                high--;
            }
        }
        return false;
    }

}
