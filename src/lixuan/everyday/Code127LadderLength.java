package lixuan.everyday;

import java.util.*;

public class Code127LadderLength {
    private int ans = Integer.MAX_VALUE;

    /**
     * dfs超时
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0 || !wordList.contains(endWord)) {
            return 0;
        }
        List<String> temp = new ArrayList<>();
        temp.add(beginWord);
        dfs(beginWord, temp, endWord, wordList);
        return ans==Integer.MAX_VALUE?0:ans;
    }

    private void dfs(String str, List<String> temp, String endWord, List<String> wordList) {
        if (str.equals(endWord)) {
            temp.add(str);
            ans = Math.min(ans, temp.size());
            temp.remove(temp.size() - 1);
            return;
        }
        for (String s : wordList) {
            if (isTrue(s, str)&&!temp.contains(s)) {
                temp.add(s);
                dfs(s, temp, endWord, wordList);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isTrue(String s, String str) {
        if (s.length() != str.length()) {
            return false;
        }
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != str.charAt(i)) {
                cnt++;
            }
            if (cnt >= 2) {
                return false;
            }
        }
        return cnt==1;
    }


    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        boolean[] visited = new boolean[wordList.size()];
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                String temp = queue.poll();
                if (temp.equals(endWord)) {
                    return level;
                }
                for (int j = 0; j < wordList.size(); j++) {
                    String next = wordList.get(j);
                    if (isTrue(temp, next) && visited[j] == false) {
                        visited[j] = true;
                        queue.offer(next);
                    }
                }
            }
        }
        return 0;
    }
}
