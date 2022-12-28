//---------NAIVE SOLUTION

class Solution {
    public int nthUglyNumber(int n) {
        int i=0,cnt=0;
        while(cnt<n){
            if(isUgly(i)) cnt++;
            i++;
        }
        return i-1;
        
    }
    public boolean isUgly(int n) {
        if(n<=0) return false;
        
       //keep on dividing with 2 
        while(n%2==0){
            n/=2;
        }
        //keep on dividing with 3 
        while(n%3==0){
            n/=3;
        }
        //keep on dividing with 5 
        while(n%5==0){
            n/=5;
        }
        
        if(n==1) return true;
        else return false;
        
    }
}