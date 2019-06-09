class Trie {

    class Node {
        Node [] child = new Node[26];
        String val;
    }

    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null) return;
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.child[c - 'a'] == null)
                node.child[c - 'a'] = new Node();
            node = node.child[c - 'a'];
        }
        node.val = word;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = getNode(word);
        return node != null && word.equals(node.val);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }

    private Node getNode(String prefix) {
        if (prefix == null) return null;
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (node == null)
                break;
            char c = prefix.charAt(i);
            node = node.child[c - 'a'];
        }
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
