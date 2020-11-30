package Examine_Pro;

public class Paper20Java001 {
    public static void main(String args[])
    {
        //*********Found********
        char a='w';
        byte   b1=6;
        int    i=500;
        long   b=123L;
        float  f=98.99f;
        double d=4.7788;
        //*********Found********
        int aa=a+i;
        long   bb=b-aa;
        float  ff=b1*f;
        double dd=ff/aa+d;

        System.out.println("aa="+aa);
        System.out.println("bb="+bb);
        System.out.println("ff="+ff);
        System.out.println("dd="+dd);
    }
}
