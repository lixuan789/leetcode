package lixuan.math;

import java.util.Stack;

/**
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 * <p>
 * 注意:
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，
 * 十六进制字符串中的第一个字符将不会是0字符。 
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * 示例 1：
 * <p>
 * 输入:
 * 26
 * <p>
 * 输出:
 * "1a"
 * 示例 2：
 * <p>
 * 输入:
 * -1
 * <p>
 * 输出:
 * "ffffffff"
 */
public class Code405ToHex {
    /**
     * 先装换为二进制
     *
     * @param num
     * @return
     */
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        String[] strings = {"a", "b", "c", "d", "e", "f"};
        long max = (long) Math.pow(2, 32);
        long a = num;
        if (num < 0) {
            a = max + num;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        while (a != 0) {
            sb.append(a % 2);
            a /= 2;
        }
        int len = sb.length();
        int count = len / 4;
        int index = 0;
        for (int i = 0; i < count; i++) {
            int temp = 0;
            int carry = 1;
            for (int j = index; j <= index + 3; j++) {
                temp += carry * (sb.charAt(j) - '0');
                carry *= 2;
            }
            if (temp < 10) {
                res.append(temp);
            } else {
                res.append(strings[temp - 10]);
            }
            index += 4;
        }
        int tail = 0;
        int carry = 1;
        for (int i = index; i < len; i++) {
            tail += carry * (sb.charAt(i) - '0');
            carry *= 2;
        }
        if (len % 4 != 0) {
            if (tail < 10) {
                res.append(tail);
            } else {
                res.append(strings[tail - 10]);
            }
        }
        return res.reverse().toString();
    }

    public String toHex1(int num) {
        if (num == 0) return "0";
        String hex = "0123456789abcdef", ans = "";
        while (num != 0 && ans.length() < 8) {
            ans = hex.charAt(num & 0xf) + ans;
            num >>>= 4;
        }
        return ans;
    }

    public static void main(String[] args) {
        Code405ToHex toHex = new Code405ToHex();
        String s = toHex.toHex(-1);
        System.out.println(s);
    }
}
