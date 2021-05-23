package LeetCode_JAVA.TrieTree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/maximum-xor-with-an-element-from-array/
 * 给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。
 * 第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。
 * 换句话说，答案是 max(nums[j] XOR xi) ，其中所有 j 均满足 nums[j] <= mi 。如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。
 * 返回一个整数数组 answer 作为查询的答案，其中 answer.length == queries.length 且 answer[i] 是第 i 个查询的答案。
 *
 * 核心思想：查找数组中的最大异或值，该算法详见 src/LeetCode_JAVA/TrieTree/FindMaximumXOR.java
 */
public class MaximizeXor {

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,4,6,6,3};
        int[][] queries = new int[][]{
                {12, 4},
                {8, 1},
                {6, 3}
        };
        System.out.println(Arrays.toString(new MaximizeXor().maximizeXor(nums, queries)));
    }

    static class Node{ // 记录有nums元素构成的前缀树
        Node[] next;
        Node(){
            next = new Node[2];
        }
    }

    Node root = new Node();

    /**
     * @param num 向前缀树root中添加的结点num值
     */
    public void addTrieNode(int num){
        Node curNode = root;
        for (int i = 31; i >= 0; --i){
            int a = (num >> i) & 1;
            if (curNode.next[a] == null){
                curNode.next[a] = new Node();
            }
            curNode = curNode.next[a];
        }
    }

    /**
     * @param x queries[i][0] 第i组查询的x值
     * @return x与nums前缀树的最大异或值
     */
    public int cal(int x){
        Node curNode = root;
        int ans = 0; // ans为前缀树内与x异或值最大所对应的数
        for (int i = 31; i >= 0; --i){
            int xa = (x >> i) & 1, xb = 1 - xa;
            if (curNode.next[xb] != null){
                ans |= (xb << i);
                curNode = curNode.next[xb];
            } else {
                ans |= (xa << i);
                curNode = curNode.next[xa];
            }
        }
        return ans ^ x;
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Map<int[], Integer> map = new HashMap<>(); // map记录每条查询的初始下标
        for (int i = 0; i < queries.length; ++i) map.put(queries[i], i);
        Arrays.sort(nums);           // 对nums排序(这样可以使前缀树的结点依大小依次添加)
        Arrays.sort(queries, Comparator.comparingInt(o -> o[1])); // 对queries的限制值进行排序
        int loc = 0;                 // 记录放入Trie中的nums元素的最大下标
        int n = queries.length;
        int[] res = new int[n];
        for (int[] query : queries){ // 对每条查询依次处理
            int x = query[0], bound = query[1];
            while (loc < nums.length && nums[loc] <= bound){ // 添加前缀树中的结点，直到满足bound要求
                addTrieNode(nums[loc++]);
            }
            if (loc == 0){ // loc = 0时为bound小于所有num，此时直接查询结果为-1
                res[map.get(query)] = -1;
            } else { // 在已构造前缀树中查询最大结果
                res[map.get(query)] = cal(x);
            }
        }
        return res;
    }

}
