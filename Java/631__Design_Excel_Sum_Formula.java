class Excel {

    int[][] values;
    String[][][] formula;

    public Excel(int H, char W) {
        values = new int[H][W - 'A' + 1];
        formula = new String[H][W - 'A' + 1][1];
    }

    public void set(int r, char c, int v) {
        values[r - 1][c - 'A'] = v;
        formula[r - 1][c - 'A'][0] = null;
    }

    public int get(int r, char c) {
        return formula[r - 1][c - 'A'][0] == null ?
            values[r - 1][c - 'A'] : sum(r, c, formula[r - 1][c - 'A'][0].split(","));
    }

    public int sum(int r, char c, String[] strs) {
        int sum = 0;
        for (String s : strs) {
            String[] pos = s.split(":");
            if (pos.length == 1) {
                int row = Integer.valueOf(pos[0].substring(1));
                char col = pos[0].charAt(0);
                sum += formula[row - 1][col - 'A'][0] == null ?
                    values[row - 1][col - 'A'] : sum(row, col, formula[row - 1][col - 'A'][0].split(","));
            } else {
                for (int i = Integer.valueOf(pos[0].substring(1)); i <= Integer.valueOf(pos[1].substring(1)); i++) {
                    for (char j = pos[0].charAt(0); j <= pos[1].charAt(0); j++) {
                        sum += formula[i - 1][j - 'A'][0] == null ?
                            values[i - 1][j - 'A'] : sum(i, j, formula[i - 1][j - 'A'][0].split(","));
                    }
                }
            }
        }
        formula[r - 1][c - 'A'][0] = String.join(",", strs);
        return sum;
    }
}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(H, W);
 * obj.set(r,c,v);
 * int param_2 = obj.get(r,c);
 * int param_3 = obj.sum(r,c,strs);
 */
