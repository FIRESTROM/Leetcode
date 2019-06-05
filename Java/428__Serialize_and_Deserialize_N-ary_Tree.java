/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        serialize_helper(root, sb);
        return sb.toString();
    }

    private void serialize_helper(Node node, StringBuilder sb) {
        if (node != null) {
            sb.append('[');
            sb.append(node.val);
            if (node.children != null)
                for (Node child : node.children)
                    serialize_helper(child, sb);
            sb.append(']');
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        return deserialize_helper(data, new int[]{1}, new StringBuilder());
    }

    private Node deserialize_helper(String data, int[] index_arr, StringBuilder sb) {
        Node node = null;
        int index = index_arr[0];
        while (index < data.length()) {
            while (Character.isDigit(data.charAt(index)))
                sb.append(data.charAt(index++));
            if (sb.length() > 0) {
                Integer val = Integer.valueOf(sb.toString());
                node = new Node(val, new ArrayList<Node>());
                sb.setLength(0);
            }
            if (data.charAt(index) == '[') {
                index_arr[0] = index + 1;
                node.children.add(deserialize_helper(data, index_arr, sb));
                index = index_arr[0];
            } else if (data.charAt(index) == ']') {
                index_arr[0] = index + 1;
                break;
            }
        }
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

   
