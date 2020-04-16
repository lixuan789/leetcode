package lixuan.DataStructure.string;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class Code9IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int Original = x;
        int res = 0;
        while (x != 0) {
            int temp = x % 10;
            res = res * 10 + temp;
            x /= 10;
        }
        return res == Original;
    }

    /**
     * 优化：将整数分成左右两部分，右边那部分需要转置，然后判断这两部分是否相等。
     * @param x
     * @return
     */
    public boolean isPalindrome1(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int right = 0;
        while (x > right) {
            right = right * 10 + x % 10;
            x /= 10;
        }
        return x == right || x == right / 10;
    }
}
