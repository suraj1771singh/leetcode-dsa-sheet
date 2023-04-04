import java.util.*;

//-------------------------RECURSIVE SOLUTION ( TLE )
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        Map<String, Integer> dp = new HashMap<>();
        int ans = f(0, 0, startFuel, stations, target, dp);
        return ans == (int) 1e9 ? -1 : ans;

    }

    int f(int last, int ind, int fuel, int[][] stations, int target, Map<String, Integer> dp) {
        if (last + fuel >= target)
            return 0;
        if (ind >= stations.length)
            return (int) 1e9;
        String s = last + "-" + ind + "-" + fuel;
        if (dp.containsKey(s))
            return dp.get(s);
        if (stations[ind][0] - last <= fuel) {
            fuel -= stations[ind][0] - last;
            int p = 1 + f(stations[ind][0], ind + 1, fuel + stations[ind][1], stations, target, dp);
            int np = f(stations[ind][0], ind + 1, fuel, stations, target, dp);
            dp.put(s, Math.min(p, np));
            return dp.get(s);
        }
        return (int) 1e9;
    }
}