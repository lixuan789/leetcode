package lixuan.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，
 * 其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * 注意：
 * 总人数少于1100人。
 * 示例
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code406reconstructQueue {
    /**
     * 思路：先把people数组按k大小排序，相同k的值按h值大小排序。然后依次放入一个整数对，并插入对应位置。
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        int[][] res = new int[people.length][2];
        if (people == null || people.length == 0) {
            return res;
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        res[0] = people[0];
        for (int i = 1; i < people.length; i++) {
            int count = 0;
            int index = 0;
            for (int j = 0; j < i; j++) {
                if (res[j][0] >= people[i][0]) {
                    count++;
                }
                if (count == people[i][1]) {
                    index = j;
                }
            }
            if (index == i - 1) {//插入末尾
                res[i] = people[i];
            } else {//插在中间
                for (int k = i; k > index + 1; k--) {
                    res[k] = res[k - 1];
                }
                res[index + 1] = people[i];
            }
        }
        return res;
    }

    /**
     * 方法二:先排身高更高的，这是要防止后排入人员影响先排入人员位置
     * 每次排入新人员[h,k]时，已处于队列的人身高都>=h，所以新排入位置就是people[k]
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue1(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        List<int[]> list = new LinkedList<>();
        for (int[] p : people)
            list.add(p[1], p);
        return list.toArray(people);
    }
}
