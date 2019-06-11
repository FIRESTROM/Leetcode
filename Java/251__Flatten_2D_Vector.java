class Vector2D {

    private int[][] v = null;
    private int i = 0, j = 0;

    public Vector2D(int[][] v) {
        this.v = v;
    }

    public int next() { // hasNext() finds the next valid position
        return hasNext() ? v[i][j++] : -1;
    }

    public boolean hasNext() {
        while (i < v.length && j >= v[i].length) {
            i++;
            j = 0;
        }
        return i != v.length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
 
