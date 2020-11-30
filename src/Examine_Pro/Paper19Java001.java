package Examine_Pro;

public class Paper19Java001 {
    public static void main(String args[])
    {
        char   a='x';
        byte   b1=6;
        int    i=100;
        long   b=789L;
        float  f=98.99f;
        double d=4.7788;
        int    aa=a+i;
        //*********Found********
        long bb=b-aa; // long
        float  ff=b1*f;
        //*********Found********
        double dd=ff/aa+d; // double

        System.out.println("aa="+aa);
        System.out.println("bb="+bb);
        System.out.println("ff="+ff);
        System.out.println("dd="+dd);
    }
}
