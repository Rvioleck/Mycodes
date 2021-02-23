package Experiment;

interface Vehicle {
    void start();

    void stop();
}

class Car implements Vehicle {
    public void start() {
        System.out.println("car start!");
    }

    public void stop() {
        System.out.println("car stop!");
    }
}

class Bike implements Vehicle {
    public void start() {
        System.out.println("bike start!");
    }

    public void stop() {
        System.out.println("bike stop!");
    }
}

public class Interface_examination {
    public static void main(String[] args) {
        Vehicle audi = new Car();
        Vehicle yongjiu = new Bike();
        audi.start();
        audi.stop();
        yongjiu.start();
        yongjiu.stop();
    }
}
