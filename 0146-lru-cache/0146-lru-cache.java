 class LRUCache {

    // A map of pairs of key/node to the node itself.
    private HashMap<Integer, Node> map;
    // List of key/value pairs
    private DLList list;
    private int capacity;

    public LRUCache(int capacity) {
      this.map = new HashMap<>();
      this.list = new DLList();
      this.capacity = capacity;
    }

    public int get(int key) {
      if (!map.containsKey(key)) {
        return -1;
      }

      Node node = map.get(key);
      put(node.key, node.value);

      return node.value;
    }

    public void put(int key, int value) {
      if (map.containsKey(key)) {
        Node node = map.get(key);
        list.removeNode(node);
        map.remove(key);
      }

      if (list.size() == capacity) {
        Node removedNode = list.removeLast();
        map.remove(removedNode.key);
      }

      Node newNode = list.addFirst(key, value);
      map.put(key, newNode);
    }
  }

  class Node {
    Integer value;
    Integer key;
    Node prev;
    Node next;

    public Node(Integer key, Integer value, Node prev, Node next) {
      this.value = value;
      this.key = key;
      this.prev = prev;
      this.next = next;
    }

  }

  class DLList {
    // Note that head acts as a sentinel node, so it means it has no key/value pair.
    private Node head;
    private int size;

    public DLList() {
      head = new Node(null, null, null, null);
      head.next = head;
      head.prev = head;
      size = 0;
    }

    public int size() {
      return size;
    }

    // Adds node after the head of the list.
    public Node addFirst(int key, int value) {
      Node headNext = head.next;
      Node newNode = new Node(key, value, head, headNext);
      head.next = newNode;
      headNext.prev = newNode;
      // We add head.prev pointer to the first node that is added
      if (head.prev == head) {
        head.prev = newNode;
      }

      size++;
      return newNode;
    }

    public Node removeNode(Node node) {
      Node prevNode = node.prev;
      Node nextNode = node.next;

      prevNode.next = nextNode;

      if (nextNode != null)
        nextNode.prev = prevNode;

      size--;

      return node;

    }

    public Node removeLast() {
      Node lastNode = head.prev;

      return removeNode(lastNode);
    }
  }
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */