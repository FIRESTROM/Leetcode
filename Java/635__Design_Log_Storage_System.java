class LogSystem {

    List<String[]> timestamps = new ArrayList<>();
    HashMap<String, Integer> indices ;

    public LogSystem() {
        indices = new HashMap<String, Integer>() {{
            put("Year", 4);
            put("Month", 7);
            put("Day", 10);
            put("Hour", 13);
            put("Minute", 16);
            put("Second", 19);
        }};
    }

    public void put(int id, String timestamp) {
        timestamps.add(new String[] {String.valueOf(id), timestamp});
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> result = new LinkedList<>();
        int idx = indices.get(gra);
        String start = s.substring(0, idx);
        String end = e.substring(0, idx);
        for (String[] timestamp : timestamps) {
            if (timestamp[1].substring(0, idx).compareTo(start) >= 0 && timestamp[1].substring(0, idx).compareTo(end) <= 0) {
                result.add(Integer.valueOf(timestamp[0]));
            }
        }
        return result;
    }


}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */
