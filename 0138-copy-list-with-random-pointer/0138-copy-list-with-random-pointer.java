/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null ) return null;
        
        // Step 1 -> Create a copy node after each node.
        
        Node cur = head;
        
        while(cur != null) {
            Node next = cur.next;
            Node copyNode = new Node(cur.val);
            cur.next = copyNode;
            copyNode.next = next;
            
            cur = next;
        }
        
        // Step 2 -> Iterate over the list to modify the random pointer to a newly copied node.
        
        cur = head;
        
        while(cur != null) {
            Node originalRandom = cur.random;
            Node copyNode = cur.next;
            
            if(originalRandom != null) copyNode.random = originalRandom.next;
            
            cur = cur.next.next;
        }
        
        
        // Step 3 -> Separate the copied nodes from the original ones.
        
        Node sentinel = new Node(-1);
        Node curCopy = sentinel;
        cur = head;
        
        while(cur != null) {
            Node originalNext = cur.next.next;
            
            // Extract copy from original nodes.
            Node copyNode = cur.next;
            curCopy.next = copyNode;
            curCopy = copyNode;
            
            // Restore original list.
            cur.next = originalNext;
            cur = cur.next;
        }
        
        return sentinel.next;
    }
}