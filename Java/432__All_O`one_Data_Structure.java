class AllOne {

    class Node {
        Node prev;
        Node next;
        int freq;
        Set<String> set;
        Node (int freq) {
            this.freq = freq;
            this.set = new HashSet<>();
        }
    }

    private Node head;
    private Node tail;
    private Map<String, Node> freqMap;

    /** Initialize your data structure here. */
    public AllOne() {
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
        freqMap = new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        int freq = 1;
        if (freqMap.containsKey(key))
           freq = freqMap.get(key).freq + 1;
        update(key, freq);
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!freqMap.containsKey(key)) return;
        update(key, freqMap.get(key).freq - 1);
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (tail.prev == head) return "";
        return tail.prev.set.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (head.next == tail) return "";
        return head.next.set.iterator().next();
    }

    private void update(String key, int freq) {
        if (!freqMap.containsKey(key)) {
            Node node = new Node(1);
            if (head.next.freq == 1) node = head.next;
            else addAfter(head, node);
            node.set.add(key);
            freqMap.put(key, node);
            return;
        }
        Node cur = freqMap.get(key);
        cur.set.remove(key);
        if (freq == 0) freqMap.remove(key);
        else if (freq < cur.freq) {
            Node prev = cur.prev;
            if (prev.freq != freq) {
                prev = new Node(freq);
                addAfter(cur.prev, prev);
            }
            prev.set.add(key);
            freqMap.put(key, prev);
        } else {
            Node next = cur.next;
            if (next.freq != freq) {
                next = new Node(freq);
                addAfter(cur, next);
            }
            next.set.add(key);
            freqMap.put(key, next);
        }
        if (cur.set.isEmpty()) remove(cur);
    }

    private void addAfter(Node prev, Node cur) {
        cur.next = prev.next;
        prev.next.prev = cur;
        prev.next = cur;
        cur.prev = prev;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
