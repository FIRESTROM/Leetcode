class Solution {
    public String simplifyPath(String path) {
        path.replace("//", "/");
        String[] path_arr = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String str : path_arr) {
            if (str.length() == 0) continue;
            if (str.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!str.equals(".")) {
                stack.push(str);
            }
        }
        String result = "";
        while (!stack.isEmpty()) {
            result = "/" + stack.pop() + result;
        }
        if (result.length() == 0) result += "/";
        return result;
    }
}
