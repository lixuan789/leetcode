package lixuan.interview;

import java.util.Stack;

public class FindClosedNumbers {
    public int[] findClosedNumbers(int num) {
        int num1=0;
        int num2=0;
        Stack<Integer> stack=new Stack<>();
        while (num!=0){
            stack.push(num%2);
            num/=2;
        }
        int[] next=new int[stack.size()];//找下一个数
        int[] pre=new int[stack.size()];//找上一个数
        int index=0;
        while (!stack.isEmpty()){
            next[index++]=stack.pop();
            pre[index++]=stack.pop();
        }
        //找下一个数：从左往右找到第一个01的数，将01变成10并且将之后1从左往右填
        int j=next.length-1;
        for (;j>0;j--){
            if (next[j]==1&&next[j-1]==0){
                break;
            }
        }
        boolean isAdd=false;
        if (j==0){
            if (next.length>=31){
                num1=-1;
            }else {
                next[j]=0;
                int zero=0;
                for (int i=j+1;i<next.length;i++){
                    if (next[i]==0){
                        zero++;
                    }
                }
                for (int i=0;i<zero;i++){
                    next[j+1+i]=0;
                }
                j=j+zero+1;
                for (;j<next.length;j++){
                    next[j]=1;
                }
                int sum= 0;
                for (int i=0;i<next.length;i++){
                    sum=2*sum+next[i];
                }
                sum+=(int) Math.pow(2,next.length);
                num1=sum;
            }
        }
        return null;

    }
}
