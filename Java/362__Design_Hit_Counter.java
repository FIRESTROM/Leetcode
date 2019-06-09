class HitCounter {

    Deque<Integer> record;

    /** Initialize your data structure here. */
    public HitCounter() {
        record = new LinkedList();
    }

    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        checkRecord(timestamp);
        record.addLast(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        checkRecord(timestamp);
        return record.size();
    }

    private void checkRecord(int timestamp){
        if (timestamp > 300) {
            int start = timestamp - 300 + 1;
            while (record.size() > 0 && record.peekFirst() < start)
                record.poll();
        }
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
