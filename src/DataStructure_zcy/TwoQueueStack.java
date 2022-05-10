package DataStructure_zcy;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueueStack {

    private Queue<Integer> queuePush;//输入队列
    private Queue<Integer> queuePop;//输出队列

    public TwoQueueStack(){
        queuePush = new LinkedList<>();
        queuePop = new LinkedList<>();
    }

    public void push(int e){
        queuePush.offer(e);
        while (!queuePop.isEmpty()){
            queuePush.offer(queuePop.remove());
        }
        Queue<Integer> temp = queuePush;
        queuePush = queuePop;
        queuePop = temp;
    }

    public int pop(){
        return queuePop.remove();
    }

    public static void main(String[] args) {
        TwoQueueStack stack = new TwoQueueStack();
        stack.push(1);
        stack.push(3);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
