package lixuan.test.test4;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] array = new int[n+1][4];
        for (int i = 0; i <= n; i++) {
            String str = input.nextLine();
            String[] s = str.split(" ");
            if (s[0].equals("R")) {
                array[i][0] = 1;
                for (int j = 1; j < 4; j++) {
                    array[i][j] = Integer.parseInt(s[j]);
                }
            }
            if (s[0].equals("G")) {
                array[i][0] = 2;
                for (int j = 1; j < 4; j++) {
                    array[i][j] = Integer.parseInt(s[j]);
                }
            }
            if (s[0].equals("B")) {
                array[i][0] = 3;
                for (int j = 1; j < 4; j++) {
                    array[i][j] = Integer.parseInt(s[j]);
                }
            }
        }
        double res = Integer.MIN_VALUE;
        for (int a = 1; a < n - 1; a++) {
            for (int b = a + 1; b < n; b++) {
                for (int c = b + 1; c < n+1; c++) {
                    if (array[a][0] == array[b][0] && array[a][0] == array[c][0]) {
                        double x = SideLength(array[a], array[b]);
                        double y = SideLength(array[a], array[c]);
                        double z = SideLength(array[b], array[c]);
                        if (x + y > z && x + z > y && y + z > x) {
                            double p = (x + y + z) / 2;
                            double temp = Math.sqrt(p * (p - x) * (p - y) * (p - z));
                            res = Math.max(res, temp);
                        }
                    } else if (array[a][0] != array[b][0] && array[a][0] != array[c][0] && array[b][0] != array[c][0]) {
                        double x = SideLength(array[a], array[b]);
                        double y = SideLength(array[a], array[c]);
                        double z = SideLength(array[b], array[c]);
                        if (x + y > z && x + z > y && y + z > x) {
                            double p = (x + y + z) / 2;
                            double temp = Math.sqrt(p * (p - x) * (p - y) * (p - z));
                            res = Math.max(res, temp);
                        }
                    }
                }
            }
        }
        System.out.printf("%.5f",res);
    }

    private static double SideLength(int[] x, int[] y) {
        double sum = (x[1] - y[1]) * (x[1] - y[1]) + (x[2] - y[2]) * (x[2] - y[2]) + (x[3] - y[3]) * (x[3] - y[3]);
        return Math.sqrt(sum);
    }
}
