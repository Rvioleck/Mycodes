package Examine_Pro;

public class Paper9Java002 {

    public static void main(String args[]) {
        SubClass subC = new SubClass();
        subC.doSomething();
    }
}
class SuperClass {

    int x;

    SuperClass() {
        //*********Found********
        x = 3; // 3
        System.out.println("in SuperClass : x=" + x);
    }

    void doSomething() {
        //*********Found********
        System.out.println("in SuperClass.doSomething()"); // in SuperClass.doSomething
    }
}

class SubClass extends SuperClass {

    int x;

    SubClass() {
        super();
        //*********Found********
        x = 5; // 5
        System.out.println("in SubClass  :x=" + x);
    }

    void doSomething() {
        super.doSomething();
        //*********Found********
        System.out.println("in SubClass.doSomthing()"); // in SubClass.doSomthing
        System.out.println("super.x=" + super.x + "  sub.x=" + x);
    }
}
