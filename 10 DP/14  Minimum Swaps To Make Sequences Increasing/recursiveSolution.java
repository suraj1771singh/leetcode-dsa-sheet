class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        return f(0,nums1,nums2,false);
    }
    int f(int ind, int nums1[], int nums2[],boolean isSwapped){
        if(ind>=nums1.length) return 0;
        
        int prev1 = ind-1<0 ? -1 : isSwapped ? nums2[ind-1] : nums1[ind-1];
        int prev2 = ind-1<0 ? -1 : isSwapped ? nums1[ind-1] : nums2[ind-1];

        int swap=(int)1e9, noswap=(int)1e9;
        //swap 
        if(nums1[ind]>prev2 && nums2[ind]>prev1)
            swap = 1 + f(ind+1,nums1,nums2,true);
        //noswap
        if(nums1[ind]>prev1 && nums2[ind]>prev2)
            noswap = f(ind+1,nums1,nums2,false);

        return Math.min(swap,noswap);
    }
}