class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long overlapX = Math.max(0, (long) Math.min(C, G) - (long) Math.max(A, E));
        long overlapY = Math.max(0, (long) Math.min(D, H) - (long) Math.max(B, F));
        long overlap = overlapX * overlapY;
        return (C - A) * (D - B) + (G - E) * (H - F) - (int) overlap;
    }
}
