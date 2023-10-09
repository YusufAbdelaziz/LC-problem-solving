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
        if(head == null || head.next == null) return null;
        
        // Since head is not null, then we have at least 1 element.
        int numOfElements = 0;
        ListNode cur = head;
        while(cur != null) {
            cur = cur.next;
            numOfElements++;
        }
        
        int removalFromStartIndex = numOfElements - n;
        int i = 1;
        ListNode newCur = head;
        while(i < removalFromStartIndex) {
            newCur = newCur.next;
            i++;
        }
        
        if(removalFromStartIndex == 0) {
            return head.next;
        }
        
        ListNode next = newCur.next;
        
        newCur.next = newCur.next.next;
        next.next = null;
        
        return head;
    }
}