package DataStructure_zcy;

import java.util.HashMap;

class Node {
    public String str;
    public int times;

    public Node(String s, int t) {
        str = s;
        times = t;
    }
}

public class TopKHeap {
    private final HashMap<String, Node> strNodeMap;
    private final Node[] heap;
    private final HashMap<Node, Integer> nodeIndexMap; // 位置map，用于快速找到结点在堆中的位置
    private int heapSize;

    public TopKHeap(int K) {
        heap = new Node[K];  // 堆结构
        heapSize = 0; // 堆大小
        strNodeMap = new HashMap<>(); // 词频map
        nodeIndexMap = new HashMap<>(); // 位置map
    }

    public void add(String str) {
        Node curNode; // 当前str对应的结点对象
        int preIndex = -1;  // 当前str对应的结点对象在堆上的位置
        if (!strNodeMap.containsKey(str)) {  // str之前不在堆上
            curNode = new Node(str, 1);
            strNodeMap.put(str, curNode);  // 添加到词频map中
            nodeIndexMap.put(curNode, -1); // 添加到位置map中
        } else {
            curNode = strNodeMap.get(str); // 获取结点对象
            curNode.times++; // 出现次数加一
            preIndex = nodeIndexMap.get(curNode); // 原本str在堆上的位置
        }
        if (preIndex == -1){  // 原本str不在堆上
            if (heapSize == heap.length){ // 堆满
                if (heap[0].times < curNode.times){ // 与堆顶比较
                    nodeIndexMap.put(heap[0], -1);  // 更新原本堆顶下标记录
                    heap[0] = curNode; // 将当前元素置于堆顶
                    nodeIndexMap.put(curNode, 0);   // 更新当前元素在堆顶下标
                    heapify(0, heapSize);  // 调整堆结构
                }
            } else { // 堆不满
                heap[heapSize] = curNode; // 插入到堆尾
                nodeIndexMap.put(curNode, heapSize); // 更新下标记录
                heapInsert(heapSize++);  // 调整堆结构
            }
        } else {
            heapify(preIndex, heapSize);
        }
    }

    private void heapInsert(int i) {
        while (heap[i].times > heap[(i - 1) / 2].times){
            swap(i, (i - 1) >> 1);
            i = ((i - 1) >> 1);
        }
    }

    private void heapify(int i, int len) {
        int left = 2 * i + 1;
        while (left < len){
            int largest =
                    left + 1 < len && heap[left + 1].times > heap[left].times
                    ? left + 1 : left;
            largest = heap[largest].times > heap[i].times ? largest : i;
            if (largest == i) break;
            swap(i, largest);
            i = largest;
            left = 2 * i + 1;
        }
    }

    private void swap(int i, int j) {
        nodeIndexMap.put(heap[i], j);
        nodeIndexMap.put(heap[j], i);
        Node temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void printTopK(){
        System.out.println("TOP: ");
        for (int i = 0; i != heap.length; ++i){
            if (heap[i] == null) break;
            System.out.print("Str: " + heap[i].str);
            System.out.println(" Times: " + heap[i].times);
        }
    }

    public static void main(String[] args) {
        TopKHeap heap = new TopKHeap(3);
        heap.add("1");
        heap.add("3");
        heap.add("2");
        heap.add("4");
        heap.add("2");
        heap.add("5");
        heap.add("3");
        heap.add("4");
        heap.add("3");
        heap.add("6");
        heap.add("1");
        heap.printTopK();
        heap.add("1");
        heap.add("1");
        heap.printTopK();
    }

}
