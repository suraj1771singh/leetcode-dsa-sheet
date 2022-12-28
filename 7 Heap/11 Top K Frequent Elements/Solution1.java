import java.util.*;

//----------USING HEAP
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map= new HashMap<>();
        int ans[]= new int [k];
        for(int i : nums)  map.put(i, map.getOrDefault(i, 0)+1);
        
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int key : map.keySet()){
            int a[]={key, map.get(key)};
            pq.add(a);
        }
        int cnt=0;
        while(k-->0 && !pq.isEmpty()){
            ans[cnt++]=pq.poll()[0];
        }
        return ans;
    }
}
//Time complexity : O(n*logn)