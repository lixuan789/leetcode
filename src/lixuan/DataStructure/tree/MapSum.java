package lixuan.DataStructure.tree;

public class MapSum {
    private int res = 0;

    private class TrieNode {
        private boolean isEnd;
        private int num;
        private TrieNode[] next;

        public TrieNode() {
            isEnd = false;
            num = 0;
            next = new TrieNode[26];
        }
    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode cur = root;
        char[] chars = key.toCharArray();
        for (char c : chars) {
            int index = c - 'a';
            if (cur.next[index] == null) {
                cur.next[index] = new TrieNode();
            }
            cur = cur.next[index];
        }
        cur.isEnd = true;
        cur.num = val;
    }

    public int sum(String prefix) {
        TrieNode cur = root;
        char[] chars = prefix.toCharArray();
        for (char c : chars) {
            int index = c - 'a';
            if (cur.next[index] == null) {
                return 0;
            }
            cur = cur.next[index];
        }
        Mysum(cur);
        return res;
    }

    private void Mysum(TrieNode cur) {
        if (cur == null) {
            return;
        }
        if (cur.isEnd) {
            res += cur.num;
        }
        for (int i = 0; i < 26; i++) {
            Mysum(cur.next[i]);
        }
    }
}
