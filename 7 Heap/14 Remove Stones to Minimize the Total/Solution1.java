import java.util.PriorityQueue;

class Solution {
    public int minStoneSum(int[] piles, int k) {
        int sum=0;
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->b-a);
        for(int i : piles){ 
            sum+=i;
            pq.add(i);
        }
        while(k-->0 && !pq.isEmpty()){
            int a=pq.poll();
            sum-=a/2;
            pq.add((a+1)/2);
        }
        return sum;
        
        
    }
}
//Time complexity : O(n*logn)