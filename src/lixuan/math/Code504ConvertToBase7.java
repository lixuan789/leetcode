package lixuan.math;

import java.util.Stack;

/**
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 100
 * 输出: "202"
 * 示例 2:
 * <p>
 * 输入: -7
 * 输出: "-10"
 */
public class Code504ConvertToBase7 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "";
        }
        boolean flag = false;//false为负，true为正
        if (num > 0) {
            flag = true;
        }
        num = Math.abs(num);
        Stack<Integer> stack = new Stack<>();
        while (num != 0) {
            stack.push(num % 7);
            num /= 7;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + "");
        }
        if (flag == false) {
            return "-" + sb.toString();
        }
        return sb.toString();
    }
}
