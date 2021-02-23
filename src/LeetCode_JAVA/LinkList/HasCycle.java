package LeetCode_JAVA.LinkList;


public class HasCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (slow != null && fast != null) {
            fast = fast.next;
            if (slow == fast) {
                return true;
            }
            if (fast != null)
                fast = fast.next;
            slow = slow.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.creat(new int[]{3, 2, 0, -4});
        l1.next.next.next.next = l1.next;
        System.out.println(new HasCycle().hasCycle(l1));
    }
}
