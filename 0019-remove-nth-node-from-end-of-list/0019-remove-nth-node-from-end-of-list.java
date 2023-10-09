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
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         if(head == null || head.next == null) return null;
        
//         // Since head is not null, then we have at least 1 element.
//         int numOfElements = 0;
//         ListNode cur = head;
//         while(cur != null) {
//             cur = cur.next;
//             numOfElements++;
//         }
        
//         int removalFromStartIndex = numOfElements - n;
//         int i = 1;
//         ListNode newCur = head;
//         while(i < removalFromStartIndex) {
//             newCur = newCur.next;
//             i++;
//         }
        
//         if(removalFromStartIndex == 0) {
//             return head.next;
//         }
        
//         ListNode next = newCur.next;
        
//         newCur.next = newCur.next.next;
//         next.next = null;
        
//         return head;
//     }
    
     public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) return null;
        
        ListNode dummy = new ListNode(0, head);
        ListNode l = dummy;
        ListNode r = head;
        // Set distance between l and r pointer which is n;
        while(n > 0) {
            r = r.next;
            n--;
        }
        
        while(r != null) {
            r = r.next;
            l = l.next;
        }
         
        l.next = l.next.next;
        return dummy.next;
         
    }
}