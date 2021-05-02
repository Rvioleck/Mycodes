package LeetCode_JAVA.Stack;

public class JudgeCircle {

    public static void main(String[] args) {
        String moves = "LL";
        System.out.println(new JudgeCircle().judgeCircle(moves));
    }

    public boolean judgeCircle(String moves) {
        int len = moves.length();
        if ((len & 1) == 1){
            return false;
        }
        int l = 0, r = 0, u = 0, d = 0;
        for (int i = 0; i < len; i++) {
            switch (moves.charAt(i)) {
                case 'L': {
                    l++;
                    break;
                }
                case 'R': {
                    r++;
                    break;
                }
                case 'U': {
                    u++;
                    break;
                }
                case 'D': {
                    d++;
                    break;
                }
            }
        }
        return l == r && u == d;
    }

}
