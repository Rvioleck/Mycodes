package LeetCode_JAVA.String;

public class RotateString {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length())
            return false;
        String aa = A + A;
        return aa.contains(B);
    }

    public static void main(String[] args) {
        System.out.println(new RotateString().rotateString("abcd", "cda"));
    }
}
