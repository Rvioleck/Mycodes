package LeetCode_JAVA.TrieTree;

/**
 * https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 * <p>
 * 高度为32的前缀二叉树
 */
public class FindMaximumXOR {

    public static void main(String[] args) {
        System.out.println(new FindMaximumXOR().findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
    }

    static class Node {
        Node[] next = new Node[2]; // 存0和1
    }

    Node root = new Node();

    /**
     * @param x 在前缀树中插入二进制数字x
     *          每一位为一个结点, 从第32位开始
     *          for循环执行32次, 与输入规模无关, 时间复杂度O(1)
     */
    public void insert(int x) {
        Node curNode = root;
        for (int i = 31; i >= 0; --i) {
            int u = (x >> i) & 1;
            if (curNode.next[u] == null) {
                curNode.next[u] = new Node();
            }
            curNode = curNode.next[u];
        }
    }

    /**
     * @param x 数x
     * @return 前缀树上与x异或值最大的y
     * 每次在前缀树上优先查找该位不同的数(保证异或结果最大)
     * for循环执行32次, 与输入规模无关, 时间复杂度O(1)
     */
    public int getVal(int x) {
        int y = 0;
        Node curNode = root;
        for (int i = 31; i >= 0; --i) {
            int a = (x >> i) & 1, b = 1 - a;
            // 贪心查找每一位上的结果
            // 其中优先考虑该位上值与x不同的数(if) 后考虑相同的数(else)
            if (curNode.next[b] != null) {
                y |= (b << i);
                curNode = curNode.next[b];
            } else {
                y |= (a << i);
                curNode = curNode.next[a];
            }
        }
        return y;
    }

    /**
     * @param nums 数组
     * @return 数组nums中两数异或的最大值
     */
    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            insert(i);
            int j = getVal(i);
            ans = Math.max(ans, i ^ j);
        }
        return ans;
    }

}
