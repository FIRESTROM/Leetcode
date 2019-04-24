// ALL Initialization


// String <--> char array
String str = "abcd";
char[] str_to_array = str.toCharArray();
String back_to_str = String.valueOf(str_to_array);
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

// Set
Set<Integer> result = new HashSet<>();
result.add(1);
result.add(2);
Set<Integer> temp = new HashSet<>();
temp.add(1);
result.removeAll(temp); // remove every element in temp from result

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
