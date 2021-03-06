Cracking the Coding Interview: 跳过Chapter 5,6,7,9
Array & String      : 完成到048
Linked List         : 完成到379
Stack & Queue       : 完成到394
Tree & BFS & DFS    : 完成到250
Graph & Topological Sort & Trie & BIT(Indexed) & Segment Tree & BST(Search): 完成到332
Recursion & DP      : 完成到392
Sort & Searching    : 完成到392


# Data Structure:

from collections import deque
    lst = deque(lst)
    left_most = lst.popleft()
    right_most = lst.pop()

from collections import heapq
    heap = []
    heapq.heappush(heap, (key, stuff)) # Push the (key, stuff) pair sorted by key
    heapq.heappop(heap) # return the (key, stuff) pair with smallest

# Index
lst.index(val) -> index of val in the lst

# Random
random.randint(a, b) -> A random int value from a to b (Both inclusive)

# Linked List

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

# Reverse Linked List
class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        unsorted, result = head, None
        while temp:
            ahead = unsorted.next
            unsorted.next = result
            result, unsorted = unsorted, ahead
        return result

# Tree
# Definition for TreeNode.
class TreeNode(object):
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
