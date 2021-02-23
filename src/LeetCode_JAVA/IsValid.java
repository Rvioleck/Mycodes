package LeetCode_JAVA;

import org.junit.Test;

import java.util.Stack;

public class IsValid {
    public boolean isValid(String s) {
        // [({ })]
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty()) {
                if (antiBracket(s.charAt(i)) == stack.peek()) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(s.charAt(i));
        }
        return stack.empty();
    }

    public char antiBracket(char ch) {
        switch (ch) {
            case ']':
                return '[';
            case '}':
                return '{';
            case ')':
                return '(';
            default:
                return ' ';
        }
    }

    @Test
    public void test() {
//        String s = "([)]";
//        String s = "{[]}";
        String s = "";

        System.out.println(isValid(s));
    }
}
