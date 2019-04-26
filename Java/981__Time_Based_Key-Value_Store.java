
class TimeMap {

    class Node {
        String value;
        int timestamp;
        public Node (String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    HashMap<String, List<Node>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap();
    }

    public void set(String key, String value, int timestamp) {
        Node newNode = new Node(value, timestamp);
        if (map.containsKey(key)) {
            map.get(key).add(newNode);
        } else {
            List<Node> list = new ArrayList();
            list.add(newNode);
            map.put(key, list);
        }
    }

    public String get(String key, int timestamp) {
        List<Node> list = map.get(key);
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (timestamp == list.get(mid).timestamp) {
                r = mid;
                break;
            } else if (timestamp < list.get(mid).timestamp) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (r == -1) {
            return "";
        }
        return list.get(r).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
