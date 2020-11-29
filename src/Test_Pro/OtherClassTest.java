package Test_Pro;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class OtherClassTest {
    @Test
    public void systemTest(){
        String javaVersion = System.getProperty("java.version");
        System.out.println("java的version:" + javaVersion);

        String javaHome = System.getProperty("java.home");
        System.out.println("java的home:" + javaHome);

        String osName = System.getProperty("os.name");
        System.out.println("os的home:" + osName);

        String osVersion = System.getProperty("os.version");
        System.out.println("os的version:" + osVersion);

        String userName = System.getProperty("user.name");
        System.out.println("user的name:" + userName);

        String userHome = System.getProperty("user.home");
        System.out.println("user的home:" + userHome);

        String userDir = System.getProperty("user.dir");
        System.out.println("user的dir:" + userDir);
    }

    @Test
    public void mathTest(){
        System.out.println("abs(-1) = "+Math.abs(-1));
        System.out.println("sqrt(9) = "+Math.sqrt(9));
        System.out.println("pow(-2, 3) = "+Math.pow(-2, 3));
        System.out.println("log(e) = "+Math.log(Math.E));
        System.out.println("e^1 = "+Math.exp(1));
        System.out.println("1.2四舍五入 = "+Math.round(1.2));
        System.out.println("1.2上取整 = "+Math.ceil(1.2));
        System.out.println("1.2下取整 = "+Math.floor(1.2));
        System.out.println("pi转角度 = "+Math.toDegrees(Math.PI));
        System.out.println("180转弧度 = "+Math.toRadians(180));
    }

    @Test
    public void bigIntegerBigDecimalTest(){
        // 高精度整型，高精度浮点数
        BigInteger bi = new BigInteger("12312412513521351212");
        BigDecimal bd = new BigDecimal("12345.351");
        BigDecimal bd1 = new BigDecimal("11");
        System.out.println(bi);
        System.out.println(bd.divide(bd1, BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.divide(bd1, 15, BigDecimal.ROUND_HALF_UP));

    }
}
