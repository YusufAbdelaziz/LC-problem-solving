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
  public ListNode partition(ListNode head, int x) {
    if (head == null || head.next == null)
      return head;
    // Initialize two pointers for each partition (head and tail pointers).
    ListNode lessHead = null, lessTail = null;
    ListNode bigOrEqualHead = null, bigOrEqualTail = null;
    while (head != null) {
      if (head.val < x) {
         // Initialize the head and tail pointers for the less partition for the
         // first time.
        if (lessHead == null) {
          lessHead = head;
          lessTail = head;
        } else {
        // In case that the less partition pointers are initialized and we want to add
        // more items to it, then we have to set the tail's next pointer to head and move
        // the tail to the head pointer.
          lessTail.next = head;
          lessTail = head;
        }

      } else {
        if (bigOrEqualHead == null) {
          bigOrEqualHead = head;
          bigOrEqualTail = head;
        } else {
          bigOrEqualTail.next = head;
          bigOrEqualTail = head;
        }

      }

      head = head.next;
    }
    // In case the tail of the less partition (the first partition) is not null, then
    // link the tail's next pointer to the bigger or equal parition (second partition).
    if (lessTail != null)
      lessTail.next = bigOrEqualHead;

    // If the second partition's (bigger or equal partition) tail is not null, then break the
    // connection to the next node so to prevent cycles.
    if (bigOrEqualTail != null) {
      bigOrEqualTail.next = null;
    }

    return lessHead != null ? lessHead : bigOrEqualHead;

  }
}