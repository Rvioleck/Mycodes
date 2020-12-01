package Examine_Pro;

public class Paper27Java001 {
    public static void main(String args[])
    {
        char   a='h';
        byte   b1=6;
        //*********Found********
        int i=200; // int
        //*********Found********
        long b=567L; // long
        float  f=98.99f;
        double d=4.7788;
        int    aa=a+i;
        long   bb=b-aa;
        float  ff=b1*f;
        double dd=ff/aa+d;

        System.out.println("aa="+aa);
        System.out.println("bb="+bb);
        System.out.println("ff="+ff);
        System.out.println("dd="+dd);
    }
}
