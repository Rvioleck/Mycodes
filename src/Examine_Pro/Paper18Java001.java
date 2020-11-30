package Examine_Pro;

public class Paper18Java001 {
    public static void main(String args[])
    {
        char   a='r';
        byte   b=8;
        int    i=55;
        //*********Found********
        long   n=1024L; // long
        float  f=103.7f;
        //*********Found********
        double d=954.2431; // double
        int    a1=a+i;
        long   n1=n-a1;
        float  f1=b*f;
        double d1=f1/a1+d;
        System.out.println("a1="+a1);
        System.out.println("n1="+n1);
        System.out.println("f1="+f1);
        System.out.println("d1="+d1);
    }
}
