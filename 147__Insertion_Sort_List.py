# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def insertionSortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        dummy = ListNode(None)
        temp = dummy

        while head:
            while temp.next and head.val > temp.next.val:
                temp = temp.next
            left_unsorted = head.next
            head.next = temp.next
            temp.next = head
            head = left_unsorted
            temp = dummy

        return dummy.next
        
