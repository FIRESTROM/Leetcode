# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: void Do not return anything, modify head in-place instead.
        """
        if not head or not head.next:
            return
        slow, fast = head, head
        first_half = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        temp = slow.next
        slow.next = None
        left_half = temp
        newHead = None
        while left_half:
            nextNode = left_half.next
            left_half.next = newHead
            newHead = left_half
            left_half = nextNode

        while first_half and newHead :
            newHead_nextNode = newHead.next
            newHead.next = first_half.next
            first_half.next = newHead
            first_half = first_half.next.next
            newHead = newHead_nextNode

# Using list
class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: void Do not return anything, modify head in-place instead.
        """
        if head:
            node_list = []
            temp = head
            while temp:
                node_list.append(temp)
                temp = temp.next

            i, j = 0, len(node_list) - 1
            while i < j:
                node_list[i].next = node_list[j]
                node_list[j].next = node_list[i + 1]
                i += 1
                j -= 1
            node_list[i].next = None
