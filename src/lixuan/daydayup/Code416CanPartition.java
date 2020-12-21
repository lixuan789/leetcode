package lixuan.daydayup;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class Code416CanPartition {
    public boolean canPartition(int[] nums) {
        if (nums==null||nums.length==0){
            return true;
        }
        int sum=0;
        for (int num:nums){
            sum+=num;
        }
        if ((sum&1)==1){
            return false;
        }
        sum/=2;
        boolean[] dp=new boolean[sum+1];
        dp[0]=true;
        for (int i=0;i<nums.length;i++){
            for (int j=sum;j>=nums[i];j--){
               dp[j]=dp[j]||dp[j-nums[i]];
            }
        }
        return dp[sum];
    }
}
