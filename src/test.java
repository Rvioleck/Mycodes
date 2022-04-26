import org.junit.Test;
import static org.junit.Assert.*;

public class test {

    /**
     * @param a int
     * @param b int
     * @return
     */
    public long sum(int a, int b){
        long sum = (long)a + (long)b;
        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
            return sum;
        }
        return a + b;
    }

    @Test
    public void sumTest1(){
        assertEquals(3, new test().sum(1, 2));
        assertEquals(2147483649L, new test().sum(Integer.MAX_VALUE, 2));
        assertEquals(-2147483648L, new test().sum(Integer.MIN_VALUE, -1));
    }

    @Test
    public void sumTest2(){
        int sum = 3;
        int a = 1, b = 2;
        assertEquals(a + b, new test().sum(a, b));
    }



}
