package LeetCode_JAVA.LinkList;

public class GetKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head, fast = head;
        while (fast != null){
            if (k-- > 0){
                fast = fast.next;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.creat(new int[]{1, 2, 3, 4, 5});
        System.out.println(new GetKthFromEnd().getKthFromEnd(l1, 5));
    }
}
