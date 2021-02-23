package LeetCode_JAVA.LinkList;

import java.util.HashSet;

public class RemoveDuplicateNodes {

    public ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (set.contains(cur.next.val)) {
                cur.next = cur.next.next;
            } else {
                set.add(cur.next.val);
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.creat(new int[]{1, 2, 3, 3, 2, 1, 5, 3});
        System.out.println(new RemoveDuplicateNodes().removeDuplicateNodes(l1));
    }
}
