package 常见算法题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyl
 * @description 反转链表
 * @date 2024/5/27 8:22
 */
public class ReverseList {

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);

        ListNode reverse = reverse(node);

        System.out.printf("1", reverse);


    }

    public static ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;

        }

        return pre;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}