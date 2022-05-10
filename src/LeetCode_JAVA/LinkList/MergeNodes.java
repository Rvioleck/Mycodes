package LeetCode_JAVA.LinkList;

public class MergeNodes {

    public ListNode mergeNodes(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = head.next, newCur = dummy;
        int sum = 0;
        while (cur != null){
            if (cur.val == 0){
                ListNode newNode = new ListNode(sum, null);
                newCur.next = newNode;
                newCur = newNode;
                sum = 0;
            }
            sum += cur.val;
            cur = cur.next;
        }
        return dummy.next;
    }

}
