package LeetCode_JAVA.String;

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        int sLen = s.length();
        Stack<Character> stack = new Stack<>();
        StringBuilder decode = new StringBuilder();
        for (int i = 0; i < sLen; i++) {
            char ch = s.charAt(i);
            if (ch != ']'){
                stack.push(ch);
            } else {
                StringBuilder repeat = new StringBuilder();
                char popOne = stack.pop();
                while (popOne != '['){
                    repeat.append(popOne);
                    popOne = stack.pop();
                }
                StringBuilder digit = new StringBuilder(stack.pop().toString());
                while (!stack.isEmpty() && Character.isDigit(stack.peek())){
                    digit.append(stack.pop().toString());
                }
                int count = Integer.parseInt(String.valueOf(digit.reverse()));
                int repLen = repeat.length();
                while (count-- != 0){
                    for (int j = repLen - 1; j >= 0; j--) {
                        stack.push(repeat.charAt(j));
                    }
                }
            }
        }
        for (char elem : stack) {
            decode.append(elem);
        }
        return decode.toString();
    }

    public static void main(String[] args) {
        //"3[a]2[bc]"
        //"3[a2[c]]"
        //"3[a]"
        System.out.println(new DecodeString().decodeString("10[a]"));
    }

}
