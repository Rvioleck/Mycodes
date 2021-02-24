package LeetCode_JAVA.BinaryTree;

import LeetCode_JAVA.LinkList.ListNode;

public class SortedListToBST {

    private ListNode getMid(ListNode head, ListNode tail){
        ListNode slow = head, fast = head;
        while (fast != tail){
            fast = fast.next;
            if (fast == tail) break;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public TreeNode sortedListToBST(ListNode head) {
        return build(head, null);
    }

    private TreeNode build(ListNode head, ListNode tail) {
        if (head == tail){
            return null;
        }
        ListNode mid = getMid(head, tail);
        TreeNode root = new TreeNode(mid.val);
        root.left = build(head, mid);
        root.right = build(mid.next, tail);
        return root;
    }

    public static void main(String[] args) {
        ListNode l = ListNode.creat(new int[]{-10, -3, 0, 5, 9});
        System.out.println(new SortedListToBST().sortedListToBST(l));
    }

}
