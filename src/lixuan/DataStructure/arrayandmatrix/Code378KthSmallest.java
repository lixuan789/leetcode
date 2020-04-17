package lixuan.DataStructure.arrayandmatrix;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 */
public class Code378KthSmallest {
    /**
     * 二分查找
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int lo = matrix[0][0];//最小值
        int hi = matrix[m - 1][n - 1];//最大值
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int cnt = countMid(matrix, mid);//查找小于等于mid的个数
            if (cnt < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    /**
     * 在有序的二维数组中查找小于等于mid的元素个数
     *
     * @param matrix
     * @param target
     * @return
     */
    private int countMid(int[][] matrix, int target) {
        int count = 0;
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            int lo = col;
            int hi = matrix[0].length;
            while (lo < hi) {//找到每一行最后一个大于等于target的元素位置，即找到第一个大于target的数位置
                int mid = lo + (hi - lo) / 2;
                if (matrix[row][mid] > target) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            int num = (lo - col) * (row + 1);
            count += num;
            col = lo;
            row--;
        }
        return count;
    }

    /**
     * 使用大顶推求第k个数
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest1(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });//大顶堆
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maxHeap.add(matrix[i][j]);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }
        return maxHeap.peek();
    }
}
