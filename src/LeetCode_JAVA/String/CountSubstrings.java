package LeetCode_JAVA.String;

public class CountSubstrings {

    private boolean isPalindrome(String s){
        int i = 0, j = s.length() - 1;
        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public int countSubstrings(String s) {
        int count = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (isPalindrome(s.substring(i, j + 1))){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CountSubstrings().countSubstrings("abc"));
    }
}
