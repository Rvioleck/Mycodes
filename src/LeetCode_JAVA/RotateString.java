package LeetCode_JAVA;

public class RotateString {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length())
            return false;
        String aa = A + A;
        if (aa.contains(B)) {
            return true;
        }
        return false;
    }
}
