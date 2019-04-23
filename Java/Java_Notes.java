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

// Set
Set<Integer> result = new HashSet<>();
result.add(1);
result.add(2);
Set<Integer> temp = new HashSet<>();
temp.add(1);
result.removeAll(temp); // remove every element in temp from result

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
