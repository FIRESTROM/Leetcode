class PhoneDirectory {

    private Set<Integer> assigned = new HashSet<>();
    private LinkedList<Integer> availables;
    int max = 0;
    int maxNumbers;

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        this.maxNumbers = maxNumbers;
        availables = new LinkedList<Integer>();
        availables.add(0);
    }

    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (availables.isEmpty()) {
            return -1;
        }
        int removed = availables.removeFirst();
        if (availables.isEmpty() && max < maxNumbers - 1) {
            max++;
            availables.add(max);
        }
        assigned.add(removed);
        return removed;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !assigned.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (number != -1 && assigned.contains(number)) {
            assigned.remove(number);
            availables.push(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
