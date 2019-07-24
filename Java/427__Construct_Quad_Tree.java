/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node construct(int[][] grid) {
        if (grid == null || grid.length == 0) return null;
        return dfs(grid, grid.length, 0, 0);
    }

    private Node dfs(int[][] grid, int len, int row, int col){
        if (len == 1)
            return new Node(grid[row][col] == 1, true, null, null, null, null);
        Node node = new Node();
        Node topLeft = dfs(grid, len / 2, row, col);
        Node topRight = dfs(grid, len / 2, row, col + len / 2);
        Node bottomLeft = dfs(grid, len / 2, row + len / 2, col);
        Node bottomRight = dfs(grid, len / 2, row + len / 2, col + len / 2);
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
            node.val = topLeft.val;
            node.isLeaf = true;
        }
        else {
            node.isLeaf = false;
            node.topLeft = topLeft;
            node.topRight = topRight;
            node.bottomLeft = bottomLeft;
            node.bottomRight = bottomRight;
        }
        return node;
    }
}
