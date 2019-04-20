class Solution {
    public int[][] candyCrush(int[][] board) {

        int m = board.length, n = board[0].length;
        int[][] memo ;
        boolean isFinished = false;
        // "crush" check (while loop)
        while (!isFinished) {

        	memo = new int[m][n];
            // By row
        	for (int i = m - 1; i >= 0; i--) {
        		for (int j = n - 1; j >= 2; j--) {
        			if (board[i][j] == board[i][j - 1] && board[i][j] == board[i][j - 2]) {
        				memo[i][j] = memo[i][j - 1] = memo[i][j - 2] = board[i][j];
        			}
        		}
        	}
            // By column
        	for (int i = 0; i < n; i++) {
        		for (int j = m - 1; j >= 2; j--) {
        			if (board[j][i] == board[j - 1][i] && board[j][i] == board[j - 2][i]) {
        				memo[j][i] = memo[j - 1][i] = memo[j - 2][i] = board[j][i];
        			}
        		}
        	}

           // Crush the cell to 0
           boolean isAllZero = true;
           for (int i = 0; i < m; i++) {
        	   for (int j = 0; j < n; j++) {
        		   if (memo[i][j] != 0) {
        			   board[i][j] = 0;
        			   isAllZero = false;
        		   }
        	   }
           }
           // else break
           if (isAllZero) {
               break;
           }

           // Candy fall down
           for (int i = 0; i < n; i++) {
       	       for (int j = m - 1; j >= 1; j--) {
       			    if (board[j][i] == 0) {
                        int find = j - 1;
                        while (find >= 0 && board[find][i] == 0) find--;
                        int dist = j - find;
                        while (find >= 0) { // shift down
                            board[find + dist][i] = board[find][i];
                            board[find][i] = 0;
                            find--;
                        }
       			    }
       		    }
           }
        }
        return board;
    }

}
