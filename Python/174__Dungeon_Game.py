class Solution(object):
    def calculateMinimumHP(self, dungeon):
        """
        :type dungeon: List[List[int]]
        :rtype: int
        """
        if not dungeon or not dungeon[0]:
            return 0

        m, n = len(dungeon), len(dungeon[0])

        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if i == m - 1 and j == n - 1:
                    if dungeon[i][j] < 0:
                        dungeon[i][j] = 1 - dungeon[i][j]
                    else:
                        dungeon[i][j] = 1
                else:
                    if i == m - 1:
                        tmp = dungeon[i][j + 1] - dungeon[i][j]
                    elif j == n - 1:
                        tmp = dungeon[i + 1][j] - dungeon[i][j]
                    else:
                        tmp = min(dungeon[i][j + 1], dungeon[i + 1][j]) - dungeon[i][j]
                    if tmp <= 0:
                        dungeon[i][j] = 1
                    else:
                        dungeon[i][j] = tmp
        return dungeon[0][0]
