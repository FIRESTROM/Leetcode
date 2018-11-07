# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return []

        result = head

        while head.next != None:
            # Start : [1, 2, 3, 4, 5]
            temp = head.next
            head.next = head.next.next
            temp.next = result
            result = temp

        return result


# Here is another solution that looks much nicer and readable.

class Solution:
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """

        prev = next = None
        curr = head

        while curr:
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next

        return prev
