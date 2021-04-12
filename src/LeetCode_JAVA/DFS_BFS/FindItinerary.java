package LeetCode_JAVA.DFS_BFS;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/reconstruct-itinerary/
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 * 提示：
 * 如果存在多种有效的行程，请你按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 所有的机票必须都用一次 且 只能用一次。
 */
public class FindItinerary {

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        List<String> ticket1 = new ArrayList<String>() {
            {
                add("JFK");
                add("SFO");
            }
        };
        List<String> ticket2 = new ArrayList<String>() {
            {
                add("JFK");
                add("ATL");
            }
        };
        List<String> ticket3 = new ArrayList<String>() {
            {
                add("SFO");
                add("ATL");
            }
        };
        List<String> ticket4 = new ArrayList<String>() {
            {
                add("ATL");
                add("JFK");
            }
        };
        List<String> ticket5 = new ArrayList<String>() {
            {
                add("ATL");
                add("SFO");
            }
        };
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        System.out.println(new FindItinerary().findItinerary(tickets));
    }

    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> itinerary = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<>());
            }
            map.get(src).offer(dst);
        }
        dfs("JFK");
        Collections.reverse(itinerary);
        return itinerary;
    }

    private void dfs(String curr) {
        // 后序遍历 子-根(itinerary结果为倒序)
        while (map.containsKey(curr) && map.get(curr).size() > 0) {
            String tmp = map.get(curr).poll();
            dfs(tmp);
        }
        itinerary.add(curr);
    }
}
