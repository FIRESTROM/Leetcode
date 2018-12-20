class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        check = set()
        for i in range(9):
           for j in range(9):
               if board[i][j]!='.':
                   cur = board[i][j]
                   if (i,cur) in check or (cur,j) in check or (i/3,j/3,cur) in check:
                       return False
                   check.add((i,cur))
                   check.add((cur,j))
                   check.add((i/3,j/3,cur))
        return True
