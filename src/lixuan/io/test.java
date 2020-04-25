package lixuan.io;


import java.util.Arrays;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while (input.hasNext()){
            int m=input.nextInt();
            int[] nums=new int[m];
            for (int i=0;i<m;i++){
                nums[i]=input.nextInt();
            }
            System.out.println(Arrays.toString(nums));
        }
        input.close();
    }

}
