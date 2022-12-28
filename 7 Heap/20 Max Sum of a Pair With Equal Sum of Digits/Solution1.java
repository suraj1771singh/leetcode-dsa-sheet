//NOTE : maximum sum of digits can be 81(all 9 digts are 9)

class Solution1 {
    public int maximumSum(int[] nums) {
        int a[][]=new int[82][2]; 
        int n= nums.length,ans=-1; 
        for(int i=0; i<n; i++){
            int num=nums[i];
            int sum=0;
            while(num>0){
                sum+=num%10;
                num/=10;
            }
            num=nums[i];
            if(a[sum][0]<num){ 
                int temp=a[sum][0];
                a[sum][0]=num;
                a[sum][1]=Math.max(temp,a[sum][1]);
            }
            else if(a[sum][1]<num) a[sum][1]=num;
            
        }
        for(int i=0; i<=81; i++){
            if(a[i][0]!=0 && a[i][1]!=0) ans=Math.max(ans, a[i][0]+a[i][1]);
        }
        return ans;
    }
}
//Time complexity : O(n)