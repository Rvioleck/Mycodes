package LeetCode_JAVA;

import org.junit.Test;

import java.util.Stack;

public class BracketIsValid {
    public boolean isValid(String s) {
        if (s.length() == 0)
            return true;
        Stack willMatch = new Stack();
        willMatch.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '}' && willMatch.empty() == false) {
                char left = (char) willMatch.pop();
                if (left != '{') {
                    willMatch.push(left);
                    willMatch.push(s.charAt(i));
                }
            } else if (s.charAt(i) == ']' && willMatch.empty() == false) {
                char left = (char) willMatch.pop();
                if (left != '[') {
                    willMatch.push(left);
                    willMatch.push(s.charAt(i));
                }
            } else if (s.charAt(i) == ')' && willMatch.empty() == false) {
                char left = (char) willMatch.pop();
                if (left != '(') {
                    willMatch.push(left);
                    willMatch.push(s.charAt(i));
                }
            } else
                willMatch.push(s.charAt(i));
        }
        return willMatch.empty();
    }

    @Test
    public void test() {
//        String s = "{[]}";
//        String s = "(])";
        String s = "([)]";
        System.out.println(isValid(s));
    }
}
