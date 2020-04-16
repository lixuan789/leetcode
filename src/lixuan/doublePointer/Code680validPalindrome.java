package lixuan.doublePointer;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 */
public class Code680validPalindrome {
    /**
     * 双指针
     *
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int i = 0, j = s.length() - 1;
        int count = 0;
        boolean flag = true;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                count++;
                if (count > 1) {
                    flag = false;
                }
                i++;
            } else {
                i++;
                j--;
            }

        }
        i = 0;
        j = s.length() - 1;
        count = 0;
        boolean flag1 = true;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                count++;
                if (count > 1) {
                    flag1 = false;
                }
                i++;
            } else {
                i++;
                j--;
            }

        }
        return flag || flag1;
    }


    /**
     * 优化
     *
     * @param s
     * @return
     */
    public boolean validPalindrome1(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                //分两种情况，一是右边减一，二是左边加一
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;

    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

}
