package LeetCode_JAVA.LinkList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReversePrint {

    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(0, head.val);
            head = head.next;
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.creat(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(new ReversePrint().reversePrint(l1)));
    }
}
