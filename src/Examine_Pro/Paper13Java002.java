package Examine_Pro;

import java.io.File;
public class Paper13Java002 {
    public static void main(String s[])
    {
        //Getting the Current Working Directory
        String curDir = System.getProperty("user.dir");
        System.out.println("当前的工作目录是:"+curDir);

        //*********Found**********
        File ff=new File(curDir); // curDir
        String[] files=ff.list();
        for(int i=0; i<files.length; i++)
        {
            String ss=curDir+"\\"+files[i];
            traverse(0,ss);
        }
    }

    /**
     * 递归地遍历目录树
     * @param  level 目录的层次
     * @param  s     当前目录路径名
     */
    public static void traverse(int level,String s)
    {
        File f=new File(s);
        for(int i=0; i<level; i++) System.out.print("   ");
        if(f.isFile())
        {
            System.out.println(f.getName());
        }
        else if(f.isDirectory())
        {
            //*********Found**********
            System.out.println("<"+f.getName()+">"); // getName()
            String[] files=f.list();
            level++;
            //*********Found**********
            for(int i=0; i<files.length; i++) // i++
            {
                String ss=s+"\\"+files[i];
                //*********Found**********
                traverse(level,ss); // level
            }
        }
        else
        {
            System.out.println("ERROR!");
        }
    }
}
