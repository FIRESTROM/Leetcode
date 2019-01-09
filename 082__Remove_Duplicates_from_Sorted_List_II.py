# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        dummy = ListNode(-1)
        dummy.next = head

        prev, curr = dummy, head
        while curr:
            check = False
            while curr and curr.next and curr.val == curr.next.val:
                check = True
                curr.next = curr.next.next
            if check:
                prev.next = curr.next
                curr = curr.next
            else:
                prev, curr = curr, curr.next
        return dummy.next
