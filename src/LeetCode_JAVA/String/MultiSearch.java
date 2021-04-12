package LeetCode_JAVA.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiSearch {

    public int[][] multiSearch(String big, String[] smalls) {
        int[][] res = new int[smalls.length][];
        int index = 0;
        for (String small :
                smalls) {
            List<Integer> smallIndex = new ArrayList<>();
            int i = -1;
            do {
                i = big.indexOf(small, i + 1);
                if (i != -1 && !small.equals("")) {
                    smallIndex.add(i);
                }
            } while (i != -1 && !small.equals(""));
            res[index++] = smallIndex.stream().mapToInt(Integer::valueOf).toArray();
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] res = new MultiSearch().multiSearch("aaaa", new String[]{
                "a", "ppi", "hi", "sis", "i", "ssippi"
        });
        for (int[] oneLine :
                res) {
            System.out.println(Arrays.toString(oneLine));
        }
    }

}
