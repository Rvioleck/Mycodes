package LeetCode_JAVA.Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * 注意，您的结果中 不应 包含任何括号。
 */
public class ReverseParentheses {

    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";
        System.out.println(new ReverseParentheses().reverseParentheses(s));
    }

    public String reverseParentheses(String s) {
        Deque<String> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; ++i){
            char ch = s.charAt(i);
            if (ch == '('){ // 如果是左括号，将字符串sb插入到栈中，并将其置为空，进入下一层；
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (ch == ')'){ // 如果是右括号，此时翻转括号内的内容，并将前面的字符拼接到字符串头
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}
