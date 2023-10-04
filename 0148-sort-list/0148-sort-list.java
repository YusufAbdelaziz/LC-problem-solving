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
        LinkedList<Integer> list = new LinkedList<>();
        
        ListNode cur = head;
        
        while(cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        
        Collections.sort(list);
        
        ListNode updater = head;
        
        while(updater != null) {
            updater.val = list.removeFirst();
            updater = updater.next;
        }
        
        return head;
    }
}