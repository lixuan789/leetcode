package lixuan.DataStructure.arrayandmatrix;


import java.util.HashSet;

/**
 * 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。
 * 找到并返回最大的集合S，S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
 * 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，
 * 之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/array-nesting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code565ArrayNesting {
    class UF {
        public int count;//连通分量的个数
        public int[] parent;//存储一个树
        public int[] size;//树中节点的个数

        public UF(int n) {
            this.count = n;
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (size[rootP] > size[rootQ]) {//为了树平衡，小树加到大树中
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        private int find(int x) {
            while (parent[x] != x) {
                //路劲压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public int count() {
            return count;
        }
    }

    /**
     * 方法一：并查集
     *
     * @param nums
     * @return
     */
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        UF uf = new UF(n);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int root = nums[i];
            int j = i;
            while (!uf.connected(nums[j], nums[nums[j]])) {
                uf.union(nums[j], nums[nums[j]]);
                nums[j] = nums[nums[j]];
            }
            max = Math.max(max, uf.size[root]);
        }
        return max;
    }

    /**
     * 方法二
     *
     * @param nums
     * @return
     */
    public int arrayNesting1(int[] nums) {
        int max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (!set.contains(nums[j])) {
                set.add(nums[j]);
                nums[j] = nums[nums[j]];
            }
            max = Math.max(max, set.size());
            set.clear();
        }
        return max;
    }

    public static void main(String[] args) {
        Code565ArrayNesting nesting = new Code565ArrayNesting();
        int[] a = {5, 4, 0, 3, 1, 6, 2};
        int i = nesting.arrayNesting(a);
        System.out.println(i);
    }
}
