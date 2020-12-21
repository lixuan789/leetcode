package lixuan.everyday;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */
public class Code57Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];//合并数组左边界
        int right = newInterval[1];//合并数组右边界
        List<int[]> list = new ArrayList<>();
        boolean flag = true;//是否未添加合并的数组，true为未添加
        for(int i = 0;i < intervals.length;++i){
            if(intervals[i][0] > right){//在右边，不和合并数组重合
                if(flag){//因为在合并数组右边，如果没添加合并数组则先添加合并数组，仅添加一次
                    list.add(new int[]{left,right});
                    flag = false;
                }
                list.add(intervals[i]);
            }
            if(intervals[i][1] < left){//在合并数组左边，可添加
                list.add(intervals[i]);
            }
            if(intervals[i][0] <= left && intervals[i][1] >= left){//left处于数组中，可更新left
                left = intervals[i][0];
            }
            if(intervals[i][0] <= right && intervals[i][1] >= right){//right处于数组中，可更新right
                right = intervals[i][1];
            }
        }
        if(list.size() == 0 || flag){//如果list为空，或者合并数组还未添加，则添加合并数组。这种情况可能是intervals为空，或者合并数组在整个数组的右边。
            list.add(new int[]{left,right});
        }
        int[][] res = new int[list.size()][2];
        for(int i = 0;i < list.size();++i){
            res[i] = list.get(i);
        }
        return res;
    }
}
