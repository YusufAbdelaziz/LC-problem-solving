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
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      if(list1 == null && list2 == null) return null;
      if(list1 == null && list2 != null) return list2;
      if(list2 == null && list1 != null) return list1;
      
      ListNode head = null, tail = null;
      
      while(list1 != null || list2 != null) {
          ListNode smallestNode;
          
          if(list1 == null || (list2 != null && list2.val < list1.val)) {
              smallestNode = list2;
              list2 = list2.next;
          } else {
              smallestNode = list1;
              list1 = list1.next;
          }
          
          if(head == null) {
              head = smallestNode;
          } else {
              tail.next = smallestNode;
          }
          
          tail = smallestNode;
          tail.next = null;
          
      }
      
      return head;
  }
}