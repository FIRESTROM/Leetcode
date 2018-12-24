# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def oddEvenList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """

        odds = ListNode(0)
        evens = ListNode(0)
        oddsHead = odds
        evensHead = evens
        isOdd = True
        while head:
            if isOdd:
                odds.next = head
                odds = odds.next
            else:
                evens.next = head
                evens = evens.next
            isOdd = not isOdd
            head = head.next
        evens.next = None
        odds.next = evensHead.next
        return oddsHead.next

        # Definition for singly-linked list.
        # class ListNode(object):
        #     def __init__(self, x):
        #         self.val = x
        #         self.next = None

        class Solution(object):
            def oddEvenList(self, head):
                """
                :type head: ListNode
                :rtype: ListNode
                """
                if head == None:
                    return head

                odd = head
                even = head.next
                evenHead = even
                while even is not None and even.next is not None:
                    odd.next = even.next
                    odd = odd.next
                    even.next = odd.next
                    even = even.next
                odd.next = evenHead
                return head

# Solution with O(1) space complexity

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def oddEvenList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head == None:
            return head

        odd = head
        even = head.next
        evenHead = even
        while even is not None and even.next is not None:
            odd.next = even.next
            odd = odd.next
            even.next = odd.next
            even = even.next
        odd.next = evenHead
        return head
