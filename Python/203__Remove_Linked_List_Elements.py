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

# Not Building A New ListNode
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
        if head is None:
            return head

        if head.val == val:
            return self.removeElements(head.next, val)

        curr = head
        while curr and curr.next:
            #save the current node on prev
            #move current to next node
            prev = curr
            curr = curr.next

            if curr.val == val:
                #remove
                prev.next = curr.next
                curr = prev

        return head
