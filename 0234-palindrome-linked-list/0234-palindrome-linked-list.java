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
    public boolean isPalindrome(ListNode head) {
        // A straightforward solution : O(n) time and O(n) space.
//         List<Integer> list = new ArrayList<>();
        
//         while(head != null) {
//             list.add(head.val);
//             head = head.next;
//         }
        
//         int len = list.size();
//         for(int i = 0; i < len / 2; i++) {
//             if(list.get(i) != list.get(len - 1 - i)) return false; 
//         }
            
//         return true;
        
        
        ListNode slow , fast;
        
        slow = fast = head;
        
        // Now this makes fast reaches the end of the linked list and slow is exactly at the middle.
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
                                                                                  
        /// We'll reverse the second half of the linked list so given a linked list like :
        ///                  slow
        ///  1 -> 3 -> 3 -> | 2 | -> 3 -> 3 -> 1 ===>  1 -> 3 -> 3 -> | 2 | -> 1 -> 3 -> 3
        
        /// After that both pointers will move the same number of steps and if it's a palindrome then
        /// they should match.
        slow = reversed(slow);
        fast = head;
        
        while(slow != null) {
            if(slow.val != fast.val) return false;
            
            slow = slow.next;
            fast = fast.next;
        }
        
        return true;
        
        
    }
    
    private ListNode reversed(ListNode head) {
        /// Given 3 -> 3 -> 1 ====> 1 -> 3 -> 3
        
        ListNode prev = null;
        
        while(head != null) {
            var next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
    
        return prev;
    }
}