package LeetCode_JAVA.String;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str :
                strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> group = map.getOrDefault(key, new ArrayList<>());
            group.add(str);
            map.put(key, group);
        }
        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{
                "eat", "tea", "tan", "ate", "nat", "bat"
        }));
    }

}
