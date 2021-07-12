package lixuan.Multithreading;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line=in.nextLine();
        int res=fun(line);
        System.out.println(res);
    }

    private static int fun(String line) {
        int n=line.length();
        char[] chars = line.toCharArray();
        int[] last=new int[128];
        Arrays.fill(last,-1);
        int res=0,start=0;
        for (int i=0;i<n;i++){
            start=Math.max(start,last[chars[i]]+1);
            res=Math.max(res,i-start+1);
            last[chars[i]]=i;
        }
        return res;
    }
}
