package JZoffer;

import LeetCode.Solution;

import java.util.ArrayList;

public class Solution03 {

    //  遍历，存。
        public ListNode getKthFromEnd(ListNode head, int k) {
        ArrayList<ListNode> list  = new ArrayList<>();
        inQueue(head,list);
        System.out.println("size ================="+list.size());
        return list.get(list.size()-k);
    }
    static void inQueue(ListNode node,ArrayList<ListNode> list){
        if (node.next!=null){
            list.add(node);
            inQueue(node.next,list);
        }else {
            list.add(node);
        }
        return;
    }

//      双指针
//    public ListNode getKthFromEnd(ListNode head, int k) {
//        ListNode former = head, latter = head;
//        for (int i = 0; i < k; i++)
//            former = former.next;
//        while (former != null) {
//            former = former.next;
//            latter = latter.next;
//        }
//        return latter;
//    }


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
        Solution03 ss = new Solution03();
        ListNode saw = ss.getKthFromEnd(a1, 2);
        System.out.println(saw.val);

    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
