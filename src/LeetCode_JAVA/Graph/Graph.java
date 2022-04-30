package LeetCode_JAVA.Graph;

import org.junit.Test;

import java.util.*;

public class Graph {

    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph(){
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }

    class Node{
        public int value;
        public int in;   // 入度
        public int out;  // 出度
        public ArrayList<Node> nexts; // 直接邻居
        public ArrayList<Edge> edges; // 起始于该点的边

        public Node(int value){
            this.value = value;
            in = 0;
            out = 0;
            nexts = new ArrayList<>();
            edges = new ArrayList<>();
        }
    }

    class Edge{
        public int weight; // 权重
        public Node from;  // 起点
        public Node to;    // 终点

        public Edge(int weight, Node from, Node to){
            this.weight = weight;
            this.from = from;
            this.to = to;
        }
    }

    public void createGraph(Integer[][] matrix){
        /* matrix为三元组，N×3的矩阵，[from, to, weight] */
        Graph graph = new Graph();
        for (Integer[] point : matrix) {
            Integer from = point[0];
            Integer to = point[1];
            Integer weight = point[2];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
    }

    public void bfs(Node node){
        if (node == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next: cur.nexts){
                if (!set.add(next)){
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }

    public void dfs(Node node){
        if (node == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            for (Node next: cur.nexts){
                if (!set.contains(next)){
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }

    public List<Node> sortedTopology(Graph graph){
        HashMap<Node, Integer> inMap = new HashMap<>(); // [结点, 入度]
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node: graph.nodes.values()){
            inMap.put(node, node.in);
            if (node.in == 0){
                zeroInQueue.add(node);
            }
        }
        List<Node> res = new ArrayList<>();
        while (!zeroInQueue.isEmpty()){
            Node cur = zeroInQueue.poll();
            res.add(cur);
            for (Node next: cur.nexts){
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0){
                    zeroInQueue.add(next);
                }
            }
        }
        return res;
    }



}



