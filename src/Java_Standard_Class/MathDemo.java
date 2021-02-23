package Java_Standard_Class;

public class MathDemo {
    public static void main(String[] args) {
        double radians = 2 * Math.PI;
        double d1 = 3.14159265;
        System.out.println("ceil函数：" + Math.ceil(d1)); // 上取整
        System.out.println("floor函数：" + Math.floor(d1)); // 下取整
        System.out.println("round函数：" + Math.round(d1)); // 四舍五入
        System.out.println("exp函数：" + Math.exp(d1)); // e为底的d1次幂
        System.out.println("pow函数：" + Math.pow(Math.E, d1)); // e为底的d1次幂
        System.out.println("sin函数：" + Math.sin(Math.PI / 6)); // sin
        System.out.println("asin函数：" + Math.asin(0.5)); // arcsin
        System.out.println("log函数：" + Math.log(Math.E)); // log_e(x)
        System.out.println("弧度转角度：" + Math.toDegrees(radians)); // 弧度转角度
        System.out.println("random函数1：" + Math.random()); //
        System.out.println("random函数2：" + Math.random()); //
        for (int i = 0; i <= 100; i++) {
            System.out.println(Math.random());
        }
    }
}
