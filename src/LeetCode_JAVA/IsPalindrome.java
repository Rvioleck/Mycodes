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

    public boolean isPalindrome2(int x){
        if (x<0 || x!=0 && x%10==0)
            return false;
        int rev = 0;
        while (rev < x){
            rev = rev*10 + x%10;
            x /= 10;
        }
        return rev == x || rev/10 == x;
//        int x0 = x;
//        if (x < 0)
//            return false;
//        int reverse = 0;
//        while (x != 0){
//            int temp = x % 10;
//            x /= 10;
//            if (reverse > Integer.MAX_VALUE/10 || reverse < Integer.MIN_VALUE/10){
//                return false;
//            }
//            reverse = 10*reverse + temp;
//        }
//        if (x0 == reverse)
//            return true;
//        return false;
    }


    @Test
    public void isPalindromeTest(){
        String s = "0P";
        assertEquals(isPalindrome(s), true);
    }

    @Test
    public void isPalindromeTest2(){
        int x = 12321;
        assertEquals(isPalindrome2(x), true);
    }
}
