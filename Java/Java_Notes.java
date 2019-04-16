// ALL Initialization


// Why this need to set to ArrayList
List<List<Integer>> result = new ArrayList<>();
List<Integer> cur_list;
result.add(new ArrayList<>(cur_list));

// Specific helper functions
System.arraycopy(Object source_array, int source_start,Object dest_array, int dest_start, int len);
