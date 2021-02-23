package LeetCode_JAVA.LinkList;

public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (slow != null && fast != null) {
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            slow = slow.next;
            if (slow == fast) {
                ListNode p = head;
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.creat(new int[]{3, 2, 0, -4});
        l1.next.next.next.next = l1.next;
        System.out.println(new DetectCycle().detectCycle(l1));
    }
}
