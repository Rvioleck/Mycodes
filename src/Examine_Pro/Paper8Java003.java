package Examine_Pro;

public class Paper8Java003 {
    //点的坐标
    int x,y;
    //无参数的构造方法
    public Paper8Java003() {}
    //带两个参数的构造方法
    //*********Found********
    public Paper8Java003(int x,int y){this.x = x; this.y = y;} // this.x = x; this.y = y;
    //带一个参数的构造方法
    //*********Found********
    public Paper8Java003(Paper8Java003 p){x=p.x; y=p.y;} // x=p.x; y=p.y
    //以对象的形式返回当前点的位置
    public Paper8Java003 getLocation(){
        //*********Found********
        Paper8Java003 p=new Paper8Java003(x, y);    //实例化一个Java_3对象  //new Java_3(x, y)
        //*********Found********
        return p;             //返回对象p // return p
    }

    //返回点的横坐标
    public int getX(){return x;}
    //返回点的纵坐标
    public int getY(){return y;}
    //把当前点移到新的位置（x，y）上
    public void move(int x,int y){this.x = x;this.y = y;}
    //以(x，y)的格式返回点的位置
    public String toString(){return "("+x+","+y+")";}
    //在原有坐标上分别增加x和y
    public void translate(int x,int y){this.x += x;this.y += y;}
    //主方法
    public static void main(String args[]){
        //生成一个对象(5,5)
        //*********Found********
        Paper8Java003 p=new Paper8Java003(5,5); // new Java_003(5,5)
        System.out.println("x="+ p.x+" y="+ p.y);
        //以(x,y)的方式打印坐标的位置
        System.out.println("Location is"+ p.toString());
        //在原有位置上增加（3，4）
        //*********Found********
        p.translate(3, 4); //p.translate(3, 4)
        //打印横坐标和纵坐标的值
        System.out.println("x="+ p.x+" y="+ p.y);
        //以(x,y)的方式打印坐标的位置
        System.out.println("Location is"+ p.toString());
    }
}
