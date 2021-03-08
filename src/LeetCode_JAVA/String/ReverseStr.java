package LeetCode_JAVA.String;

import java.util.Arrays;

public class ReverseStr {

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int lens = chars.length;
        int i = 0, j = k - 1;
        while (i < lens || j < lens){
            if (j >= lens){
                j = lens - 1;
            }
            int left = i, right = j;
            while (left < right){
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
            i += 2 * k;
            j += 2 * k;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        s = new ReverseStr().reverseStr(s, 2);
        System.out.println(s);
    }

}
