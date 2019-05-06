class MyLinkedList {
    class Node {
        int val;
        Node next;
        Node (int val) {
            this.val = val;
        }
    }

    Node head, tail;
    int len;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        len = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= len) {
            return -1;
        }
        Node result = head;
        while (index >= 0) {
            result = result.next;
            index--;
        }
        return result.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node temp = head.next;
        head.next = new Node(val);
        head.next.next = temp;
        len++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node last = head;
        while (last.next != tail) {
            last = last.next;
        }
        last.next = new Node(val);
        last.next.next = tail;
        len++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > len) {
            return;
        }
        Node node_i = head;
        while (index > 0) {
            node_i = node_i.next;
            index--;
        }
        Node temp = node_i.next;
        node_i.next = new Node(val);
        node_i.next.next = temp;
        len++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= len || index < 0) {
            return;
        }
        Node node_i_prev = head;
        while (index > 0) {
            node_i_prev = node_i_prev.next;
            index--;
        }
        node_i_prev.next = node_i_prev.next.next;
        len--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
