package LeetCode_JAVA.LinkList;

public class MergeInBetween {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur = list1;
        ListNode left = null, right = null;
        int i = 1;
        while (true) {
            if (i == a) {
                left = cur;
            }
            if (i == b) {
                right = cur;
                break;
            }
            i++;
            cur = cur.next;
        }
        left.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = right;
        return list1;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.creat(new int[]{1, 2, 3, 4, 5, 6});
        ListNode l2 = ListNode.creat(new int[]{1000000, 1000001, 1000002, 1000003, 1000004});
        System.out.println(new MergeInBetween().mergeInBetween(l1, 2, 5, l2));
    }

}
