package lixuan.daydayup;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code300LengthOfLIS {
    /**方法一：
     * 动态规划：令dp[i]为第i个位置升序子序列的长度
     * 转移方程：dp[i]=max(dp[j]+1,1);其中0<=j<i
     *          1.num[i]>num[j]时，dp[j]+1
     *          2.不存在num[i]>num[j]时，长度为自身
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        if(n==0){
            return 0;
        }
        int[] dp=new int[n];//dp[i]为第i个位置升序子序列的长度
        int res=0;
        dp[0]=1;
        for (int i=1;i<n;i++){
            int maxNum=Integer.MIN_VALUE;
            for (int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    maxNum=Math.max(maxNum,dp[j]+1);
                }
            }
            dp[i]=Math.max(maxNum,1);
        }
        for (int i=0;i<n;i++){
            res=Math.max(res,dp[i]);
        }
        return res;
    }

    /**
     * 方法二：动态规划、贪心算法+二分查找
     * 如果已经得到的上升子序列的结尾的数越小，遍历的时候后面接上一个数，
     * 就会有更大的可能性构成一个更长的上升子序列。
     * 状态：tail[i] 表示长度为 i + 1 的所有最长上升子序列的结尾的最小值。
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }
        int[] tail=new int[nums.length];
        tail[0]=nums[0];
        int len=0;
        for (int i=1;i<nums.length;i++){
            if(nums[i]>tail[len]){
                len++;
                tail[len]=nums[i];
            }else {
                int low=0,high=len;
                while (low<high){
                    int mid=low+(high-low)/2;
                    if(tail[mid]<nums[i]){
                        low=mid+1;
                    }else {
                        high=mid;
                    }
                }
                tail[high]=nums[i];
            }
        }
        len++;
        return len;

    }

    public static void main(String[] args) {
        Code300LengthOfLIS code300LengthOfLIS = new Code300LengthOfLIS();
        int nums[]={10,9,2,5,3,4};
        int i = code300LengthOfLIS.lengthOfLIS1(nums);
        System.out.println(i);
    }


}
