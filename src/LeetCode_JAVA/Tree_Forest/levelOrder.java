package LeetCode_JAVA.Tree_Forest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}

public class levelOrder {

    /**
     * N叉树的层次遍历
     * https://www.lintcode.com/problem/1533
     */


    public List<List<Integer>> levelOrder(UndirectedGraphNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> levelValues = new ArrayList<>();
        levelValues.add(root.label);
        res.add(levelValues);
        while (!queue.isEmpty()){
            int size = queue.size();
            levelValues = new ArrayList<>();
            while (size-- != 0){
                root = queue.poll();
                for (UndirectedGraphNode child: root.neighbors){
                    if (child != null){
                        levelValues.add(child.label);
                        queue.offer(child);
                    }
                }
            }
            if (levelValues.size() != 0){
                res.add(levelValues);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
