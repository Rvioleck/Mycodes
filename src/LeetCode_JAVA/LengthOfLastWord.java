package LeetCode_JAVA;

import java.util.Optional;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int result = 0;
        if (s.length() == 0)
            return result;
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) != ' ')
                result++;
            else
                break;
        }
        return result;
//        String last = new String();
//        if (s.length() == 0){
//            return 0;
//        }
//        else {
//            String[] sb = s.split(" ");
//            if (sb.length == 0)
//                return 0;
//            last = sb[sb.length - 1];
//        }
//        int result = last.length();
//        return result;
    }

    public static void main(String[] args) {
        LengthOfLastWord ll = new LengthOfLastWord();
        String s = "";
        System.out.println(ll.lengthOfLastWord(s));
    }
}
