package lixuan.DataStructure.arrayandmatrix;

/**
 * 如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
 * 给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/toeplitz-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code766isToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < col; i++) {
            int j = 0;//第一行
            int k = i;//列
            int temp = matrix[j][k];
            while (j < row && k < col) {
                if (matrix[j][k] != temp) {
                    return false;
                }
                j++;
                k++;
            }
        }
        for (int i = 1; i < row; i++) {
            int j = i;//行
            int k = 0;//第一列
            int temp = matrix[j][k];
            while (j < row && k < col) {
                if (matrix[j][k] != temp) {
                    return false;
                }
                j++;
                k++;
            }
        }
        return true;
    }
}
