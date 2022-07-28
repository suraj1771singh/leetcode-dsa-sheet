
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        int ans[]= new int[]{-1,-1};
        while (l <= h) {
              int mid= l+(h-l)/2;
              if(nums[mid]>target) h=mid-1;
              else if(nums[mid]<target) l=mid+1;
              else {
                //target found 
                ans[0]=BS(l,h,target,nums,true); //search left
                ans[1]=BS(l,h,target,nums,false); //search right
                break;
              }
        }
        return ans;

    }

    private int  BS(int l, int h, int target, int[] nums,boolean isLeft) {
        int ans=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]<target)l=mid+1;
            else if(nums[mid]>target) h=mid-1;
            else {
                ans=mid;
                if (isLeft) h=mid-1;
                else l=mid+1;
            }
        }
        return ans;
    }
}
//Time complexity : O(log n)
//Space compleixt : O(1)