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
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        
        /// Faster pointer takes two steps faster, which means it'll finish traversing
        /// the whole linked list where the slow pointer is only at half distance which
        /// is the middle of the list.
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
}