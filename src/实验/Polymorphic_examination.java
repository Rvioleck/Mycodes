package 实验;

import org.junit.Test;

public class Polymorphic_examination {
    abstract class Shape{
        abstract void draw();
    }

    public class J_Circle extends Shape{
        void draw(){
            System.out.println("draw a circle.");
        }
    }

    public class J_Square extends Shape{
        void draw(){
            System.out.println("draw a square.");
        }
    }

    @Test
    public void Test_Shape(){
        J_Square square = new J_Square();
        Shape circle = new J_Circle();
        square.draw();
        circle.draw();
    }
}
