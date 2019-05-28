class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0)
            return new int[][]{};
        int[][] result = new int[people.length][people[0].length];
        for (int[] nums : result)
            Arrays.fill(nums, -1);
        // 首先对学生按照身高排序 身高相同则先考虑k值小的学生
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2) {
                if (p1[0] != p2[0])
                    return p1[0] - p2[0];
                else
                    return p1[1] - p2[1];
            }
        });
        for (int[] p : people) {
            int h = p[0], k = p[1], index = 0, count = 0; // index为该学生可能排的位置 count记录将p放在index位置时，其前面有多少位同学身高大于或等于p
            // 当当前位置元素未被占有（result[index][0] == -1）或者已被占有但是身高等于当前待插入学生的身高时 计数字段count加1
            while (count < k) {
                if (result[index][0] == -1 || result[index][0] == h)
                    count++;
                index++;
            }
            // 找到index后需要保证该index位置未被占有 因为题目始终有解，所以省略数组越界判断
            while (result[index][0] != -1)
                index++;
            result[index][0] = h;
            result[index][1] = k;
        }
        return result;
    }
}
