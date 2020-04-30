package lixuan.test.huawei;

import java.util.HashSet;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String str = input.nextLine();
            HashSet<Character> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for (char c : str.toCharArray()) {
                if (set.contains(c)) {
                    continue;
                }
                set.add(c);
                sb.append(c);
            }
            System.out.println(sb.toString());
        }
    }
}
