import java.util.Arrays;

//------NAIVE Approach 
//Just observe diagram and calculate area of every possible rectangle

class Solution1 {

    private final int MOD = (int) Math.pow(10, 9) + 7;

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long ans = 0, h_len = horizontalCuts.length, v_len = verticalCuts.length;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        for (int i = 0; i <= h_len; i++) {
            long height = i == 0 ? horizontalCuts[i]
                    : i == h_len ? h - horizontalCuts[i - 1]
                            : horizontalCuts[i] - horizontalCuts[i - 1];

            for (int j = 0; j <= v_len; j++) {
                long width = j == 0 ? verticalCuts[j]
                        : j == v_len ? w - verticalCuts[j - 1]
                                : verticalCuts[j] - verticalCuts[j - 1];

                long area = (height % MOD) * (width % MOD);
                ans = Math.max(ans, area);
            }
        }
        ans = ans % MOD;
        return (int) ans;
    }
}
// Time complexity : O(h_len * v_len)
// Spac complexity : O(1)