package Examine_Pro;

public class Paper15Java002 {
    public static void main(String args[]) {
        //*********Found**********
        int a[][] = new int[5][5]; // new
        int i,j,k=1;
        for(i=0;i<5;i++)
            for(j=0;j<5;j++)
                if((i+j)<5){
                    a[i][j]=k;
                    k++;
                }else
                    //*********Found**********
                    a[i][j]=0; // a[i][j]=0
        for(i=0;i<5;i++){
            for(j=0;j<5;j++)
                if(a[i][j]<10)
                    System.out.print(a[i][j]+ "   ");
                else
                    System.out.print(a[i][j]+ "  ");
            System.out.println();
        }
    }
}
