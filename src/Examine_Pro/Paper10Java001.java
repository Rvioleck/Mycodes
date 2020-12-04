package Examine_Pro;

public class Paper10Java001 extends TT
{
    //*********Found**********
    public static void main(String args[]) // main String
    {
        Paper10Java001 t = new Paper10Java001("小龙");
    }
    public Paper10Java001(String s)
    {
        super(s);
        System.out.println("您好吗？");
    }
    public Paper10Java001()
    {
        this("我是文朋");
    }
}

class TT
{
    public TT()
    {
        System.out.println("多高兴啊!");
    }
    public TT(String s)
    {
        //*********Found**********
        this(); // this()
        System.out.println("我是"+s);
    }
}
