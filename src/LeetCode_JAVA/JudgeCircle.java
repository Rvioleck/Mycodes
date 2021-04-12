package LeetCode_JAVA;

public class JudgeCircle {
    public boolean judgeCirle(String moves) {
        int x = 0, y = 0;
        for (char move :
                moves.toCharArray()) {
            switch (move) {
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
            }
        }
        return x == 0 && y == 0;
    }
//    public boolean judgeCirle(String moves){
//        int Unum = 0, Dnum = 0, Lnum = 0, Rnum = 0;
//        for (int i = 0; i < moves.length(); i++) {
//            if (moves.charAt(i) == 'U')
//                Unum += 1;
//            else if (moves.charAt(i) == 'D')
//                Dnum += 1;
//            else if (moves.charAt(i) == 'L')
//                Lnum += 1;
//            else if (moves.charAt(i) == 'R')
//                Rnum += 1;
//        }
//        if (Unum == Dnum && Lnum == Rnum){
//            return true;
//        }
//        return false;
//    }


}
