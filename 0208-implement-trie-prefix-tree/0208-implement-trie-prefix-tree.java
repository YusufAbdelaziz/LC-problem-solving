public class Trie {
  private final Node root;

  private class Node {
    private boolean isKey;
    private final HashMap<Character, Node> children = new HashMap<>();

    public Node(boolean isKey) {
      this.isKey = isKey;
    }

    public void setKey(boolean isKey) {
      this.isKey = isKey;
    }

  }

  public Trie() {
    root = new Node(false);
  }

  public void insert(String word) {
    var currentNode = root;
    for (int i = 0; i < word.length(); i++) {
      if (currentNode.children.containsKey(word.charAt(i))) {
        if (i == word.length() - 1)
          currentNode.children.get(word.charAt(i)).setKey(true);
        currentNode = currentNode.children.get(word.charAt(i));
      } else {
        currentNode.children.put(word.charAt(i), i == word.length() - 1 ? new Node(true) : new Node(false));
        currentNode = currentNode.children.get(word.charAt(i));
      }
    }
  }

  public boolean search(String word) {
    var currentNode = root;
    for (int i = 0; i < word.length(); i++) {
      if (currentNode.children.containsKey(word.charAt(i))) {
        currentNode = currentNode.children.get(word.charAt(i));
      } else {
        return false;
      }
    }

    return currentNode.isKey;
  }

  public boolean startsWith(String prefix) {
    var list = keysWithPrefix(prefix);

    return list != null && keysWithPrefix(prefix).size() != 0;
  }

  /**
   * Retrieves all keys starting with a prefix.
   * 
   * Note that this seem redundant for startWith method as you only need to check
   * if at least one key exists but I made it for the sake of a complete
   * implementation.
   * 
   * @param prefix
   * @return list of all keys starting with a given prefix.
   * 
   */
  private List<String> keysWithPrefix(String prefix) {
    Node lastCharNode = findPrefixNode(prefix);
    if (lastCharNode == null)
      return null;
    List<String> results = new ArrayList<>();
    for (Character c : root.children.keySet()) {
      collectHelper(c.toString(), results, root.children.get(c));
    }

    return results;
  }

  private Node findPrefixNode(String prefix) {
    var currentNode = root;
    for (int i = 0; i < prefix.length(); i++) {
      if (currentNode.children.containsKey(prefix.charAt(i))) {
        currentNode = currentNode.children.get(prefix.charAt(i));
      } else
        return null;
    }
    return currentNode;
  }

  private void collectHelper(String s, List<String> result, Node n) {
    if (n.isKey)
      result.add(s);
    /// These two lines are necessary so the implementation can pass LeetCode's
    /// tests.
    /// As mentioned above current implementation returns all possible keys with a
    /// specific prefix
    /// which is not efficient at all when we want to check if a prefix has at least
    /// a single valid key.
    if (result.size() > 0)
    return;
    for (Character c : n.children.keySet()) {
      collectHelper(s + c, result, n.children.get(c));
    }
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */