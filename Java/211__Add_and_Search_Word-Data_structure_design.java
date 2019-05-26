class WordDictionary {

    class TrieNode {
        boolean is_end;
        TrieNode[] children;
        TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            if (temp.children[c - 'a'] == null)
                temp.children[c - 'a'] = new TrieNode();
            temp = temp.children[c - 'a'];
        }
        temp.is_end = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(word, 0, root);
    }


    private boolean helper(String word, int index, TrieNode root) {
        if (index == word.length())
            return root.is_end;
        char c = word.charAt(index);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (root.children[i] == null) continue;
                if (helper(word, index + 1, root.children[i])) return true;
            }
            return false;
        } else {
            if (root.children[c - 'a'] != null)
                return helper(word, index + 1, root.children[c - 'a']);
            else
                return false;
        }
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
