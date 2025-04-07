class WordDictionary {

    private Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.addWord(word);
    }

    public boolean search(String word) {
        return trie.search(word);
    }

    class Trie {
        private Node parent;

        public void addWord(String w) {
            Node p = parent;

            for(char c : w.toCharArray()) {
                if(p.children[c - 'a'] == null) {
                    p.children[c - 'a'] = new Node(c);
                }

                p = p.children[c - 'a'];
            }

            p.endOfWord = true;
        }

        public boolean search(String word) {
            return dfs(word, 0, parent);
        }

        private boolean dfs(String word, int j, Node node) {
            Node cur = node;

            for(int i = j; i < word.length(); i++) {
                char c = word.charAt(i);
                if(c == '.') {
                    for(Node child : cur.children) {
                        if(child != null && dfs(word, i + 1, child)) {
                            return true;
                        }
                    }

                    return false;
                } else {
                    if(cur.children[c - 'a'] == null) {
                        return false;
                    }

                    cur = cur.children[c - 'a'];
                }

            }

            return cur.endOfWord;
        }

        Trie() {
            parent = new Node();
        }

        class Node {
            private Character c;
            private boolean endOfWord;
            private Node[] children;

            Node() {
                children = new Node[26];
                c = null;
                endOfWord = false;
            }

            Node(Character c) {
                children = new Node[26];
                this.c = c;
                endOfWord = false;
            }
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */