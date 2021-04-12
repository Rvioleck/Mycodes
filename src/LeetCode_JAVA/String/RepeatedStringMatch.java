package LeetCode_JAVA.String;

public class RepeatedStringMatch {

    public int repeatedStringMatch(String a, String b) {
        int len1 = a.length(), len2 = b.length();
        int n = (int) Math.ceil(len2 * 1.0 / len1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(a);
        }
        if (builder.toString().contains(b)) {
            return n;
        }
        builder.append(a);
        if (builder.toString().contains(b)) {
            return n + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new RepeatedStringMatch().repeatedStringMatch("abc", "cabcabca"
        ));
    }
}
