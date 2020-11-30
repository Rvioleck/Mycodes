package Examine_Pro;

class Variable{
    int x=0,y=0,z=0;//类变量
    void init(int x,int y){
        //*********Found********
        this.x=x; // this.x
        this.y=y;
        int z=5;  //局部变量
        System.out.println("*****在初始化中*****");
        System.out.println("x = "+x+"   y = "+y+"   z ="+z);
    }
}

public class Paper22Java001{
    public static void main (String[] args){
        //*********Found********
        Variable  v = new Variable(); // Variable()
        System.out.println("*****在初始化之前*****");
        System.out.println("x = "+v.x+"   y = "+v.y+"   z ="+v.z);
        v.init(20,30);
        System.out.println("*****在初始化之后*****");
        System.out.println("x = "+v.x+"   y = "+v.y+"   z ="+v.z);
    }
}
