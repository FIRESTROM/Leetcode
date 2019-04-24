class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : paths) {
            String[] str_split = str.split(" ");
            for (int i = 1; i < str_split.length; i++) {
                int start = str_split[i].indexOf("("), end = str_split[i].indexOf(")");
                String context = str_split[i].substring(start, end);
                if (map.containsKey(context)) {
                    map.get(context).add(str_split[0] + "/" + str_split[i].substring(0, start));
                } else {
                    List<String> temp = new ArrayList<>();
                    temp.add(str_split[0] + "/" + str_split[i].substring(0, start));
                    map.put(context, temp);
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (String val : map.keySet()) {
            if (map.get(val).size() > 1) {
                result.add(map.get(val));
            }
        }
        return result;
    }
}
