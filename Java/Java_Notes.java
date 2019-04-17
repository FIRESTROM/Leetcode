// ALL Initialization


// String <--> char array
String str = "abcd";
char[] str_to_array = str.toCharArray();
String back_to_str = String.valueOf(str_to_array);

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

// Specific helper functions
System.arraycopy(Object source_array, int source_start,Object dest_array, int dest_start, int len);
