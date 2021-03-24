package LeetCode_JAVA.LinkList;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode l = head, r = head, preL = dummy, preR;
        int delta = right - left;
        while (left-- != 1) {
            preL = l;
            l = l.next;
            r = r.next;
        }
        preR = r;
        r = r.next;
        while (delta-- != 0) {
            ListNode rn = r.next;
            r.next = preR;
            preR = r;
            r = rn;
        }
        preL.next = preR;
        l.next = r;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.creat(new int[]{1, 2, 3, 4, 5});
        System.out.println(new ReverseBetween().reverseBetween(l1, 1, 2));
    }
}
