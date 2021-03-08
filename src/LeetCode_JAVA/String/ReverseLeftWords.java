package LeetCode_JAVA.String;

public class ReverseLeftWords {

    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        String doubleS = s + s;
        return (String) doubleS.subSequence(n, n + len);
    }

    public static void main(String[] args) {
        String s = "lrloseumgh";
        s = new ReverseLeftWords().reverseLeftWords(s, 6);
        System.out.println(s);
    }

}
