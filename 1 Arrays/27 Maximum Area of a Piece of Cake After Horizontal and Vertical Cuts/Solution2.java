import java.util.Arrays;

//-----EFFICIENT Approach 

// maxArea= maxHeigh * maxWidth
// so keep track of maxHeight, maxWidth

class Solution2 {
    private final int MOD = (int) Math.pow(10, 9) + 7;

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long maxH = 0;
        long maxV = 0;

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        for (int i = 0; i < horizontalCuts.length; i++) {
            maxH = Math.max(maxH, i == 0 ? horizontalCuts[i] : horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        maxH = Math.max(maxH, h - horizontalCuts[horizontalCuts.length - 1]);
        for (int i = 0; i < verticalCuts.length; i++) {
            maxV = Math.max(maxV, i == 0 ? verticalCuts[i] : verticalCuts[i] - verticalCuts[i - 1]);
        }
        maxV = Math.max(maxV, w - verticalCuts[verticalCuts.length - 1]);

        return (int) ((maxH * maxV) % MOD);
    }
}
// Time complexity : O(max(h* log h, w*log w))
// Spac complexity : O(1)