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
    public ListNode reverseList(ListNode head) {
    if (head == null)
      return null;
    int len = this.getListLength(head);
    ListNode newList = new ListNode();
    var currentNode = newList;
    for (int i = len - 1; i >= 0; i--) {
      currentNode.val = this.getItem(head, i);
      if (i != 0) {
        currentNode.next = new ListNode();
        currentNode = currentNode.next;
      }
    }

    return newList;
  }

  private int getListLength(ListNode head) {
    int len = 0;
    var currentNode = head;
    while (currentNode != null) {
      len++;
      currentNode = currentNode.next;
    }
    return len;
  }

  private int getItem(ListNode head, int index) {
    int count = 0;
    var currentNode = head;
    while (currentNode != null && count < index) {
      currentNode = currentNode.next;
      count++;
    }

    return currentNode.val;
  }
}