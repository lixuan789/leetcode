package lixuan.DataStructure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个无向图graph，当这个图为二分图时返回true。
 * 如果我们能将一个图的节点集合分割成两个独立的子集A和B，
 * 并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
 * graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。
 * 每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边：
 *  graph[i] 中不存在i，并且graph[i]中没有重复的值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-graph-bipartite
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code785IsBipartite {
    /**
     * 如果节点属于第一个集合，将其着为蓝色，否则着为红色。只有在二分图的情况下，
     * 可以使用贪心思想给图着色：一个节点为蓝色，说明它的所有邻接点为红色，
     * 它的邻接点的所有邻接点为蓝色，依此类推。
     * dfs染色
     * @param graph
     * @return
     */
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return false;
        }
        int[] color = new int[graph.length];//0代表为找色，1代表蓝色，2代表为红色
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0 && !dfs(i, color, graph, 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int i, int[] color, int[][] graph, int lastColor) {
        if (color[i] != 0) {//已经染色了
            return color[i] != lastColor;
        }
        color[i] = lastColor == 1 ? 2 : 1;
        for (int num : graph[i]) {
            if (!dfs(num, color, graph, color[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * bfs染色
     * @param graph
     * @return
     */
    public boolean isBipartite1(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return false;
        }
        int[] color = new int[graph.length];//0代表为找色，1代表蓝色，2代表为红色
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0) {
                Queue<Integer> queue = new LinkedList<>();
                color[i]=1;
                queue.add(i);
                while (!queue.isEmpty()){
                    Integer poll = queue.poll();
                    for(int next:graph[poll]){
                        if(color[next]==0){//未染色
                            color[next]=color[poll]==1?2:1;
                            queue.add(next);
                        }else if(color[next]==color[poll]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
