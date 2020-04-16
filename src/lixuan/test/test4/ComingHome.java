package lixuan.test.test4;

import java.util.Scanner;

public class ComingHome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n - 2; i++) {
            int sum = 0;
            for (int j = 1; j < n; j++) {
                if (j != i) {
                    sum += Math.abs(array[j] - array[j - 1]);
                } else if (j < n - 1) {
                    sum += Math.abs(array[j + 1] - array[j - 1]);
                    j++;
                }
            }
            res = Math.min(res, sum);
        }
        System.out.println(res);
    }
}
