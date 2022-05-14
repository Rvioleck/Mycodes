package LeetCode_JAVA.GreedyAlgorithm;

public class MaxDepth {

    public int maxDepth(String s) {
        char[] str = s.toCharArray();
        int count = 0, max = 0;
        for (char c : str) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
            max = Math.max(count, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxDepth().maxDepth("(3+32)(()(()()()()()))()"));
    }

}
