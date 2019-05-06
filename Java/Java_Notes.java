// ALL Initialization


// String <--> char array
String str = "abcd";
str.replace("a", "hhh") = "hhhbcd";
char[] str_to_array = str.toCharArray();
String new_str = str.toLowerCase();
String back_to_str = String.valueOf(str_to_array);
int value = Integer.parseInt(int_val);
s1.compareTo(s2) --> s1 - s2
  // String builder
  StringBuilder sb = new StringBuilder("");
  sb.append('#');
  sb.append(count[i]);
  String key = sb.toString();


// Why this need to set to ArrayList
List<List<Integer>> result = new ArrayList<>();
List<Integer> cur_list;
result.add(new ArrayList<>(cur_list));
result.add(Arrays.asList(1, 2, 3));
result.addAll(cur_list);

// LinkedList
LinkedList<String> stack = new LinkedList<>();
stack.push("I");   // push new element to the front


// Set
Set<Integer> result = new HashSet<>();
result.add(1);
result.add(2);
Set<Integer> temp = new HashSet<>();
temp.add(1);
result.removeAll(temp); // remove every element in temp from result
// Normal Queue
Queue<TreeNode> queue = new LinkedList<>();
queue.add(new TreeNode(x));
queue.poll();
// PriorityQueue
PriorityQueue<Integer> queue = new PriorityQueue<Integer> ((n1, n2) -> map.get(n1) - map.get(n2));
    Comparator<String> stringLengthComparator = new Comparator<String>() {
          @Override
          public int compare(String s1, String s2) {
              return s1.length() - s2.length();
          }
      };
    // The above Comparator can also be created using lambda expression like this:
    Comparator<String> stringLengthComparator = (s1, s2) -> {
          return s1.length() - s2.length();
    };
queue.add(val1);
queue.add(val2); --- > will rank from small to large
queue.remove() VS queue.poll() --- > Only different when queue is empty : remove() throws NoSuchElementException; poll() returns null

// Map
  // log(n) for containsKey, get, put and remove operation
TreeMap<Integer, String> tree = new TreeMap<>();
tree.put(int_val, string);
tree.firstKey();  // Return the first (lowest) key currently in this sorted map.
tree.lastKey();  // Return the last (highest) key currently in this sorted map.
tree.floorEntry(val);  // Return the entry with greatest key less than or equal to the given key
tree.floorKey(val); // Return the greatest key less than or equal to the given key
SortedSet<String> keys = new TreeSet<>(map.keySet());

// Build struct
enum Index {
    GOOD, BAD, UNKNOWN
}
Index[] memo = new Index[100];

    // In functions
    class Range {
              int start;
              int end;
              int count;
          }
    HashMap<Integer, Range> map = new HashMap<>();

    for (Map.Entry<Integer, Range> e : map.entrySet()) {
        Range r = e.getValue();
    }

// Specific helper functions
System.arraycopy(Object source_array, int source_start,Object dest_array, int dest_start, int len);
String temp = "abcde";
temp.hashCode(); // Return a hash code (int value)
Random r = new Random();
int key = r.nextInt(Integer.MAX_VALUE); // Generate a int key value, upper bound is Integer.MAX_VALUE
