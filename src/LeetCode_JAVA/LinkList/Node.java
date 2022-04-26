package LeetCode_JAVA.LinkList;

public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public static Node creat(int[] nums) {
        Node pre = new Node(0), cur = pre;
        for (int num : nums) {
            cur.next = new Node(num);
            cur = cur.next;
        }
        return pre.next;
    }

    @Override
    public String toString() {
        Node tmp = this;
        StringBuffer sb = new StringBuffer();
        while (tmp != null) {
            sb.append(tmp.val);
            sb.append("->");
            tmp = tmp.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
