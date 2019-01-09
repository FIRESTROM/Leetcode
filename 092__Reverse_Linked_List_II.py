# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseBetween(self, head, m, n):
        """
        :type head: ListNode
        :type m: int
        :type n: int
        :rtype: ListNode
        """
        # Consider linked list as a list A. i.e. A[1]=head.val, A[2]=head.next.val ....
        # Create dummy.         [D,A[1],A[2],....]
        dummy = ListNode(None)
        dummy.next = head
        # prev at A[0]
        prev = dummy

        # move prev m-1 times. now prev is at A[M-1]
        for _ in range(m -1):
            prev = prev.next

        # start reversing from curr = prev.next (A[M]) for n-m+1 nodes
        curr, temp = prev.next, None
        for _ in range(n - m + 1):
            curr.next, curr, temp = temp, curr.next, curr
            # Or more clear:
            # temp = curr.next
            # curr.next = node
            # node = curr
            # curr = temp


        # now the situation is
        # [dummy .... prev]    [temp,..., prev.next]   [curr .....]
        # connect prev to temp, and prev.next to curr
        prev.next.next, prev.next = curr, temp

        return dummy.next
