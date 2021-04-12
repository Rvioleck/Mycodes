package LeetCode_JAVA.String;

public class ReverseLeftWords {

    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        String doubleS = s + s;
        return (String) doubleS.subSequence(n, n + len);
    }

    public String reverseLeftWords2(String s, int n) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < n / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[n - i - 1];
            chars[n - i - 1] = temp;
        }

        for (int i = n; i < (len + n) / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[len + n - i - 1];
            chars[len + n - i - 1] = temp;
        }

        for (int i = 0; i < len / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[len - 1 - i];
            chars[len - i - 1] = temp;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(new ReverseLeftWords().reverseLeftWords(s, 2));
        System.out.println(new ReverseLeftWords().reverseLeftWords2(s, 2));
    }

}
