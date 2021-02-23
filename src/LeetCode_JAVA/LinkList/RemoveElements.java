package LeetCode_JAVA.LinkList;

public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.creat(new int[]{1, 2, 6, 3, 4, 5, 6});
        System.out.println(new RemoveElements().removeElements(l1, 6));
    }

}
