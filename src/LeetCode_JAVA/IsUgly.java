package LeetCode_JAVA;

import org.junit.Test;

public class IsUgly {
    public boolean isUgly(int num) {
        if (num >= 1 && num <= 6){
            return true;
        }
        if (num/2 < 6){
            for (int i = 6; i < num; i++) {
                if (num % i == 0)
                    return false;
            }
        }else{
            for (int i = 6; i<= num/2; i++){
                if (num % i == 0)
                    return false;
            }
        }
        if (num % 2 == 0 || num % 3 == 0 || num % 5 == 0){
            return true;
        }
        return false;
    }

    @Test
    public void isUglyTest(){
        int num = 17;
        System.out.println(isUgly(num));
    }
}
