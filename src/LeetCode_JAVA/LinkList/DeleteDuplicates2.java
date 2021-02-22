package LeetCode_JAVA.LinkList;

public class DeleteDuplicates2 {

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null){
            ListNode p = cur.next;
            if (p.next != null && p.next.val == cur.next.val){
                while (p.next != null && p.next.val == cur.next.val){
                    p = p.next;
                }
            } else {
                cur = cur.next;
            }
            cur.next = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.creat(new int[]{1, 1, 2, 2});
        System.out.println(new DeleteDuplicates2().deleteDuplicates2(l1));
    }
}
