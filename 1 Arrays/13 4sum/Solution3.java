import java.util.*;
//------------MOST EFFICIENT SOLUTION
//NOTE : Not using set(adding into set takes log n time)

class Solution {
    int MOD=(int)1e9+7;
    
    public List<List<Integer>> fourSum(int[] arr, int target) {
        Arrays.sort(arr);
        return kSum(arr, target, 4, 0, arr.length-1);
    }

    public List<List<Integer>> kSum(int[] arr, int target, int k, int lo, int hi) {
        List<List<Integer>> ans = new ArrayList<>();
        // base case : k==2
        if (k == 2) {
            while (lo < hi) {
                  int sum=(arr[lo]+arr[hi])%MOD;
                  if(sum >target) hi--;
                  else if(sum <target) lo++;
                  else {
                    ans.add(new ArrayList<>(Arrays.asList(arr[lo],arr[hi])));
                    while(lo<hi && arr[lo]==arr[lo+1]) lo++;
                    while(lo<hi && arr[hi]==arr[hi-1]) hi--;
                    lo++;hi--;
                  }
            }
            return ans;
        }
        // case : k>2
        for(int i=lo; i<arr.length-(k-1); i++){
            List<List<Integer>> temp= kSum(arr, target-arr[i], k-1, i+1, hi);
            if(temp!=null){
                for(List<Integer> t : temp) //add previous results
                    t.add(0,arr[i]);
                ans.addAll(temp);
            }
            //skip duplicates
            while(i<arr.length-1 && arr[i]==arr[i+1]) i++;
        }
        return ans;
    }
}
//Time complexity : O(n^2)
//Space complexity : O(1)