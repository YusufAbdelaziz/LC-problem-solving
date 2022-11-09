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
    ListNode mergedList = new ListNode();
    ListNode newList = mergedList;

    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        mergedList.val = list1.val;
        if (list1.next != null) {
          mergedList.next = new ListNode();
        }
        list1 = list1.next;
      } else {
        mergedList.val = list2.val;
        if (list2.next != null) {
          mergedList.next = new ListNode();
        }
        list2 = list2.next;
      }
      if (mergedList.next != null) {
        mergedList = mergedList.next;
      }
    }
    while (list2 != null) {
      mergedList.next = new ListNode(list2.val);
      // mergedList.val = ;
      mergedList = mergedList.next;
      list2 = list2.next;
    }
    while (list1 != null) {
      mergedList.next = new ListNode(list1.val);
      mergedList = mergedList.next;
      list1 = list1.next;
    }
    return newList;
  }
}