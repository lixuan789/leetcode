package lixuan.math;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 */
public class Code67AddBinary {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int numa = 0, numb = 0;
            if (i >= 0) {
                numa = a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                numb = b.charAt(j) - '0';
                j--;
            }
            int num = numa + numb + carry;
            carry = num / 2;
            num %= 2;
            sb.append(num);
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
