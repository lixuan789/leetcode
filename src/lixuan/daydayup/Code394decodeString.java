package lixuan.daydayup;

import org.w3c.dom.Node;

import java.util.*;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class Code394decodeString {
    /**
     * 括号数据结构，包括括号的开始位置和结束位置
     */
    class Node{
        int s;
        int e;
        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
    public String decodeString(String s) {
        if (!isExist(s)){
            return s;
        }
        Stack<Integer> stack = new Stack<>();
        ArrayList<Node> list = new ArrayList<>();
        String res="";
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++){
            if (chars[i]=='['){
                stack.push(i);
            }
            if (chars[i]==']'){
                int start=stack.pop();
                Node node = new Node(start, i);
                list.add(node);
            }
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.s-o2.s;
            }
        });//按照开始位置排序
        int index=0;
        while (index<list.size()){
            Node node = list.get(index);
            String basic=s.substring(node.s+1,node.e);//重复的字符串
            while (isExist(basic)){//是否还有嵌套的括号
                index++;
                Node temp=list.get(index);
                String str=change(temp,s);
                int i=0;
                for (;i<basic.length();i++){
                    if (basic.charAt(i)>='0'&&basic.charAt(i)<='9'){
                        break;
                    }
                }
                basic=basic.substring(0,i)+str;
                basic=basic+s.substring(temp.e+1,node.e);
            }
            int num=0;//重复的次数
            int j=node.s-1;
            for (;j>=0;j--){
                if (chars[j]>='0'&&chars[j]<='9'){
                    continue;
                }else {
                    break;
                }
            }
            num=Integer.parseInt(s.substring(j+1,node.s));
            String temp="";
            for (int cnt=0;cnt<num;cnt++){
                temp+=basic;
            }
            res+=temp;
            index++;
        }
        //加上开始部分
        int i=0;
        for (;i<chars.length;i++){
            if (chars[i]>='0'&&chars[i]<='9'){
                break;
            }
        }
        res=s.substring(0,i)+res;
        //加上结尾部分
        int j=chars.length-1;
        for (;j>=0;j--){
            if (chars[j]==']'){
                break;
            }
        }
        res=res+s.substring(j+1);
        return res;
    }

    private String change(Node node, String s) {
        String basic=s.substring(node.s+1,node.e);//重复的字符串
        char[] chars = s.toCharArray();
        int num=0;//重复的次数
        int j=node.s-1;
        for (;j>=0;j--){
            if (chars[j]>='0'&&chars[j]<='9'){
                continue;
            }else {
                break;
            }
        }
        num=Integer.parseInt(s.substring(j+1,node.s));
        String temp="";
        for (int cnt=0;cnt<num;cnt++){
            temp+=basic;
        }
        return temp;
    }

    private boolean isExist(String basic) {
        for (char c:basic.toCharArray()){
            if (c=='['){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Code394decodeString test = new Code394decodeString();
        String s = test.decodeString("2[abc]3[cd]ef");
        System.out.println(s);
    }
}
