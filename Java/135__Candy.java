class Solution {
    public int candy(int[] ratings) {
        int result = 0;
        int[] left_right = new int[ratings.length];
        int[] right_left = new int[ratings.length];
        Arrays.fill(left_right, 1);
        Arrays.fill(right_left, 1);
        for (int i = 1; i < ratings.length; i++)
            if (ratings[i] > ratings[i - 1])
                left_right[i] = left_right[i - 1] + 1;
        for (int i = ratings.length - 2; i >= 0; i--)
            if (ratings[i] > ratings[i + 1])
                right_left[i] = right_left[i + 1] + 1;

        for (int i = 0; i < ratings.length; i++)
            result += Math.max(left_right[i], right_left[i]);

        return result;
    }
}
