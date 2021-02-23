package LeetCode_JAVA.LinkList;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        //<editor-fold desc="将链表head从 1->2->3->4->5变为1->2->3<-4<-5,并且left指向第一个元素，right指向最后一个元素，中心元素指向null">
        ListNode left = head, right = head;
        while (right != null) {
            right = right.next;
            if (right != null) {
                right = right.next;
                left = left.next;
            }
        }
        if (left != null) {
            right = left.next;
            left.next = null;
        }
        while (right != null) {
            ListNode rn = right.next;
            right.next = left;
            left = right;
            right = rn;
        }
        right = left;
        left = head;
        //</editor-fold>
        while (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.creat(new int[]{1, 2});
        System.out.println(new IsPalindrome().isPalindrome(l1));
    }
}
