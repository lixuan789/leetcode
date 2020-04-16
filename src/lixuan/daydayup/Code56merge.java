package lixuan.daydayup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code56merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; ) {
            int[] temp = intervals[i];
            while (i < intervals.length && intervals[i][0] <= temp[1]) {//在区间内
                temp[1] = Math.max(temp[1], intervals[i][1]);
                i++;
            }
            res.add(temp);
        }
        int n = res.size();
        int[][] ans = new int[n][2];
        for (int i = 0; i < n; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
