package lixuan.test.test4;

import java.util.*;

public class BuyingAHat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            set.add(input.nextInt());
        }
        if (set.size() < 3) {
            System.out.println(-1);
        } else {
            ArrayList<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            System.out.println(list.get(2));
        }
    }
}
