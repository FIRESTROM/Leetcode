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

    public static final String SEP = ",";
	public static final String NULL = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return NULL;
		String left = serialize(root.left);
		String right = serialize(root.right);
		String result = root.val + SEP + left + SEP + right;
		return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || data.equals(NULL))
            return null;
		String[] input = data.split(SEP);
		int[] index = new int[]{0};
		return helper(input, index);
    }

    private TreeNode helper(String[] input, int[] index){
		if (input[index[0]].equals(NULL))
            return null;
		TreeNode node = new TreeNode(Integer.parseInt(input[index[0]]));
		index[0]++;
		node.left = helper(input, index);
		index[0]++;
		node.right = helper(input, index);
		return node;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
