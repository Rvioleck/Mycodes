package Test_Pro;

public class MyTest {
    public static void main(String[] args) {
        int i = 0, j = 0;
        for (j = 1; j < 100; j++) {
            i += j;
        }
        System.out.println(i); // 注意输出的是i还是j
    }
}
