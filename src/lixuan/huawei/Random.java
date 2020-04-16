package lixuan.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class Random {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int n = input.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = input.nextInt();
            }
            Arrays.sort(array);
            for (int i = 0; i < n; i++) {
                if (i == 0 || array[i] != array[i - 1]) {
                    System.out.println(array[i]);
                }
            }
        }
    }
}
