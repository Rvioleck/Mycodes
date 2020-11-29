package LeetCode_JAVA;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List list = new ArrayList();
        for (int i = left; i <= right ; i++) {
            if (isDividing(i)){
                list.add(i);
            }
        }
        return list;
    }

    public boolean isDividing(int num){
        int num1 = num;
        while (num1 != 0){
            int digit = num1 % 10;
            if (digit == 0 || num % digit != 0) {
                return false;
            }
            num1 /= 10;
        }
        return true;
    }

    @Test
    public void test(){
        int num = 10;
        System.out.println(isDividing(num));
    }
}
