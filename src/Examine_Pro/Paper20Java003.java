package Examine_Pro;

public class Paper20Java003 {
    public static void main(String[] args){
        String num;
        if(args.length > 0)
            //*********Found********
            num = args[0]; //args[0]
        else
            num = "5";
        //*********Found********
        int input = Integer.parseInt(num); // num
        double result = factorial(input);
        System.out.println(input+ " 的阶乘是 "+ result);
    }
    public static double factorial(int x){
        if( x < 0 )
            return 0.0;
        double fact = 1.0;
        while(x > 1){
            //*********Found********
            fact =fact *x; // =fact
            x = x-1;
        }
        return fact;
    }
}
