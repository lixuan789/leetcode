package lixuan.daydayup;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 */
public class Code8myAtoi {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int index = 0;
        while (index < chars.length && chars[index] == ' ') {
            index++;
        }//第一个数字
        if (index == chars.length) {//全是空字符
            return 0;
        }
        if ((chars[index] < '0' || chars[index] > '9') && chars[index] != '+' && chars[index] != '-') {//不是数字但不是+-符号
            return 0;
        }
        boolean flag = true;//false为负，true为正
        if (chars[index] == '-') {
            flag = false;
            index++;
        } else if (chars[index] == '+') {
            index++;
        }
        int num = 0;
        while (index < chars.length && chars[index] >= '0' && chars[index] <= '9') {
            if (flag == true) {//为正
                int temp = chars[index] - '0';
                if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && temp >= Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                }
                num = num * 10 + temp;
            } else {//为负
                int temp = -(chars[index] - '0');
                if (num < Integer.MIN_VALUE / 10 || (num == Integer.MIN_VALUE / 10 && temp <= Integer.MIN_VALUE % 10)) {
                    return Integer.MIN_VALUE;
                }
                num = num * 10 + temp;
            }
            index++;
        }
        return num;
    }

    public static void main(String[] args) {
        Code8myAtoi myAtoi = new Code8myAtoi();
        int num = myAtoi.myAtoi("-2147483647");
        System.out.println(num);
    }
}
