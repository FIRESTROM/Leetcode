/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {

    HashMap<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        help(node);
        return map.get(node.val);
    }

    private void help(Node node) {
        if (map.containsKey(node.val))
            return;
        Node temp = new Node(node.val);
        temp.neighbors = new ArrayList<Node>();
        map.put(temp.val, temp);
        for (Node origin_neighbor : node.neighbors) {
            if (map.containsKey(origin_neighbor.val))
                temp.neighbors.add(map.get(origin_neighbor.val));
            else {
                help(origin_neighbor);
                temp.neighbors.add(map.get(origin_neighbor.val));
            }
        }
    }
}
