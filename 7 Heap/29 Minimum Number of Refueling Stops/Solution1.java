import java.util.HashMap;

//-------------------------RECURSIVE SOLUTION
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        HashMap<Integer,HashMap<Integer,Integer> > map= new HashMap<>();

        int ans = f(target, 0, startFuel, stations,map);
        return ans < 0 ? -1 : ans;

    }

    private int f(int target, int i, int startFuel, int[][] stations, HashMap<Integer,HashMap<Integer,Integer> > map) {
        if (i == stations.length) {
            if (startFuel >= target)
                return 0;
            else
                return -1;
        }
        
        if (startFuel < stations[i][0])
            return -1;
        if(map.containsKey(startFuel) && map.get(startFuel).containsKey(i)) return map.get(startFuel).get(i);

        int pick = 1+ f(target, i + 1, startFuel + stations[i][1], stations,map);
        int notpick = f(target, i + 1, startFuel, stations,map);
        int count=0;
        if(pick==0 && notpick==-1)  count= -1;
        else if(pick==0) count= notpick;
        else if(notpick==-1) count= pick;
        else count=  Math.min(pick, notpick); 
        map.put(startFuel, new HashMap<>());
        map.get(startFuel).put(i, count);
        return count;
    }
}