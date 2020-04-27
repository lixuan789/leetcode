package lixuan.math;

/**
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 例如，
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "A"
 */
public class Code168ConvertToTitle {
    /**
     * 即26进制
     *
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        if (n <= 0) {
            return null;
        }
        char[] map = {'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y'};
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(map[n % 26]);
            if (n % 26 == 0) {//用掉个Z减去26
                n -= 26;
            }
            n /= 26;
        }
        return sb.reverse().toString();
    }

    /**
     * 因为是从 1 开始计算的，而不是从 0 开始，因此需要对 n 执行 -1 操作。
     * @param n
     * @return
     */
    public String convertToTitle1(int n) {
        if (n == 0) {
            return "";
        }
        n--;
        return convertToTitle1(n / 26) + (char) (n % 26 + 'A');
    }
}
