package lixuan.everyday;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * <p>
 * （这里，平面上两点之间的距离是欧几里德距离。）
 * <p>
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code973KClosest {
    /**
     * 暴力法
     *
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] point : points) {
            int distinct = (int) (Math.pow(point[0], 2) + Math.pow(point[1], 2));
            if (!map.containsKey(distinct)) {
                map.put(distinct, new ArrayList<>());
            }
            map.get(distinct).add(point);
        }
        Set<Integer> keySet = map.keySet();
        List<Integer> list = new ArrayList<>(keySet);
        Collections.sort(list);
        int[][] ans = new int[K][];
        int index = 0;
        for (int key : list) {
            if (!map.containsKey(key)) {
                continue;
            }
            for (int i = 0; i < map.get(key).size(); i++) {
                if (index >= K) {
                    break;
                }
                ans[index++] = map.get(key).get(i);
            }
        }
        return ans;
    }

    /**
     * 小顶堆
     *
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest1(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return pow(o2) - pow(o1);
            }
        });
        for (int[] point : points) {
            queue.offer(point);
            if (queue.size() > K) {
                queue.poll();
            }
        }
        int[][] ans = new int[K][];
        int index = 0;
        while (!queue.isEmpty()) {
            ans[index++] = queue.poll();
        }
        return ans;
    }

    private int pow(int[] o1) {
        return (int) (Math.pow(o1[0], 2) + Math.pow(o1[1], 2));
    }

    Random rand = new Random();
    public int[][] kClosest2(int[][] points, int K) {
        int n=points.length;
        qsort(points,0,n-1,K);
        return Arrays.copyOfRange(points,0,K);
    }

    private void qsort(int[][] points, int left, int right, int k) {
        if (left>right){
            return;
        }
        int priotId=left+rand.nextInt(right-left+1);
        int priot=points[priotId][0]*points[priotId][0]+points[priotId][1]*points[priotId][1];
        swap(points,priotId,right);
        int i=left-1;
        for (int j=left;j<right;j++){
            int dis=points[j][0]*points[j][0]+points[j][1]*points[j][1];
            if (dis<priot){
                ++i;
                swap(points,i,j);
            }
        }
        ++i;
        swap(points,i,right);
        if (i < k) {
            qsort(points,i+1,right,k);
        } else if (i > k) {
            qsort(points,left,i-1,k);
        }
    }

    public void swap(int[][] points,int i,int j){
        int[] temp=points[i];
        points[i]=points[j];
        points[j]=temp;
    }
}
