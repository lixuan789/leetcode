package lixuan.doublePointer;

import java.util.*;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 */
public class Code345reverseVowels {
    /**
     * 方法一：双指针
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        Character[] chars = {'a', 'e', 'i', 'o', 'u','A','E','I','O','U'};
        ArrayList<Character> list = new ArrayList<>(Arrays.asList(chars));
        char[] array = s.toCharArray();
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (list.contains(array[i]) && list.contains(array[j])) {
                Character temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            } else if (!list.contains(array[i])) {
                i++;
            } else if (!list.contains(array[j])) {
                j--;
            }

        }
        String res = String.valueOf(array);
        return res;

    }

    /**
     * 方法二：双端队列
     * @param s
     * @return
     */
    public String reverseVowels1(String s) {
        Character[] chars = {'a', 'e', 'i', 'o', 'u','A','E','I','O','U'};
        ArrayList<Character> list = new ArrayList<>(Arrays.asList(chars));
        Deque<Integer> deque = new LinkedList<>();
        char[] array = s.toCharArray();
        for (int i=0;i<s.length();i++){
            if(list.contains(s.charAt(i))){
                deque.push(i);
            }
        }
        while (deque.size()>1){
            Integer first = deque.removeFirst();
            Integer last = deque.removeLast();
            Character temp=array[first];
            array[first]=array[last];
            array[last]=temp;
        }
        String res = String.valueOf(array);
        return res;

    }

    public static void main(String[] args) {
        Code345reverseVowels code345reverseVowels = new Code345reverseVowels();
        code345reverseVowels.reverseVowels("hello");
    }
}
