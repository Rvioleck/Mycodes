package LeetCode_JAVA.String;

public class CheckInclusion {
    private boolean res = false;
    private boolean[] vis;

    private boolean isSubstring(String s1, String s2){
        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
            int j;
            for (j = 0; j < s1.length(); j++) {
                if (s1.charAt(j) != s2.charAt(i + j)){
                    break;
                }
            }
            if (j == s1.length())
                return true;
        }
        return false;
    }

    private void dfs(String s1, StringBuffer subS1, String s2){
        if (subS1.length() == s1.length()){
            if (isSubstring(new String(subS1), s2)){
                res = true;
            }
        }
        for (int i = 0; i < s1.length(); i++) {
            if (vis[i]) continue;
            if (res) continue;
            vis[i] = true;
            subS1.append(s1.charAt(i));

            dfs(s1, subS1, s2);

            vis[i] = false;
            subS1.deleteCharAt(subS1.length() - 1);
        }

    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        }
        vis = new boolean[s1.length()];
        StringBuffer sub = new StringBuffer();
        dfs(s1, sub, s2);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CheckInclusion().checkInclusion("adc", "dcda"));
    }
}
