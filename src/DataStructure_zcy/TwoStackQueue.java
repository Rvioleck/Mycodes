package DataStructure_zcy;

import java.util.Stack;

public class TwoStackQueue {

    private final Stack<Integer> stackPush;
    private final Stack<Integer> stackPop;

    public TwoStackQueue(){
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void push(int e){
        stackPush.push(e);
    }

    public int pop(){
        if (stackPop.isEmpty() && stackPush.isEmpty()){
            throw new RuntimeException("Queue is Empty!");
        }
        if (stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }


    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();
        queue.push(2);
        queue.push(3);
        queue.push(1);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

}
