package LeetCode_JAVA.LinkList;

public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null){
            ListNode node = new ListNode(head.val);
            node.next = dummy.next;
            dummy.next = node;
            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.creat(new int[]{1, 2, 3, 4, 5});
        System.out.println(new ReverseList().reverseList(l1));
    }
}
