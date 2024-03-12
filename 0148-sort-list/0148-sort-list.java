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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head; // Base case for empty or single node list
        return mergeSort(head);
    }
    
    private ListNode mergeSort(ListNode head) {
        if(head.next == null) {
            return head;
        }
        
        ListNode fast = head, slow = head, prev = null;
        
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null; // to cut the connection between two partitions.
        
        ListNode leftPartition = mergeSort(head);
        ListNode rightPartition = mergeSort(slow);
        
        return merge(leftPartition, rightPartition);
    }
    
    private ListNode merge(ListNode firstPartition, ListNode secondPartition) {
        ListNode sentinel = new ListNode();
        ListNode pFirst = firstPartition, pSecond = secondPartition, pSentinel = sentinel;
        
        while(pFirst != null && pSecond != null) {
            if(pFirst.val < pSecond.val) {
                pSentinel.next = pFirst;
                pFirst = pFirst.next;
            } else {
                pSentinel.next = pSecond;
                pSecond = pSecond.next; 
            }
            pSentinel = pSentinel.next;
        }
        
        if(pFirst != null) {
            pSentinel.next = pFirst;
        }
        
        if(pSecond != null) {
            pSentinel.next = pSecond;
        }
        
        return sentinel.next;
    }
}