# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        dummy = ListNode(0)
        curr = dummy
        while head:
            if head.val != val:
                curr.next = head
                curr = curr.next
            head = head.next
        curr.next = None
        return dummy.next
