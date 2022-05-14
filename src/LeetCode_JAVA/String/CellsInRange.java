package LeetCode_JAVA.String;

import java.util.ArrayList;
import java.util.List;

public class CellsInRange {
    /*
    * https://leetcode.cn/problems/cells-in-a-range-on-an-excel-sheet/
    * */

    public List<String> cellsInRange(String s) {
        List<String> res = new ArrayList<>();
        String[] points = s.split(":");
        char col1 = points[0].charAt(0);
        char col2 = points[1].charAt(0);
        int row1 = Integer.parseInt(points[0].substring(1));
        int row2 = Integer.parseInt(points[1].substring(1));
        for (char i = col1; i <= col2; i++){
            for (int j = row1; j <= row2; j++){
                res.add(i + String.valueOf(j));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CellsInRange().cellsInRange("K1:L2"));
    }

}
