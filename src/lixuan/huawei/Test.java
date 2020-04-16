package lixuan.huawei;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] count = new int[4];
        while (input.hasNextLine()) {
            String s = input.nextLine();
            char[] array = s.toCharArray();
            for (char c : array) {
                if (c >= '0' && c <= '9') {
                    count[0] = 1;
                } else if (c >= 'a' && c <= 'z') {
                    count[1] = 1;
                } else if (c >= 'A' && c <= 'Z') {
                    count[2] = 1;
                } else {
                    count[3] = 1;
                }
            }
            int typeNum = 0;
            for (int i = 0; i < 4; i++) {
                typeNum += count[i];
            }
            int len = s.length();
            int num = 0;//相同的个数
            for (int i = 0; i <= len - 6; i++) {
                for (int j = i + 3; j <= len - 3; j++) {
                    if (array[i] == array[j] && array[i + 1] == array[j + 1] && array[i + 2] == array[j + 2]) {
                        num++;
                        break;
                    }
                }
                if (num != 0) {
                    break;
                }
            }
            if (len >= 9 && typeNum >= 3 && num == 0) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
    }
}
