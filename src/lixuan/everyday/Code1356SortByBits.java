package lixuan.everyday;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * <p>
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 * <p>
 * 请你返回排序后的数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code1356SortByBits {
    public int[] sortByBits(int[] arr) {
        List<Integer>[] buket = new ArrayList[15];
        for (int num : arr) {
            int count = count(num);
            if (buket[count] == null) {
                buket[count] = new ArrayList<>();
            }
            buket[count].add(num);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            if (buket[i] != null) {
                Collections.sort(buket[i]);
                list.addAll(buket[i]);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private int count(int num) {
        int cnt = 0;
        while (num > 0) {
            cnt = (num & 1) != 0 ? cnt + 1 : cnt;
            num >>= 1;
        }
        return cnt;
    }
}
