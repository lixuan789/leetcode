package lixuan.daydayup;

import java.util.HashMap;
import java.util.List;

/**
 * 你的面前有一堵方形的、由多行砖块组成的砖墙。 这些砖块高度相同但是宽度不同。
 * 你现在要画一条自顶向下的、穿过最少砖块的垂线
 * 砖墙由行的列表表示。 每一行都是一个代表从左至右每块砖的宽度的整数列表。
 * 如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你需要找出怎样画才能使这条线穿过的砖块数量最少，
 * 并且返回穿过的砖块数量。
 * 你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/brick-wall
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code554LeastBricks {
    /**
     * 使用hashmap记录每个可能缝隙的数量，最小的穿过的砖块数量为高度-最大的缝隙数量
     * 判断缝隙：每列从第一项开始的和
     *
     * @param wall
     * @return
     */
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int res = Integer.MIN_VALUE;//最大的缝隙数量
        for (List<Integer> list : wall) {
            int sum = 0;
            for (int i=0;i<list.size()-1;i++){//每列最后一项不算
                sum += list.get(i);
                count.put(sum, count.getOrDefault(sum, 0) + 1);
                int temp = count.get(sum);
                if (temp > res) {
                    res = temp;
                }
            }
        }
        int high = wall.size();
        return high - res;
    }
}
