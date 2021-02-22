package LeetCode_JAVA.LinkList;

public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode left = head, right = head;  // find the middle of the link list;
        while (right != null){
            right = right.next;
            if (right != null){
                right = right.next;
                left = left.next;
            }
        }
        if (left != null){
            right = left.next;
            left.next = null;
        }
        while (right != null){
            ListNode fn = right.next;
            right.next = left;
            left = right;
            right = fn;
        }
        right = left;
        left = head;
        while (left != null && right != null){
            ListNode ln = left.next, rn = right.next;
            left.next = right;
            left = ln;
            if (left == right) break;
            right.next = left;
            right = rn;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.creat(new int[]{1, 2, 3, 4});
        new ReorderList().reorderList(l1);
        System.out.println(l1);
    }
}
