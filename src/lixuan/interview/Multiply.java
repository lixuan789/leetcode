package lixuan.interview;

public class Multiply {
    private int sum;

    /**
     * 递归乘法:利用递归变成加法
     *
     * @param A
     * @param B
     * @return
     */
    public int multiply(int A, int B) {
        if (A == 0 || B == 0) {
            return 0;
        }
        if (A < B) {
            int temp = A;
            A = B;
            B = temp;
        }
        sum = 0;
        dfs(A, B);//保证A>=B
        return sum;
    }

    private void dfs(int a, int b) {
        if (b == 0) {
            return;
        }
        sum += a;
        dfs(a, b - 1);
    }
}
