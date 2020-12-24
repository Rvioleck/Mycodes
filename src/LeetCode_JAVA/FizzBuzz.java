package LeetCode_JAVA;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n){
        List<String> result = new ArrayList<String>();
        for (int i = 1; i <= n ; i++) {
            if (i%5 == 0 && i%3 == 0){
                result.add("FizzBuzz");
            }
            else if (i%3 == 0){
                result.add("Fizz");
            }
            else if (i%5 == 0){
                result.add("Buzz");
            } else{
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

    @Test
    public void test(){
        FizzBuzz obj = new FizzBuzz();
        List<String> result = new ArrayList<String>();
        int n = 15;
        result = obj.fizzBuzz(n);
        System.out.println(result);
    }
}
