# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        if not (head and head.next):
            return head

        tail = head
        length = 1
        while tail.next:  # get length and find the tail
            tail = tail.next
            length += 1
        tail.next = head  # link it to head, just like a ring

        # ring: [back k step] == [forward (-k mod length) step]
        step = (-k) % length
        while step:
            tail = tail.next  # just step forward
            step -= 1

        head = tail.next
        tail.next = None
        return head
