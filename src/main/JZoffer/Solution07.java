package JZoffer;

import java.util.Stack;

public class Solution07 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        stack.push(head.val);
        while (head.next!=null){
            head = head.next;
            stack.push(head.val);
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}
