package LeetCode_JAVA;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class YangHuiDeltaII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(0, 1);
        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j >= 1; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
            res.add(i + 1, 1);
        }
        return res;
    }

    @Test
    public void test() {
        int rowIndex = 3;
        System.out.println(getRow(rowIndex));
    }
}
