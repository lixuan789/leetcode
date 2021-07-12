package lixuan.everyday;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Code752OpenLock {
    /**
     * 双向BFS
     *
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        for (String dead : deadends) {
            visited.add(dead);
        }
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        int step = 0;
        q1.add("0000");
        q2.add(target);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.size() > q2.size()) {//从小的一端进行扩展
                Set<String> temp = q1;
                q1 = q2;
                q2 = temp;
            }
            Set<String> temp = new HashSet<>();//存放这一层的遍历数据
            for (String cur : q1) {
                if (visited.contains(cur)) {//已经访问过或者在deadends中
                    continue;
                }
                if (q2.contains(cur)) {//存在交集
                    return step;
                }
                visited.add(cur);
                for (int i = 0; i < 4; i++) {
                    String up = up(cur, i);
                    if (!visited.contains(up)) {
                        temp.add(up);
                    }

                    String down = down(cur, i);
                    if (!visited.contains(down)) {
                        temp.add(down);
                    }
                }
            }
            step++;
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }

    private String up(String str, int j) {//向上旋转
        char[] chars = str.toCharArray();
        if (chars[j] == '9') {
            chars[j] = '0';
        } else {
            chars[j] += 1;
        }
        return new String(chars);
    }

    private String down(String str, int j) {//向下旋转
        char[] chars = str.toCharArray();
        if (chars[j] == '0') {
            chars[j] = '9';
        } else {
            chars[j] -= 1;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Code752OpenLock test = new Code752OpenLock();
        String[] a = {"0201", "0101", "0102", "1212", "2002"};
        int i = test.openLock(a, "0202");
        System.out.println(i);
    }

}
