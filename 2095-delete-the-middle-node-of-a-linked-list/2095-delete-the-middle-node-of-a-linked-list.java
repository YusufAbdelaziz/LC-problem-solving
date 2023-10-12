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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;
        
//         int numOfElements = 0;
        
//         ListNode curr = head;
        
//         while(curr != null) {
//             numOfElements++;
//             curr = curr.next;
//         }
        
        
//         int middle = numOfElements / 2;
//         ListNode p = head;
//         for(int i = 1; i < middle; i++) {
//             p = p.next;
//         }
        
        // p.next = p.next.next;
        
        ListNode fast = head.next.next, slow = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow.next = slow.next.next;
        
        return head;
    }
}