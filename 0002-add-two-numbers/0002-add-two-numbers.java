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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        int carry = 0;
        ListNode head = new ListNode();
        ListNode sentinel = head;
        while(l1 != null || l2 != null || carry != 0) {
            int sum = 0;
            if(l1 != null) sum += l1.val;
            if(l2 != null) sum += l2.val;
            sum += carry;
            
            carry = sum / 10;
            sentinel.next = new ListNode(sum % 10);
            sentinel = sentinel.next;
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        
        return head.next;
    }
}