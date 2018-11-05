import Queue

class Solution(object):
    def shortestSubarray(self, A, K):
        """
        :type A: List[int]
        :type K: int
        :rtype: int
        """

        if max(A) >= K:
            return 1

        sum_up = [0] * (len(A) + 1)
        for i in range(1, len(A) + 1):
            sum_up[i] = sum_up[i - 1] + A[i - 1]

        min_len = float("inf")

        # Element in Q will be in the order of index: 0 ~ len(A) - 1
        Q = Queue.deque([0])

        for i in range(1,len(sum_up)):
            # If Q[0] and i is a good substring, and update min_len if it's smaller.
            # Will Q.popleft because we already count the optimal solution start from Q[0]
            while Q and sum_up[i] - sum_up[Q[0]] >= K:
                min_len = min(min_len, i - Q.popleft())

            # If rightmost index stored in Q is larger than the end index we looking at,
            # then pop it since the subarray would have sum < 0
            while Q and sum_up[i] < sum_up[Q[-1]]:
                Q.pop()
            # Add the i_th index for later check
            Q.append(i)

        if min_len == float("inf"):
            return -1
        return min_len
