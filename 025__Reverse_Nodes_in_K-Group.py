# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        count = 0
        node = head

        while node and count < k:
            node = node.next
            count += 1
        if count < k:
            return head
        new_head, prev = self.reverse(head, count)
        head.next = self.reverseKGroup(new_head, k)

        return prev

    def reverse(self, head, count):

        prev = None
        cur = head
        next = head
        while count > 0:
            next = cur.next
            cur.next = prev
            prev = cur
            cur = next
            count -= 1
        return (cur, prev)
