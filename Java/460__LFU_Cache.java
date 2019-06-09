class LFUCache {

    class Node {
        Node prev;
        Node next;
        int key;
        int val;
        int count;
        Node (int k, int v) {
            key = k;
            val = v;
            count = 1;
        }
    }

    class DoubleLinkedList {
        Node front;
        Node tail;
        int size;

        DoubleLinkedList() {
            front = new Node(-1, -1);
            tail = new Node(-1, -1);
            front.next = tail;
            tail.prev = front;
            size = 0;
        }

        void insertToFront(Node node) {
            node.next = front.next;
            node.prev = front;
            front.next.prev = node;
            front.next = node;
            size++;
        }

        void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            size--;
        }
    }

    private Map<Integer, Node> keyMap;
    private Map<Integer, DoubleLinkedList> countMap;
    private int cap;
    private int leastCount;

    public LFUCache(int capacity) {
        keyMap = new HashMap<>();
        countMap = new HashMap<>();
        this.cap = capacity;
        leastCount = Integer.MAX_VALUE;
    }

    public int get(int key) {
        if (!keyMap.containsKey(key))
            return -1;
        Node node = keyMap.get(key);
        promote(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.val = value;
            promote(node);
            return;
        }
        if (cap == 0) return;
        if (keyMap.size() == cap) removeLeastCountNode();
        Node node = new Node(key, value);
        keyMap.put(key, node);
        countMap.putIfAbsent(node.count, new DoubleLinkedList());
        countMap.get(node.count).insertToFront(node);
        leastCount = 1;
    }

    private void promote(Node node) {
        DoubleLinkedList list = countMap.get(node.count);
        list.remove(node);
        if (leastCount == node.count && list.size == 0) leastCount++;
        node.count++;
        countMap.putIfAbsent(node.count, new DoubleLinkedList());
        countMap.get(node.count).insertToFront(node);
    }

    private void removeLeastCountNode() {
        DoubleLinkedList list = countMap.get(leastCount);
        Node node = list.tail.prev;
        list.remove(node);
        keyMap.remove(node.key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
