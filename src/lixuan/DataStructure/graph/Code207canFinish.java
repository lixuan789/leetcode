package lixuan.DataStructure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，
 * 你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code207canFinish {
    /**
     * 先构建有向图的邻接表，再进行拓扑排序：依次遍历无前驱的节点，在邻接表中的表现是该列都为0
     * 超时
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        boolean[] visited = new boolean[numCourses];
        //构建邻接表
        for (int i = 0; i < prerequisites.length; i++) {
            /*int last = prerequisites[i][prerequisites[i].length - 1];
            for (int j = 0; j < prerequisites[i].length - 1; j++) {
                graph[prerequisites[i][j]][last] = 1;
            }*/
            graph[prerequisites[i][0]][prerequisites[i][1]] = 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        int num = 0;//可以遍历的个数
        for (int col = 0; col < numCourses; col++) {
            boolean flag = true;//一列是否全部为0
            for (int row = 0; row < numCourses; row++) {
                if (graph[row][col] != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                visited[col] = true;
                queue.add(col);
                num++;
            }
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int col = 0; col < numCourses; col++) {//遍历的节点后继节点消除
                graph[poll][col] = 0;
            }
            for (int col = 0; col < numCourses; col++) {
                if (!visited[col]) {
                    boolean flag = true;//一列是否全部为0
                    for (int row = 0; row < numCourses; row++) {
                        if (graph[row][col] != 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        visited[col] = true;
                        queue.add(col);
                        num++;
                    }
                }
            }
        }
        return num == numCourses;
    }

    /**
     * 优化，用一个数组保持每个节点的前驱的度
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        boolean[] visited = new boolean[numCourses];
        int[] pre = new int[numCourses];//保存每个节点的前驱的度
        //构建邻接表
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]][prerequisites[i][1]] = 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        int num = 0;//可以遍历的个数
        for (int col = 0; col < numCourses; col++) {
            int sum = 0;
            for (int row = 0; row < numCourses; row++) {
                sum += graph[row][col];
            }
            pre[col] = sum;
            if (sum == 0) {
                visited[col] = true;
                queue.add(col);
                num++;
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
                        num++;
                    }
                }
            }
        }
        return num == numCourses;
    }
}
