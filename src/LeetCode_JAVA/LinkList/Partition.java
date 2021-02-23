package LeetCode_JAVA.LinkList;

public class Partition {

    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(), greatHead = new ListNode();
        ListNode less = lessHead, great = greatHead, cur = head;
        while (cur != null){
            ListNode cn = cur.next;
            if (cur.val < x){
                cur.next = less.next;
                less.next = cur;
                less = cur;
            } else {
                cur.next = great.next;
                great.next = cur;
                great = cur;
            }
            cur = cn;
        }
        less.next = greatHead.next;
        return lessHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.creat(new int[]{1, 4, 3, 2, 5, 2});
        System.out.println(new Partition().partition(l1, 3));
    }

}
