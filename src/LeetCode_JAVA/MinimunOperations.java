package LeetCode_JAVA;

public class MinimunOperations {

    public int minimumOperations(String num) {
        int count0 = 0; // 00 50
        int count5 = 0; // 25 75
        boolean has0 = false;
        boolean has5 = false;
        char[] arrs = num.toCharArray();
        for (int i = arrs.length - 1; i >= 0; --i) {
            if (arrs[i] != '0' && arrs[i] != '5' && !has0 && !has5) {
                count0++;
                count5++;
            } else if (has0 && (arrs[i] == '0' || arrs[i] == '5')) {
                count5++;
                return count0;
            } else if (has5 && (arrs[i] == '2' || arrs[i] == '7')) {
                count0++;
                return count5;
            } else if (arrs[i] == '0' && !has0) {
                count5++;
                has0 = true;
            } else if (arrs[i] == '5' && !has5) {
                count0++;
                has5 = true;
            } else {
                count0++;
                count5++;
            }
        }
        return has0 ? num.length() - 1 : num.length();
    }

    public static void main(String[] args) {
        MinimunOperations mo = new MinimunOperations();
        System.out.println(mo.minimumOperations("2908305"));
    }
}
