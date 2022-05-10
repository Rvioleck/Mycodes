package LeetCode_JAVA;

public class MinOperations {

    public int[] minOperations(String boxes) {
        // 时间复杂度O(n^2)
        char[] box = boxes.toCharArray();
        int[] res = new int[box.length];
        for (int i = 0; i < box.length; ++i) {
            for (int j = 0; j < box.length; ++j) {
                if (box[j] == '1') {
                    res[i] += Math.abs(j - i);
                }
            }
        }
        return res;
    }

    public int[] minOperations2(String boxes) {
        // 时间复杂度：O(n)
        int[] answer = new int[boxes.length()];
        int left = 0, right = 0, total = 0;//左边盒子的个数，右边盒子的个数，操作数
        //计算第一个盒子的操作数
        if (boxes.charAt(0) == '1') left++;
        for (int i = 1; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '1') {
                right++;
                total += i;
            }
        }
        answer[0] = total;
        //根据前一个盒子的操作数，计算下一个盒子的操作数
        for (int i = 1; i < boxes.length(); i++) {
            total = total + left - right;
            if (boxes.charAt(i) == '1') {
                left++;
                right--;
            }
            answer[i] = total;
        }
        return answer;
    }

}
