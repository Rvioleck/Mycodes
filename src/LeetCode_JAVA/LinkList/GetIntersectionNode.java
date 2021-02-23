package LeetCode_JAVA.LinkList;

public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.creat(new int[]{1, 2, 3, 4});
        ListNode l2 = new ListNode(5);
        l2.next = l1.next.next;
        System.out.println(new GetIntersectionNode().getIntersectionNode(l1, l2));
    }

}
