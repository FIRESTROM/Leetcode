# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        dic = {}
        while headA is not None:
            dic[headA] = 1
            headA = headA.next
        while headB is not None:
            if headB in dic:
                return headB
            headB = headB.next
        return headB

# Another solution : find length first

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        currA = headA
        currB = headB
        lenA, lenB = 0, 0
        while currA:
            lenA += 1
            currA = currA.next
        while currB:
            lenB += 1
            currB = currB.next
        currA = headA
        currB = headB
        if lenA > lenB:
            for i in range(lenA - lenB):
                currA = currA.next
        elif lenB > lenA:
            for i in range(lenB - lenA):
                currB = currB.next
        while currA != currB:
            currA = currA.next
            currB = currB.next
        return currA

# Last Solution (not really understand)


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        if (headA==None) or (headB==None):
            return None
        x=headA
        y=headB
        while (x!=y):
            if x==None:
                x=headB
            else:
                x=x.next
            if y==None:
                y=headA
            else:
                y=y.next
        return x
