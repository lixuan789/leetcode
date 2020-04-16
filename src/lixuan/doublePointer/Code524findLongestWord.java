package lixuan.doublePointer;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
 * 如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * <p>
 * 输出:
 * "apple"
 */
public class Code524findLongestWord {
    public String findLongestWord(String s, List<String> d) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int maxLen = Integer.MIN_VALUE;
        Collections.sort(d);
        String res = "";
        for (String str : d) {
            if (str.length() > maxLen) {
                //子序列判断
                if (isSubsequence(s, str)) {
                    res = str;
                    maxLen = str.length();
                }
            }
        }
        return res;

    }

    /**
     * 使用双指针进行判断
     * @param s
     * @param str
     * @return
     */
    private boolean isSubsequence(String s, String str) {
        int i = 0, j = str.length() - 1;
        int low = 0, high = s.length() - 1;
        int count = 0;
        while (i <= j && low <= high) {
            if (str.charAt(i) == s.charAt(low) && i <= j && low <= high) {
                low++;
                i++;
                count++;
            } else {
                low++;
            }
            if (str.charAt(j) == s.charAt(high) && i <= j && low <= high) {
                j--;
                high--;
                count++;
            } else {
                high--;
            }

        }
        return count == str.length();
    }

//-----------------------------------------------------------------------------------

    /**
     * 方法二
     * @param s
     * @param d
     * @return
     */
    public String findLongestWord1(String s, List<String> d) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int maxLen = Integer.MIN_VALUE;
        String res = "";
        for (String str : d) {
            if (str.length() > maxLen||(str.length()==maxLen&&res.compareTo(str)>0)) {
                //子序列判断
                if (isSubstr(s, str)) {
                    res = str;
                    maxLen = str.length();
                }
            }
        }
        return res;

    }

    private boolean isSubstr(String s, String str) {
        int i=0,j=0;
        while (i<s.length()&&j<str.length()){
            if(s.charAt(i)==str.charAt(j)){
                j++;
            }
            i++;
        }
        return j==str.length();
    }
}
