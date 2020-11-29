package LeetCode_JAVA;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IsPalindrome {
    public boolean isPalindrome(String s){
        s = s.toLowerCase();
        int low = 0, high = s.length() - 1;
        while (low < high){
            if (!(s.charAt(low) <= 'Z' && s.charAt(low) >='A'
                    || s.charAt(low) <= 'z' && s.charAt(low) >= 'a'
                    || s.charAt(low) <= '9' && s.charAt(low) >= '0')){
                low++;
                continue;
            }
            else if(!(s.charAt(high) <= 'Z' && s.charAt(high) >='A'
                    || s.charAt(high) <= 'z' && s.charAt(high) >= 'a'
                    || s.charAt(high) <= '9' && s.charAt(high) >= '0')){
                high--;
                continue;
            }
            else if (s.charAt(low) != s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }


    @Test
    public void isPalindromeTest(){
        String s = "0P";
        assertEquals(isPalindrome(s), true);
    }
}
