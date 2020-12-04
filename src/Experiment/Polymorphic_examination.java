package Experiment;

abstract class Shape{
    abstract void draw();
}

class J_Circle extends Shape{
    void draw(){
        System.out.println("draw a circle.");
    }
}

class J_Square extends Shape{
    void draw(){
        System.out.println("draw a square.");
    }
}

public class Polymorphic_examination {
    public static void main(String[] args) {
        J_Square square = new J_Square();
        Shape circle = new J_Circle();
        square.draw();
        circle.draw();
    }
}
