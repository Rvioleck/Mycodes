package LeetCode_JAVA;

import java.util.*;

public class LetterCombinations {
    private Map<Character, String> phoneMap = new HashMap(){
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };
    private void dfs(List<String> res, StringBuffer combination, String digits, int index){
        if (index == digits.length()){
            res.add(new String(combination));
            return;
        }
        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            combination.append(letters.charAt(i));
            dfs(res, combination, digits, index + 1);
            combination.deleteCharAt(combination.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0)
            return res;
        StringBuffer combination = new StringBuffer();
        dfs(res, combination, digits, 0);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("235"));
//        System.out.println(Integer.parseInt(String.valueOf('2')));
    }
}
