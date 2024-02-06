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
        if(head == null) return null;
        
        Node cur = head;
        Node newHead = new Node(0);
        
        Node curNewHead = newHead;
        
        // Maps old node to a new node
        HashMap<Node, Node> map = new HashMap<>();
        while(cur != null) {
            curNewHead.val = cur.val;
            map.put(cur, curNewHead);
            if(cur.next != null) curNewHead.next = new Node(0);
            curNewHead = curNewHead.next;
            cur = cur.next;
        }
        
        cur = head;
        
        while(cur != null) {
            Node curNewNode = map.get(cur);
            curNewNode.random = map.get(cur.random);
            
            cur = cur.next;
        }
        
        return newHead;
    }
}