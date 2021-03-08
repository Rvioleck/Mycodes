package LeetCode_JAVA.String;

public class CompressString {

    public String compressString(String S) {
        StringBuilder res = new StringBuilder();
        int sLen = S.length();
        if (sLen <= 1){
            return S;
        }
        int repeat = 1;
        char curr = S.charAt(0);
        for (int i = 0; i < sLen - 1; i++) {
            char next = S.charAt(i + 1);
            if (curr == next){
                repeat++;
            } else {
                res.append(curr);
                res.append(repeat);
                repeat = 1;
                curr = next;
                if (res.length() > sLen){
                    return S;
                }
            }
        }
        res.append(curr);
        res.append(repeat);
        if (res.length() >= sLen){
            return S;
        } else {
            return res.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new CompressString().compressString(""));
    }

}
