package lixuan.test.test4;

import java.util.Arrays;
import java.util.Scanner;

public class Sort {

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] arr = new int[n];

        int[] sortArr = new int[n];

        for (int i = 0; i < n; i++) {

            arr[i] = scan.nextInt();

            sortArr[i] = arr[i];

        }

        Arrays.sort(sortArr);

        int count = 0;

        int j = 0;

        for (int i = 0; i < n; i++) {

            if (arr[i] == sortArr[j]) {

                count++;

                j++;

            }

        }

        System.out.println(n - count);

    }
}
