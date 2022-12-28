class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n= gas.length;
        int energy=0, start=0;
        for(int i=0; i<n; i++){
            energy+=gas[i]-cost[i];
        }
        if(energy<0) return -1;//ans not possible
        //find start point
        energy=0;
        for(int i=0; i<n; i++){
            energy+=gas[i]-cost[i];
            if(energy<0) {
                start=i+1;//next point could be the start
                energy=0;
            }
        }
        return start;
        
    }
}
//Time complexity : O(n)