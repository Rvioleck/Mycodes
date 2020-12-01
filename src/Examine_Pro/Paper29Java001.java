package Examine_Pro;

public class Paper29Java001 {
    public static void main(String args[])
    {
        char   a='p';
        byte   b1=6;
        int    i=400;
        long   b=345L;
        float  f=98.99f;
        double d=4.7788;
        //*********Found********
        int aa=a+i; // int
        long   bb=b-aa;
        //*********Found********
        float ff=b1*f; // float
        double dd=ff/aa+d;

        System.out.println("aa="+aa);
        System.out.println("bb="+bb);
        System.out.println("ff="+ff);
        System.out.println("dd="+dd);
    }
}
