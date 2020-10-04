/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int len = 0;
        while(cur!=null){
            len++;
            cur = cur.next;
        }

        len = len - n;
        if(len == 0){
            head = head.next;
            return head;
        }
        cur = head;
        ListNode prev = null;
        for(int i = 0;i<len;i++){
            prev = cur;
            cur = cur.next;
        }
        prev.next = cur.next;
        return head;
    }
}