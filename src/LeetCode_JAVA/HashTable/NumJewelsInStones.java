package LeetCode_JAVA.HashTable;

public class NumJewelsInStones {

    /*
    * https://leetcode.cn/problems/jewels-and-stones/
    * */

    public int numJewelsInStones(String jewels, String stones) {
        int[] map = new int[255];
        for (int i = 0; i < jewels.length(); ++i){
            char c = jewels.charAt(i);
            map[c] = 1;
        }
        int res = 0;
        for (int i = 0; i < stones.length(); ++i){
            char c = stones.charAt(i);
            if (map[c] == 1){
                res += 1;
            }
        }
        return res;
    }

}
