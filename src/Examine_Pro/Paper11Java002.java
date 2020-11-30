package Examine_Pro;

public class Paper11Java002 {
    public static void main(String[] args)
    {
        System.out.println("观察triple方法参数 double 10.0 的改变：");
        //*********Found**********
        double canshu = 10; // double
        //*********Found**********
        System.out.println("参数*３前，参数值为 " +canshu); // canshu
        triple(canshu);
        System.out.println("在triple方法外，参数值仍为 " + canshu);
        System.out.println("思考：方法能否改变参数值？");
    }
    //*********Found**********
    public static void triple(double x) // triple
    {
        x = 3 * x;
        //*********Found**********
        System.out.println("在triple方法内，参数 10 变为 " + x); // x
    }
}
