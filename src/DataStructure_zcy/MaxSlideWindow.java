package DataStructure_zcy;

import java.util.LinkedList;

public class MaxSlideWindow {

    private int L;
    private int R;
    private final int[] arr;
    private final LinkedList<Integer> qmax;

    public MaxSlideWindow(int[] a){
        // 左开右闭
        arr = a;
        L = -1;
        R = 0;
        qmax = new LinkedList<>();
    }

    public void addNumFromRight(){
        if (R == arr.length){
            return;
        }
        while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]){
            qmax.pollLast();
        }
        qmax.addLast(R);
        R++;
    }

    public void removeNumFromLeft(){
        if (L >= R - 1){
            return;
        }
        L++;
        if (qmax.peekFirst() == L){
            qmax.pollFirst();
        }
    }

    public Integer getMax(){
        if (!qmax.isEmpty()){
            return arr[qmax.peekFirst()];
        }
        return null;
    }

    public static int[] getMaxWindow(int[] arr, int w){
        if (arr == null || w < 1 || arr.length < w){
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; ++i){ // 右窗口R=i
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
                // 右窗口右扩
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w){ // 左窗口L=i-w+1
                // 左窗口右扩
                qmax.pollFirst();
            }
            if (i - w + 1 >= 0){
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
