package LeetCode_JAVA.String;

public class ValidPalindrome {
    private boolean res = false;

    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        dfs(s, i, j, 1);
        return res;
    }

    private void dfs(String s, int i, int j, int count) {
        if (res) return;
        while (i < j && s.charAt(i) == s.charAt(j)){
            i++;
            j--;
        }
        if (i >= j){
            res = true;
            return;
        }
        if (count >= 1){
            dfs(s, i + 1, j, count - 1);
            dfs(s, i, j - 1, count - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().validPalindrome("axccdxa"));
    }
}
