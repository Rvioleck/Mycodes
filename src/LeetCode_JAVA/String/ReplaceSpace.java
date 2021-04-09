package LeetCode_JAVA.String;

/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(new ReplaceSpace().replaceSpace(s));
    }

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder(s);
        String rep = "%20";
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == ' '){
                sb.deleteCharAt(i);
                sb.insert(i, rep);
            }
        }
        return String.valueOf(sb);
    }
}
