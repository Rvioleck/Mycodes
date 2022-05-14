package LeetCode_JAVA.HashTable;

public class CountConsistentStrings {

    public int countConsistentStrings(String allowed, String[] words) {
        int res = 0;
        int[] set = new int[26];
        int len = allowed.length();
        for (int i = 0; i < len; ++i){
            set[allowed.charAt(i) - 'a'] = 1;
        }
        for (String word : words){
            len = word.length();
            int i;
            for (i = 0; i < len; ++i){
                if (set[word.charAt(i) - 'a'] == 0) break;
            }
            if (i == len){
                res++;
            }
        }
        return res;
    }



}
