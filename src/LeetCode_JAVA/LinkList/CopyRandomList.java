package LeetCode_JAVA.LinkList;

import java.util.HashMap;

public class CopyRandomList {

    private Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    private Node copyRandomList2(Node head) {
        if (head == null){
            return null;
        }
        Node cur = head;
        Node next = null;
        while(cur != null){
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        while(cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }
        Node res = head.next;
        cur = head;
        while (cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }

    public static void main(String[] args) {
        Node l1 = Node.creat(new int[]{3, 2, 0, -4});
        System.out.println(new CopyRandomList().copyRandomList(l1));
        System.out.println(new CopyRandomList().copyRandomList2(l1));
    }

}
