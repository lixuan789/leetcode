package lixuan.daydayup;

public class Code977SortedSquares {
    /**
     * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
     *
     */
    public int[] sortedSquares(int[] A) {
        if (A==null||A.length==0){
            return new int[0];
        }
        int left=0,right=A.length-1;
        int[] nums=new int[A.length];
        int index=right;
        while (index>=0){
            int a=A[left]*A[left];
            int b=A[right]*A[right];
            if (a>b){
                nums[index--]=a;
                left++;
            }else {
                nums[index--]=b;
                right--;
            }
        }
        return nums;
    }
}
