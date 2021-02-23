package LeetCode_JAVA;

public class PlusOne {

    public int[] plusOne(int[] digits) {
//        for(int i = digits.length - 1; i >= 0; i--){
//            digits[i]++;
//            digits[i] %= 10;
//            if(digits[i] != 0){
//                return digits;
//            }
//        }
//        digits = new int[digits.length + 1];
//        digits[0] = 1;
//        return digits;
        digits[digits.length - 1] += 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 10 && i >= 1) {
                digits[i] = 0;
                digits[i - 1] += 1;
            } else if (digits[i] == 10 && i == 0) {
                digits[i] = 0;
                int[] result = new int[digits.length + 1];
                result[0] = 1;
                for (int j = 1; j < result.length; j++) {
                    result[j] = digits[j - 1];
                }
                return result;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        PlusOne po = new PlusOne();
        int[] digits = {0};
        int[] result = po.plusOne(digits);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }

}
