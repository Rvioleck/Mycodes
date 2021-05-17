package LeetCode_JAVA.TrieTree;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 */
public class FindRepeatNumber {

    public static void main(String[] args) {
        System.out.println(new FindRepeatNumber().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }

    static class Node {
        Node[] next;
        boolean isEnd;
        Node(){
            next = new Node[2];
            isEnd = false;
        }
    }

    Node root = new Node();

    public boolean insert(int num){
        Node curNode = root;
        for (int i = 16; i >= 0; --i){
            // 2~100000  < 2^17
            int a = (num >> i) & 1;
            if (curNode.next[a] == null){
                curNode.next[a] = new Node();
            }
            curNode = curNode.next[a];
        }
        if (!curNode.isEnd){
            curNode.isEnd = true;
            return false;
        } else return true;
    }

    public int findRepeatNumber(int[] nums) {
        for (int num : nums){
            if (insert(num)){
                return num;
            }
        }
        return -1;
    }

}
