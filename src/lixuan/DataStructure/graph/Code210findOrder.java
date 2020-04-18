package lixuan.DataStructure.graph;

import java.util.*;

/**
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，
 * 你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 * 提示:
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code210findOrder {
    /**
     * bfs完成拓扑排序
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        boolean[] visited = new boolean[numCourses];
        int[] pre = new int[numCourses];//保存每个节点的前驱的度
        //构建邻接表
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]][prerequisites[i][1]] = 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int col = 0; col < numCourses; col++) {
            int sum = 0;
            for (int row = 0; row < numCourses; row++) {
                sum += graph[row][col];
            }
            pre[col] = sum;
            if (sum == 0) {
                visited[col] = true;
                queue.add(col);
                list.add(col);
            }
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int col = 0; col < numCourses; col++) {//遍历的节点后继节点消除
                if (graph[poll][col] != 0) {
                    pre[col]--;
                }
            }
            for (int col = 0; col < numCourses; col++) {
                if (!visited[col]) {
                    if (pre[col] == 0) {
                        visited[col] = true;
                        queue.add(col);
                        list.add(col);
                    }
                }
            }
        }
        int[] res = new int[numCourses];
        if (list.size() == numCourses) {//逆序输出
            for (int i = 0; i < numCourses; i++) {
                res[i] = list.get(numCourses - i - 1);
            }
            return res;
        }
        return new int[0];
    }

    /**
     * dfs实现拓扑排序
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        List<Integer>[] graphic = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graphic[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            graphic[pre[0]].add(pre[1]);
        }
        Stack<Integer> postOrder = new Stack<>();
        boolean[] globalMarked = new boolean[numCourses];
        boolean[] localMarked = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(globalMarked, localMarked, graphic, i, postOrder)) {
                return new int[0];
            }
        }
        int[] orders = new int[numCourses];
        for (int i = numCourses - 1; i >= 0; i--) {
            orders[i] = postOrder.pop();
        }
        return orders;
    }

    private boolean hasCycle(boolean[] globalMarked, boolean[] localMarked, List<Integer>[] graphic,
                             int curNode, Stack<Integer> postOrder) {

        if (localMarked[curNode]) {//已经访问过，又进行访问则有环
            return true;
        }
        if (globalMarked[curNode]) {//当前结点后边的结点都被访问过
            return false;
        }
        globalMarked[curNode] = true;
        localMarked[curNode] = true;
        for (int nextNode : graphic[curNode]) {
            if (hasCycle(globalMarked, localMarked, graphic, nextNode, postOrder)) {
                return true;
            }
        }
        localMarked[curNode] = false;
        postOrder.push(curNode);
        return false;
    }
}
