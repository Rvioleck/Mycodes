package LeetCode_JAVA.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams2 {

    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        HashMap<String, HashMap<Character, Integer>> map = new HashMap<>();
        for (String s : strs) {
            HashMap<Character, Integer> content = new HashMap<>();
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                content.put(ch, content.getOrDefault(ch, 0) + 1);
            }
            map.put(s, content);
        }
        List<List<String>> res = new ArrayList<>();
        boolean[] tag = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (tag[i]) continue;
            tag[i] = true;
            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            for (int j = i + 1; j < len; j++) {
                if (tag[j]) continue;
                if (map.get(strs[i]).equals(map.get(strs[j]))) {
                    group.add(strs[j]);
                    tag[j] = true;
                }
            }
            res.add(group);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new GroupAnagrams2().groupAnagrams(new String[]{
                "eat", "tea", "tan", "ate", "nat", "bat"
        }));
    }
}
