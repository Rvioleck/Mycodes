package LeetCode_JAVA.LinkList;

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = head.next, finish = head;
        while (cur != null){
            ListNode cn = cur.next;
            ListNode pre = dummy;
            if (cur.val >= finish.val){
                finish.next = cur;
                finish = cur;
            } else {
                while (pre.next.val < cur.val){
                    pre = pre.next;
                }
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = cn;
        }
        finish.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.creat(new int[]{-1,3,0,4,5});
        System.out.println(new InsertionSortList().insertionSortList(l1));
    }
}
