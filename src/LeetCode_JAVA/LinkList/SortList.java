package LeetCode_JAVA.LinkList;

public class SortList {

    private ListNode getMid(ListNode head){
        ListNode slow = head, fast = head;
        while (fast != null){
            fast = fast.next;
            if (fast != null){
                fast = fast.next;
                if (fast == null) break;
                slow = slow.next;
            }
        }
        return slow;
    }

    private ListNode mergeTwoLists(ListNode left, ListNode right){
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                prev.next = left;
                left = left.next;
            } else {
                prev.next = right;
                right = right.next;
            }
            prev = prev.next;
        }
        prev.next = left == null ? right : left;
        return dummy.next;
    }

    public ListNode sortList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode midNode = getMid(head);
        ListNode rightHead = midNode.next;
        midNode.next = null;

        ListNode left = sortList(head), right = sortList(rightHead);
        return mergeTwoLists(left, right);
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.creat(new int[]{-1,5,3,4,0});
        System.out.println(new SortList().sortList(l1));
    }

}
