package Lanqiao.Provincial10th;

import java.util.LinkedList;
import java.util.Queue;

public class G_CompleteBinaryTree_C {

    private int getMaxFloorWeight(int[] tree, int len){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);  // bfs 第一个结点入队

        int maxWeight = tree[0];  // 初始最大权值为根节点权值
        int maxHeight = 1;        // 初始最大高度为根节点高度

        int currWeight = 0;
        int currHeight = 1;       // 根节点从1层开始

        int size = 1; // 队列的初始大小为1
        while (!queue.isEmpty()){ // bfs模板
            //<editor-fold desc="对每层的结点进行计算，得到当前权值">
            currHeight += 1;      // 每层都为上一层数+1
            while (size-- != 0){  // size的大小即为当前queue的大小，此时queue所包含元素必为同一层元素
                int node = queue.remove();   // 求得当前结点坐标
                int left = node * 2 + 1, right = node * 2 + 2; // 对于顺序存储的树，左孩子和右孩子坐标
                if (left < len){  // 左孩子存在
                    queue.offer(left);        // 左孩子入队
                    currWeight += tree[left]; // 当前层的权值累加
                }
                if (right < len){ // 右孩子存在
                    queue.offer(right);
                    currWeight += tree[right];
                }
            }
            //</editor-fold>
            if (currWeight > maxWeight){  // 当前层权值大于以往权值，进行记录
                maxWeight = currWeight;   // 更改当前最大权值
                maxHeight = currHeight;   // 记录最大权值层数
            }
            currWeight = 0;        // 下层开始时currWeight应为0
            size = queue.size();   // 记录队列中结点个数
        }
        return maxHeight;
    }

    public static void main(String[] args) {
        int[] tree = new int[]{1, 6, 5, 4, 3, 2, 1};
        int len = 7;
        //<editor-fold desc="get initiate data">
//        Scanner sc = new Scanner(System.in);
//        int len = sc.nextInt();
//        int[] tree = new int[len];
//        for (int i = 0; i < len; i++) {
//            tree[i] = sc.nextInt();
//        }
        //</editor-fold>
        System.out.println(new G_CompleteBinaryTree_C().getMaxFloorWeight(tree, len));
    }

}
