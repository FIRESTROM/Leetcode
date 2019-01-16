Array & String : 完成到048
Linked List    : 完成到379
Stack & Queue  : 完成到394




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
