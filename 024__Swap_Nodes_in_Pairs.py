# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return head

        dummy = ListNode(0)
        dummy.next = head
        prev, curr = dummy, head

        while curr:
            first, second = curr, curr.next
            if not second:
                break
            third = second.next
            prev.next = second
            second.next = first
            first.next = third

            prev, curr = curr, curr.next
        return dummy.next
