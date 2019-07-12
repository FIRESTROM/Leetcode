class Solution {

    int index = 0;

    public boolean isValidSerialization(String preorder) {
        String[] s_arr = preorder.split(",");
        preorder(s_arr);
        if (index != s_arr.length - 1)
            return false;
        return true;
    }

    private void preorder(String[] s_arr) {
        if (index >= s_arr.length || s_arr[index].equals("#")) {
            return;
        }

        String node = s_arr[index];

        index++;
        preorder(s_arr);

        index++;
        preorder(s_arr);

        return;
    }
}
