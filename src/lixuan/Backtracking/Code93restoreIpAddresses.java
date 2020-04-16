package lixuan.Backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 示例:
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class Code93restoreIpAddresses {
    private List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }
        dfs(s, new ArrayList<String>(), 0, 1);
        return res;
    }

    private void dfs(String str, ArrayList<String> strings, int s, int e) {
        if (s > e || e > str.length() + 1) {
            return;
        }
        if (e == str.length() + 1 && strings.size() == 4) {
            String temp = "";
            boolean flag = true;
            for (int i = 0; i < strings.size(); i++) {
                String stemp = strings.get(i);
                if (stemp.length() > 1 && stemp.charAt(0) == '0') {
                    flag = false;
                    break;
                }
                if (i < strings.size() - 1) {
                    temp += strings.get(i) + ".";
                }
            }
            temp += strings.get(strings.size() - 1);
            if (flag) {
                res.add(temp);
            }
        }
        for (int i = 0; i < 3; i++) {
            if (e + i <= str.length()) {
                int num = Integer.parseInt(str.substring(s, e + i));
                if (num >= 0 && num <= 255 && strings.size() < 4) {
                    strings.add(str.substring(s, e + i));
                    dfs(str, strings, e + i, e + i + 1);
                    strings.remove(strings.size() - 1);
                }
            }
        }

    }

    public static void main(String[] args) {
        Code93restoreIpAddresses addresses = new Code93restoreIpAddresses();
        List<String> strings = addresses.restoreIpAddresses("010010");
        for (String s : strings) {
            System.out.println(s);
        }
    }

    /**
     * 优化
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses1(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        // 如果长度不够，不搜索
        if (len < 4 || len > 12) {
            return res;
        }

        Deque<String> path = new ArrayDeque<>(4);
        int splitTimes = 0;
        dfs(s, len, splitTimes, 0, path, res);
        return res;
    }

    private int judgeIfIpSegment(String s, int left, int right) {
        int len = right - left + 1;

        // 大于 1 位的时候，不能以 0 开头
        if (len > 1 && s.charAt(left) == '0') {
            return -1;
        }

        // 转成 int 类型
        int res = 0;
        for (int i = left; i <= right; i++) {
            res = res * 10 + s.charAt(i) - '0';
        }

        if (res > 255) {
            return -1;
        }
        return res;
    }

    private void dfs(String s, int len, int split, int begin, Deque<String> path, List<String> res) {
        if (begin == len) {
            if (split == 4) {
                res.add(String.join(".", path));
            }
            return;
        }

        // 看到剩下的不够了，就退出（剪枝），len - begin 表示剩余的还未分割的字符串的位数
        if (len - begin < (4 - split) || len - begin > 3 * (4 - split)) {
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (begin + i >= len) {
                break;
            }

            int ipSegment = judgeIfIpSegment(s, begin, begin + i);
            if (ipSegment != -1) {
                // 在判断是 ip 段的情况下，才去做截取
                path.addLast(ipSegment + "");
                dfs(s, len, split + 1, begin + i + 1, path, res);
                path.removeLast();
            }
        }
    }
}
