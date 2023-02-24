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
        List<Integer> list = new ArrayList<>();
        
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        int len = list.size();
        for(int i = 0; i < len / 2; i++) {
            if(list.get(i) != list.get(len - 1 - i)) return false; 
        }
            
        return true;
    }
}