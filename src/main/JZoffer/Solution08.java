package JZoffer;

import java.util.Stack;

public class Solution08 {
    public ListNode reverseList(ListNode head) {
        ListNode res = new ListNode(0);
        ListNode now = head;
        ListNode temp;
        while (now!=null){
            temp = now.next;
            now.next = res.next;
            res.next = now;
            now = temp;
//            System.out.println(now.val);
        }

        return res.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        Solution08 s=  new Solution08();
        ListNode listNode = s.reverseList(a1);
        System.out.println(listNode.val);

    }
}
