class Solution {
    public int lengthLongestPath(String input) {
        //use list to avoid unecessary memeory cost
        List<Integer> lens = new ArrayList<>();
        String[] dirs = input.split("\n");
        int result = 0;
        for (String dir : dirs) {
            int tabCnt = dir.lastIndexOf("\t") + 1;// "\t" is a character of length one
            int len = dir.length() + 1 - tabCnt; //remove tabs and include delimiter
            if (tabCnt == 0) {//no indentation means current dir/file is under the root directory
                if (lens.size() == 0) lens.add(len);
                else lens.set(0, len);
            } else if(lens.size() == tabCnt) //this level is not in the list yet
                lens.add(len + lens.get(tabCnt - 1));
            else lens.set(tabCnt, len + lens.get(tabCnt - 1));

            if (dir.indexOf(".") > 0)//file doesn't need include delimiter
                result = Math.max(result, lens.get(tabCnt) - 1);
        }
        return result;
    }
}
