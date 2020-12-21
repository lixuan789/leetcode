package lixuan.daydayup;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符
 * （包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，
 * 则需要在最终答案中包含该字符 3 次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code1002CommonChars {
    public List<String> commonChars(String[] A) {
        if (A==null||A.length==0){
            return null;
        }
        ArrayList<String> list = new ArrayList<>();
        int[] map=new int[26];
        for (int i=0;i<A.length;i++){
            if (i==0){
                for (char c:A[i].toCharArray()){
                    map[c-'a']++;
                }
            }else {
                int[] temp=new int[26];
                for (char c:A[i].toCharArray()){
                    temp[c-'a']++;
                }
                for (int j=0;j<26;j++){
                    map[j]=Math.min(map[j],temp[j]);
                }
            }
        }
        for (int i=0;i<26;i++){
            if (map[i]!=0){
                for (int j=0;j<map[i];j++){
                    char s=(char)('a'+i);
                    list.add(s+"");
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Code1002CommonChars test = new Code1002CommonChars();
        String[] a={"acabcddd","bcbdbcbd","baddbadb","cbdddcac","aacbcccd","ccccddda","cababaab","addcaccd"};
        List<String> list = test.commonChars(a);
        System.out.println(list);
    }
}
