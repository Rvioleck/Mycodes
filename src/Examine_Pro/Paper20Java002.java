package Examine_Pro;

import java.util.*;

public class Paper20Java002 {
    public static void main(String[] args)
    {
        Student2[] java = new Student2[3];
        java[0] = new Student2("李明", 80);
        java[1] = new Student2("赵冬", 75);
        java[2] = new Student2("王晓", 98);
        //*********Found**********
        Arrays.sort(java); // java
        System.out.println("Java 成绩降序排序的结果是：");
        for (int i = 0; i < java.length; i++)
        {
            Student2 e = java[i];
            //*********Found**********
            System.out.println("name=" + e.getName() // getName()
                    + ",fenshu=" + e.getFenshu());
        }
    }
}

//*********Found**********
class Student2 implements Comparable // implements
{
    public Student2(String n, double f)
    {
        name = n;
        fenshu = f;
    }
    public String getName()
    {
        return name;
    }
    public double getFenshu()
    {
        return fenshu;
    }
    public int compareTo(Object otherObject)
    {
        Student2 other = (Student2)otherObject;
        if (fenshu < other.fenshu) return 1;
        if (fenshu > other.fenshu) return -1;
        return 0;
    }
    private String name;
    //*********Found**********
    private double fenshu; // double
}
