package lixuan.huawei;

import java.util.Scanner;

/**
 * 给定n个字符串，请对n个字符串按照字典序排列。
 */
public class StrSort {
    /**
     * 冒泡排序
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int n = input.nextInt();
            String[] array = new String[n];
            input.nextLine();
            for (int i = 0; i < n; i++) {
                array[i] = input.nextLine();
            }
            for (int i = 0; i < n - 1; i++) {
                boolean flag = true;
                for (int j = n - 1; j >= i + 1; j--) {
                    if (compare(array[j], array[j - 1]) < 0) {
                        swap(array, j, j - 1);
                        flag = false;
                    }
                }
                if (flag) {
                    break;
                }
            }
            for (String str : array) {
                System.out.println(str);
            }
        }
    }

    public static int compare(String str1, String str2) {
        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) < str2.charAt(j)) {
                return -1;
            }
            if (str1.charAt(i) > str2.charAt(j)) {
                return 1;
            }
            i++;
            j++;
        }
        if (i == str1.length() && j < str2.length()) {
            return -1;
        } else if (i < str1.length() && j == str2.length()) {
            return 1;
        }
        return 0;
    }

    public static void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
