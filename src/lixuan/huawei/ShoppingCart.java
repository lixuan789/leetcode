package lixuan.huawei;

import java.util.Scanner;

public class ShoppingCart {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while (input.hasNext()){
            int N=input.nextInt()/10;
            int m=input.nextInt();
            int[] v= new int[m+1];
            int[] p= new int[m+1];
            int[] q= new int[m+1];
            for (int i=1;i<=m;i++){
                v[i]=input.nextInt()/10;
                p[i]=input.nextInt()*v[i];
                q[i]=input.nextInt();
            }
            int[][] dp=new int[m+1][N+1];
            for (int i=1;i<=m;i++){
                for (int j=1;j<=N;j++){
                    if(q[i]==0){//主件
                        if(j>=v[i]){//取或不取
                            dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-v[i]]+p[i]);
                        }
                    }else {//为附件
                        if(v[i]+v[q[i]]<=j){
                            dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-v[i]]+p[i]);
                        }
                    }
                }
            }
            System.out.println(dp[m][N]*10);
        }
    }
}
