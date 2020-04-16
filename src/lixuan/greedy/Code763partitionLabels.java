package lixuan.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，
 * 同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * 示例 1:
 * 输入: S = "ababcbacadefegdehijhklij"
 * 输出: [9,7,8]
 * 解释:
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code763partitionLabels {
    /**
     * 用一个数组记录每个字母后面是否有与之相等的字母
     * 有的话就存入下一个最后相等字母的位置，没有就为-1
     *
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return res;
        }
        int[] pos = new int[S.length()];
        for (int i = S.length() - 1; i >= 0; i--) {
            int nextPos = -1;
            for (int j = S.length() - 1; j >= i + 1; j--) {
                if (S.charAt(j) == S.charAt(i)) {
                    nextPos = j;
                    break;
                }
            }
            pos[i] = nextPos;
        }
        int start = 0;
        while (start < S.length()) {
            int index = start;
            int end = pos[start];
            if (end == -1) {//只有一个元素
                res.add(1);
            } else {
                while (start < end) {
                    start++;
                    end = Math.max(pos[start], end);//可以往后延长的最大距离
                }
                int len = end - index + 1;
                res.add(len);
            }
            start++;
        }
        return res;
    }

    /**
     * 只需记录每个字母最后的位置
     * @param S
     * @return
     */
    public List<Integer> partitionLabels1(String S) {
        int[] lastIndexsOfChar = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndexsOfChar[char2Index(S.charAt(i))] = i;
        }
        List<Integer> partitions = new ArrayList<>();
        int firstIndex = 0;
        while (firstIndex < S.length()) {
            int lastIndex = firstIndex;
            for (int i = firstIndex; i < S.length() && i <= lastIndex; i++) {
                int index = lastIndexsOfChar[char2Index(S.charAt(i))];
                if (index > lastIndex) {
                    lastIndex = index;
                }
            }
            partitions.add(lastIndex - firstIndex + 1);
            firstIndex = lastIndex + 1;
        }
        return partitions;
    }

    private int char2Index(char c) {
        return c - 'a';
    }

}
