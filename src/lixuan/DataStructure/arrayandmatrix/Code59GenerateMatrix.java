package lixuan.DataStructure.arrayandmatrix;

public class Code59GenerateMatrix {
    /**
     * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] res=new int[n][n];
        int num=1;
        int left=0,right=n-1,up=0,bottom=n-1;
        while (left<right&&up<bottom){
            for (int i=left;i<=right;i++){
                res[up][i]=num++;
            }
            up++;
            for (int i=up;i<=bottom;i++){
                res[i][right]=num++;
            }
            right--;
            for (int i=right;i>=left;i--){
                res[bottom][i]=num++;
            }
            bottom--;
            for (int i=bottom;i>=up;i--){
                res[i][left]=num++;
            }
            left++;
        }
        if (n%2==1){
            res[n/2][n/2]=num;
        }
        return res;
    }

    public static void main(String[] args) {
        Code59GenerateMatrix test = new Code59GenerateMatrix();
        int[][] matrix = test.generateMatrix(5);
        for (int[] temp:matrix){
            for (int num:temp){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}
