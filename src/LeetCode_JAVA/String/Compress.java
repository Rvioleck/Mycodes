package LeetCode_JAVA.String;

public class Compress {

    public int compress(char[] chars) {
        int len = chars.length;
        if (len <= 1){
            return len;
        }
        int finish = 0;
        int repeat = 1;
        char curr, next;
        for (int i = 0; i < len - 1; i++) {
            curr = chars[i];
            next = chars[i + 1];
            if (curr == next){
                repeat++;
            } else {
                if (repeat != 1) {
                    String rep = Integer.toString(repeat);
                    int repLen = rep.length();
                    int j = -1;
                    while (++j != repLen){
                        finish++;
                        chars[finish] = rep.charAt(j);
                    }
                    repeat = 1;
                }
                chars[++finish] = next;
            }
        }
        if (repeat != 1){
            String rep = Integer.toString(repeat);
            int repLen = rep.length();
            int j = -1;
            while (++j != repLen){
                finish++;
                chars[finish] = rep.charAt(j);
            }
        }

        return finish + 1;
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'a','a','a','b'};
        int len = new Compress().compress(chars);
        for (int i = 0; i < len; i++) {
            System.out.print(chars[i] + " ");
        }
    }

}
