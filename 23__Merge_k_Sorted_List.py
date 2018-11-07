# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
import heapq

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        import heapq
class Solution:
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """

        heap = []
        for arr in lists:
            if arr:
                heapq.heappush(heap, (arr.val, arr))

        dummy = ListNode(None)
        cur = dummy

        while heap:
            value, popNode = heapq.heappop(heap)
            cur.next = popNode
            cur = cur.next
            if popNode.next:
                heapq.heappush(heap,(popNode.next.val,popNode.next))

        return dummy.next
