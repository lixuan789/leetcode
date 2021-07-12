package lixuan.doublePointer;

import java.util.HashSet;
import java.util.Set;

public class Code567CheckInclusion {
    /**
     * 滑动窗口
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int[] need = new int[26];
        int[] window = new int[26];
        int size = 0;
        for (char c : s1.toCharArray()) {
            if (need[c - 'a'] == 0) {//去重之后的个数
                size++;
            }
            need[c - 'a']++;
        }
        int left = 0, right = 0;
        int valid = 0;
        char[] array = s2.toCharArray();
        while (right < array.length) {
            char c = array[right];
            right++;
            if (need[c - 'a'] != 0) {
                window[c - 'a']++;
                if (window[c - 'a'] == need[c - 'a']) {
                    valid++;
                }
            }
            System.out.println(left + ":" + right);
            while (valid == size) {
                int len = right - left;
                if (len == s1.length()) {
                    return true;
                }
                char d = array[left];
                left++;
                if (need[d - 'a'] != 0) {
                    if (window[d - 'a'] == need[d - 'a']) {
                        valid--;
                    }
                    window[d - 'a']--;
                }
            }
        }
        return false;
    }


    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int left = 0, right = 0;
        char[] array = s.toCharArray();
        int max=0;
        while (right < array.length) {
            char c = array[right];
            right++;
            if(!set.contains(c)){
                set.add(c);
                max=Math.max(max,set.size());
            }else{
                while(set.contains(c)){
                    set.remove(array[left]);
                    left++;
                }
                set.add(c);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Code567CheckInclusion test = new Code567CheckInclusion();
        int aab = test.lengthOfLongestSubstring("aab");
        System.out.println(aab);
    }
}
