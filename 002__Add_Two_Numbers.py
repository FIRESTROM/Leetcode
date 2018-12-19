# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        i = 0
        result = 0
        a = l1
        b = l2
        while a is not None or b is not None:
            if a:
                result += a.val * pow(10, i)
                a = a.next

            if b:
                result += b.val * pow(10, i)
                b = b.next

            i += 1
        result = str(result)[::-1]
        result_list = ListNode(result[0])
        c = result_list
        for x in result[1:]:
            c.next = ListNode(x)
            c = c.next

        return result_list

# Another solution using iteration
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        carry = 0

        result = ListNode(0)
        cur = result

        while l1 is not None and l2 is not None:
            sum = l1.val + l2.val + carry
            carry = 1 if sum >= 10 else 0
            sum %= 10
            cur.next = ListNode(sum)
            cur = cur.next
            l1, l2 = l1.next, l2.next

        if not l1 is not None:
            while l1 is not None:
                sum = l1.val + carry
                carry = 1 if sum >= 10 else 0
                sum %= 10
                cur.next = ListNode(sum)
                cur = cur.next
                l1 = l1.next
        elif l2 is not None:
            while l2 is not None:
                sum = l2.val + carry
                carry = 1 if sum >= 10 else 0
                sum %= 10
                cur.next = ListNode(sum)
                cur = cur.next
                l2 = l2.next

        if carry == 1:
            cur.next = ListNode(1)


        return result.next
