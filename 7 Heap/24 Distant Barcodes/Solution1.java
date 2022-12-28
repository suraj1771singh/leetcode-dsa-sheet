//------COUNTING 
//ALGO
/*
1) first arrange num with higest freq at alternate position
2) then arrange remaining other
3) we are using count to store freq of numbers
*/
class Solution1 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int count[]= new int [10001];
        int n= barcodes.length;
        int maxi=0;
        for(int i : barcodes){
            count[i]++;
            if(count[maxi]<count[i]) maxi=i;
        }
        int ans[]= new int[n];
        int freq=count[maxi];
        int ind=0;
        while(freq-->0){
            ans[ind]=maxi;
            ind+=2;
            if(ind>=n) ind=1;
        }
        for(int i=0; i<10001; i++){
            if(count[i]==0 || i==maxi) continue;
            freq=count[i];
            while(freq-->0){
                ans[ind]=i;
                ind+=2;
                if(ind>=n) ind=1;
            }
        }
        return ans;
        
    }
}
//Time complexity : O(n) + O(10001) -> constant time
//Space complexity : O(1) 