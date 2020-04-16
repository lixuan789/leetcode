package lixuan.huawei;

import java.util.Scanner;

/**
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，
 * 换行表示结束符，不算在字符里。不在范围内的不作统计。
 */
public class Count {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] count = new int[128];
        while (input.hasNext()) {
            String str = input.nextLine();
            char[] chars = str.toCharArray();
            int sum = 0;
            for (char c : chars) {
                if (count[c] == 1) {
                    continue;
                } else if(count[c] == 0) {
                    count[c] = 1;
                    sum += 1;
                }
            }
            System.out.println(sum);
        }
    }
}
