package lixuan.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Code406ReconstructQueue {
    /**
     * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，
     * 其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
     * <p>
     * 注意：
     * 总人数少于1100人。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int[] item : people) {
            list.add(item[1], item);
        }
        for (int i = 0; i < people.length; i++) {
            people[i] = list.get(i);
        }
        return people;
    }
}
