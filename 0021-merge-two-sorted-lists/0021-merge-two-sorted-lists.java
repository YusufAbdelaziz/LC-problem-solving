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
    /// Result head is the first element in the LL.
    /// Result tail is the node that is moving to add more elements.
    ListNode resultHead = null, resultTail = null;

    while(list1 != null | list2 != null) {
        ListNode smallestNode = null;
        /// If list 2 is empty or list 1 is not empty and list 1's current val
        /// is bigger than list 2's current val, then we assign list 1's val as
        /// the smallest node.
        if(list2 == null || (list1 != null && list1.val < list2.val)){
            smallestNode = list1;
            list1 = list1.next;
        } else {
            smallestNode = list2;
            list2 = list2.next;
        }
        /// First condition is only triggered once.
        if(resultHead == null){
            resultHead = smallestNode;
        } else {
            /// We're chaning the null value assigned from the previous loop.
            resultTail.next = smallestNode;
        }
        
        resultTail = smallestNode;
        resultTail.next = null;
    }
      
      return resultHead;
  }
}