class Trie {

    class Node {
        private Character c;
        private Node[] children;
        private boolean inserted;

        public Node(Character c) {
            children = new Node[26];
            inserted = false;
            this.c = c;
        }

        public Node[] getChildren() {
            return children;
        }

        public void setInserted(boolean inserted) {
            this.inserted = inserted;
        }

        public Boolean getInserted() {
            return inserted;
        }

        public Character getChar() {
            return c;
        }

        public void setChar(char c) {
            this.c = c;
        }
    }

    private Node root;

    public Trie() {
        root = new Node(null);
    }

    public void insert(String word) {
        Node p = root;
        for (char c : word.toCharArray()) {
            Node curNode = p.children[c - 'a'];
            if (curNode == null) {
                p.children[c - 'a'] = new Node(c);
            }
            p = p.children[c - 'a'];
        }

        p.setInserted(true);
    }

    public boolean search(String word) {
        Node p = root;
        for (Character c : word.toCharArray()) {
            Node curNode = p.children[c - 'a'];
            if (curNode == null || curNode.getChar() != c)
                return false;
            p = curNode;
        }

        return p.getInserted();
    }

    public boolean startsWith(String prefix) {
        Node p = root;
        for (Character c : prefix.toCharArray()) {
            Node curNode = p.children[c - 'a'];
            if (curNode == null || curNode.getChar() != c)
                return false;
            p = curNode;
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */