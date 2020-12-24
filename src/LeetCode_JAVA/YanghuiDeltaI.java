package LeetCode_JAVA;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class YanghuiDeltaI {
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> oneRow = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i){
                    oneRow.add(1);
                }
                else{
                    oneRow.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
                }
            }
            result.add(oneRow);
        }
        return result;
    }

    @Test
    public void test(){
        int numRows = 5;
        YanghuiDeltaI obj = new YanghuiDeltaI();
        List<List<Integer>> result = obj.generate(numRows);
        System.out.println(result);
    }

}
