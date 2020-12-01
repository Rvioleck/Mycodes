package Examine_Pro;

public class Paper25Java003 {
    public static void main(String[] args)
    {
        String num;
        if(args.length > 0)
            //*********Found********
            num = args[0]; // args[0]
        else
            num = "5";
        //*********Found********
        int input = Integer.parseInt(num); // num
        int result = Java_3(input);
        System.out.println(input+ " 的阶乘是 "+ result);
    }

    public static int Java_3(int x)
    {
        if( x < 0 )
            return 0;
        int fact = 1;
        while(x > 1)
        {
            //*********Found********
            fact = fact * x; // fact
            x = x-1;
        }
        return fact;
    }
}
