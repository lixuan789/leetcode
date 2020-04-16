package lixuan.daydayup;

import java.util.*;

public class Code820 {
    /**
     * 暴力法
     *
     * @param words
     * @return
     */
    public int minimumLengthEncoding(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        Set<String> list = new HashSet<>();
        int len = words[0].length() + 1;
        list.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            int count = 0;
            boolean flag = true;
            for (String str : list) {
                if (!isSubstr(str, words[i])) {
                    count++;
                }
                if (isSubstr(str, words[i]) && str.charAt(str.length() - 1) == words[i].charAt(words[i].length() - 1)) {
                    flag = false;
                }
            }
            if (flag || count == list.size()) {//全不是,或者后缀不是最后面的加
                len += words[i].length() + 1;
                list.add(words[i]);
            }
        }
        return len;
    }

    private boolean isSubstr(String str, String word) {
        for (int i = 0; i <= str.length() - word.length(); ) {
            int temp = i;
            for (int j = 0; j < word.length(); ) {
                if (str.charAt(i) == word.charAt(j)) {
                    i++;
                    j++;
                    if (j == word.length()) {
                        return true;
                    }
                } else {
                    i = temp + 1;
                    break;
                }
            }
        }
        return false;
    }
}

/**
 * 前缀树
 */
class Solution {
    public int minimumLengthEncoding(String[] words) {
        int len = 0;
        Trie trie = new Trie();
        // 先对单词列表根据单词长度由长到短排序
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        // 单词插入trie，返回该单词增加的编码长度
        for (String word : words) {
            len += trie.insert(word);
        }
        return len;
    }
}

// 定义tire
class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public int insert(String word) {
        TrieNode cur = root;
        boolean isNew = false;
        // 倒着插入单词
        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                isNew = true; // 是新单词
                cur.children[c] = new TrieNode();
            }
            cur = cur.children[c];
        }
        // 如果是新单词的话编码长度增加新单词的长度+1，否则不变。
        return isNew ? word.length() + 1 : 0;
    }
}

class TrieNode {
    char val;
    TrieNode[] children = new TrieNode[26];

    public TrieNode() {
    }
}

