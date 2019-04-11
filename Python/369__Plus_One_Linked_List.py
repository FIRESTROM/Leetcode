# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def plusOne(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        def addone(root):
            if not root:
                return 1
            add_on_prev_digit = addone(root.next)
            root.val += add_on_prev_digit
            add_on_prev_digit = root.val / 10
            root.val %= 10
            return add_on_prev_digit

        if not head:
            return head

        all_9 = addone(head)

        if all_9 > 0:
            root = ListNode(1)
            root.next = head
        else:
            root = head
        return root
