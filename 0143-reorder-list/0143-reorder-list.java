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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
          return;
        
        ListNode prev = null, slow = head, fast = head, l1 = head;
      
        while (fast != null && fast.next != null) {
           prev = slow;
           slow = slow.next;
           fast = fast.next.next;
        } 
        // Break between the first half and the second half. 
        // Now the start of first half is the head.
        prev.next = null;
        
        ListNode secondHalfStart = reverse(slow);
        
        ListNode firstHalfStart = head;
        
        // Note that first half is >= second half.
        merge(firstHalfStart, secondHalfStart);
    }
    
    
    private ListNode findMiddleElement(ListNode head) {
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    private ListNode reverse(ListNode start) {
        ListNode newHead = null;
        
        while(start != null) {
            ListNode next = start.next;
            start.next = newHead;
            newHead = start;
            start = next;
        }
        
        return newHead; 
    }
    
    private void merge(ListNode firstHalfHead, ListNode secondHalfHead) {
        while (firstHalfHead != null) {
        ListNode n1 = firstHalfHead.next, n2 = secondHalfHead.next;
        firstHalfHead.next = secondHalfHead;
        
        if (n1 == null)
          break;
            
        secondHalfHead.next = n1;
        firstHalfHead = n1;
        secondHalfHead = n2;
      }
        
    }
}