package lixuan.dp;

public class NumArray {
    private int[][] dp;
    public NumArray(int[] nums) {
        NumArray obj = new NumArray(nums);
        int n=nums.length;
        this.dp=new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                if(j==i){
                    dp[i][j]=nums[j];
                }else {
                    dp[i][j]=dp[i][j-1]+nums[j];
                }
            }
        }
    }

    public int sumRange(int i, int j) {
        return dp[i][j];
    }

    /*private int[] dp;

    public NumArray(int[] nums) {
        int n=nums.length;
        dp = new int[n];
        dp[0]=nums[0];
        for (int i = 0; i < n; i++) {
            dp[i] = dp[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(i==0){
            return dp[j];
        }
        return dp[j] - dp[i-1];
    }*/


}
