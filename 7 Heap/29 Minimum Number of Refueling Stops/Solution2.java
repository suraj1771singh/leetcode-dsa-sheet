class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int stops = 0;
        int i = 0;
        int n = stations.length;
        int max_dist = startFuel;
        int curr_dist = 0;
        int next_max_dist = 0;
        int next_max_ind = 0;

        if (max_dist >= target)
            return stops;
        while (i < n) {
            if (max_dist >= target)
                return stops;
            if (max_dist < stations[i][0])
                return -1;

            while (max_dist >= stations[i][0] && i < n) {
                int fuel = startFuel - (stations[i][0] - curr_dist);
                int dist = stations[i][0] + fuel + stations[i][1];
                if (next_max_dist < dist) {
                    next_max_dist = dist;
                    next_max_ind = i;
                }
                i++;
            }

            startFuel = startFuel - (stations[next_max_ind][0] - curr_dist) + stations[next_max_ind][1];
            max_dist = next_max_dist;
            curr_dist = stations[next_max_ind][0];
            stops++;
            i = next_max_ind + 1;

        }
        if (next_max_dist >= target)
            return stops + 1;
        else
            return -1;
        // return stops;
    }
}
