package Examine_Pro;

import java.util.*;

public class Paper20Java002 {
    public static void main(String[] args)
    {
        Student[] java = new Student[3];
        java[0] = new Student("李明", 80);
        java[1] = new Student("赵冬", 75);
        java[2] = new Student("王晓", 98);
        //*********Found**********
        Arrays.sort(java); // java
        System.out.println("Java 成绩降序排序的结果是：");
        for (int i = 0; i < java.length; i++)
        {
            Student e = java[i];
            //*********Found**********
            System.out.println("name=" + e.getName() // getName()
                    + ",fenshu=" + e.getFenshu());
        }
    }
}

//*********Found**********
class Student implements Comparable // implements
{
    public Student(String n, double f)
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
        Student other = (Student)otherObject;
        if (fenshu < other.fenshu) return 1;
        if (fenshu > other.fenshu) return -1;
        return 0;
    }
    private String name;
    //*********Found**********
    private double fenshu; // double
}
