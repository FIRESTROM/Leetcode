/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] raw = data.split(",");
        if (raw.length == 0)
            return null;
        TreeNode root = find_root(raw[0]);
        int startRight = deserialize(-1, root, 1, raw);
        deserialize(1, root, startRight, raw);

        return root;
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        String text = root == null ? "#" : String.valueOf(root.val);
        sb.append(text);
        if (root != null) serialize(root.left, sb.append(","));
        if (root != null) serialize(root.right, sb.append(","));
    }

    private int deserialize(int left_or_right, TreeNode parent, int start, String[] raw) {
        if (start == raw.length)
            return start;
        TreeNode current = find_root(raw[start]);
        if (left_or_right == -1)
            parent.left = current;
        else
            parent.right = current;
        start++;

        if (current == null)
            return start;
        int startRight = deserialize(-1, current, start, raw);
        int end = deserialize(1, current, startRight, raw);

        return end;
    }

    private TreeNode find_root(String input) {
      return input.equals("#") ? null : new TreeNode(Integer.valueOf(input));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
