
//HINT : https://leetcode.com/problems/maximum-white-tiles-covered-by-a-carpet/solutions/2038512/c-prefix-sum-binary-search-sorting-simple-and-detailed-explanation/?orderBy=most_votes
import java.util.*;
//-----------------USING PREFIX SUM ARRAY
class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int n = tiles.length, ans = 0;
        Arrays.sort(tiles, (a, b) -> a[0] - b[0]);

        int presum[] = new int[n + 1];
        int e_arr[] = new int[n];

        // prefix sum
        for (int i = 0; i < n; i++) {
            presum[i + 1] = presum[i] + tiles[i][1] - tiles[i][0] + 1;
            e_arr[i] = tiles[i][1];
        }

        for (int start = 0; start < n; start++) {
            int end = tiles[start][0] + carpetLen - 1;
            int ind = Arrays.binarySearch(e_arr, end);
            if (ind < 0)
                ind = -(ind + 1);
            int cover = presum[ind] - presum[start];
            if (ind < n && end >= tiles[ind][0])
                cover += end - tiles[ind][0] + 1;
            ans = Math.max(ans, cover);

        }

        return ans;
    }
}
// Time complexity : O(n*logn)