class StreamChecker {

    class Node {
        Node[] child = new Node[26];
        boolean end = false;
    }

    Node root;
    StringBuilder sb;

    public StreamChecker(String[] words) {
        root = new Node();
        sb = new StringBuilder();
        build(words);
    }

    public boolean query(char letter) {
        sb.append(letter);
        return findWord();
    }

    private void build(String[] words) {
        for (String word: words) {
            Node node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if(node.child[c - 'a'] == null) {
                    node.child[c - 'a'] = new Node();
                }
                node = node.child[c - 'a'];
            }
            node.end = true;
        }
    }

    private boolean findWord() {
        Node node = root;
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (node.child[c - 'a'] == null)
                return false;
            node = node.child[c - 'a'];
            if (node.end)
                return true;
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
