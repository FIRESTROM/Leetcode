
class Node(object):
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None


# The idea is about using a double linked list to recode the access order of all keys within
# the capacity. Every time we access a key, we will put this key to the rightmost place and
# delete it from its origin place in the double linked list if it exists before.

class LRUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.head = Node(0, 0)
        self.tail = Node(0, 0)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.capacity = capacity
        self.dic = dict()


    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key in self.dic:
            # Update this key to the latest call
            node = self.dic[key]
            self.remove(node)
            self.add(node)
            return node.value

        return -1


    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: void
        """

        if key in self.dic:
            self.remove(self.dic[key])
            node = Node(key, value)
            self.add(node)
            self.dic[key] = node
        else:
            if self.capacity == len(self.dic):
                node = self.head.next
                self.remove(node)
                del self.dic[node.key]
            node = Node(key, value)
            self.add(node)
            self.dic[key] = node


    def remove(self, node):
        prev_node = node.prev
        next_node = node.next
        prev_node.next = next_node
        next_node.prev = prev_node

    def add(self, node):
        last_node = self.tail.prev
        last_node.next = node
        self.tail.prev = node
        node.prev = last_node
        node.next = self.tail






# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
