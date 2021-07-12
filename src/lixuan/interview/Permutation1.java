package lixuan.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation1 {
    /**
     * 有重复字符串的排列组合
     *
     * @param S
     * @return
     */
    public String[] permutation(String S) {
        int n = S.length();
        char[] chars = S.toCharArray();
        Arrays.sort(chars);//排序
        boolean[] vis = new boolean[n];
        List<String> list = new ArrayList<>();
        dfs(chars, vis, list, new StringBuilder(), 0);
        String[] ans = new String[list.size()];
        return list.toArray(ans);
    }

    private void dfs(char[] chars, boolean[] vis, List<String> list, StringBuilder sb, int index) {
        if (sb.length() == chars.length) {
            String s = sb.toString();
            list.add(new String(s.getBytes()));
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (vis[i] || i > 0 && chars[i] == chars[i - 1] && !vis[i - 1]) {//剪枝
                continue;
            }
            vis[i] = true;
            sb.append(chars[i]);
            dfs(chars, vis, list, sb, i + 1);
            vis[i] = false;
            sb.deleteCharAt(sb.length() - 1);//回溯
        }
    }
}
