package Examine_Pro;

public class Paper15Java001 {
    public static void main(String[] args) {
        int []a = {5,9,2,8,7};
        int max = 0;
        int k = 0,t ;
        for(int i=0;i<5;i++){
            //*********Found********
            if (a[i]%2==0 && max < a[i]){ // %2==0
                max = a[i];
                //*********Found********
                k = i; // k = i
            }
        }
        t = a[0];
        a[0] = a[k];
        a[k] = t;
        //*********Found********
        for(int i=0;i<a.length;i++)
            System.out.print(a[i] + "  ");
    }
}
