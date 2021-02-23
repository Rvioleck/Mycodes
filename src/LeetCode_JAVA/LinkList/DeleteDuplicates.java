package LeetCode_JAVA.LinkList;

public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy.next;
        while (cur != null) {
            if (cur.next != null) {
                if (cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            } else {
                cur = null;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.creat(new int[]{1, 1, 2, 2, 3, 4, 5, 5});
        System.out.println(new DeleteDuplicates().deleteDuplicates(l1));
    }
}
