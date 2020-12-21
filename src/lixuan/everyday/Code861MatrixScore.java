package lixuan.everyday;

/**
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * 返回尽可能高的分数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-after-flipping-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code861MatrixScore {
    public int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        //将第一个数字为0的所在行进行移动
        for (int row = 0; row < m; row++) {
            if (A[row][0] == 0) {
                for (int j = 0; j < n; j++) {
                    A[row][j] = 1 - A[row][j];
                }
            }
        }
        //计算每一列中0的个数
        int[] cnt = new int[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (A[i][j] == 0) {
                    cnt[j]++;
                }
            }
        }
        int sum = (int) (m * (Math.pow(2, n) - 1));
        //某一列包含0的个数大于一半，则可以进行移动
        for (int j = 0; j < n; j++) {
            if (cnt[j] > m / 2) {
                cnt[j] = m - cnt[j];//更新0个数
            }
            int num = (int) Math.pow(2, n - j - 1);
            sum -= cnt[j] * num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] A={{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        Code861MatrixScore score = new Code861MatrixScore();
        int sum = score.matrixScore(A);
        System.out.println(sum);
    }
}
