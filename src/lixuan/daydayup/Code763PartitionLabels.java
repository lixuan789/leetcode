package lixuan.daydayup;

import java.util.ArrayList;
import java.util.List;

public class Code763PartitionLabels {
    /**
     * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。
     * 返回一个表示每个字符串片段的长度的列表。
     *
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return res;
        }
        int[] last = new int[S.length()];//存储每个字符最后一个相等字符的位置
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = chars.length - 1; j >= i; j--) {
                if (chars[j] == chars[i]) {
                    last[i] = j;
                    break;
                }
            }
        }
        int si = 0;
        while (si < S.length()) {
            int ei = last[si];
            for (int i = si; i <= ei; i++) {
                if (last[i]>ei){
                    ei=last[i];
                }
            }
            res.add(ei - si + 1);
            si = ei + 1;
        }
        return res;
    }

    /**
     * 优化
     * @param S
     * @return
     */
    public List<Integer> partitionLabels1(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return res;
        }
        int[] last = new int[26];//存储每个字符最后一个相等字符的位置
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            last[chars[i]-'a']=i;
        }
        int si = 0;
        while (si < S.length()) {
            int ei = last[chars[si]-'a'];
            for (int i = si; i <= ei; i++) {
                if (last[chars[i]-'a']>ei){
                    ei=last[chars[i]-'a'];
                }
            }
            res.add(ei - si + 1);
            si = ei + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Code763PartitionLabels test = new Code763PartitionLabels();
        List<Integer> list = test.partitionLabels("eaaaabaaec");
        System.out.println(list);
    }
}
