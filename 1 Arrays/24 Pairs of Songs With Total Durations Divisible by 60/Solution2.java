import java.util.HashMap;

//-------ALGO
// used division reminder theorem
// if ( x+ y)%z ==0 then x%z + y%z ==0 or z
//so we are storing reminders of elements
// for reminder r1 we are searhing for r2 which must be z-r1 (so the x and y should make valid pairs)

public class Solution2 {
    public int numPairsDivisibleBy60(int[] time) {
        int n = time.length, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        // mapping reminders
        for (int i : time) {
            i = i % 60;
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i = 0; i < n; i++) {

            int r1 = time[i] % 60; // reminder 1
            int r2 = r1 == 0 ? 0 : 60 - r1; // reminder 2

            map.put(r1, map.get(r1) - 1);// removing to avoid duplicates

            if (map.containsKey(r2))
                ans += map.get(r2);
        }

        return ans;
    }
}
// Time complexity : O(n)
// Space complexity : O(1) because reminder will lie in [0,59] only
