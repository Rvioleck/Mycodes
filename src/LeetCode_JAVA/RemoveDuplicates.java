package LeetCode_JAVA;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class RemoveDuplicates {
    public String removeDuplicates(String S){
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char character : S.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1))
                sb.deleteCharAt(sbLength-- - 1);
            else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }

//    public String removeDuplicates2(String S){
//        Stack<Character> stack = new Stack();
//        for (int i = 0; i < S.length(); i++) {
//            stack.push(S.charAt(i));
//            if (stack.size()>=2){
//                char peek1 = stack.pop();
//                char peek2 = stack.pop();
//                if ( peek1 != peek2){
//                    stack.push(peek2);
//                    stack.push(peek1);
//                }
//            }
//        }
//        StringBuilder result = new StringBuilder();
//        for (char c:
//             stack) {
//            result.append(c);
//        }
//        return new String(result);
//    }

    @Test
    public void test(){
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }
}
