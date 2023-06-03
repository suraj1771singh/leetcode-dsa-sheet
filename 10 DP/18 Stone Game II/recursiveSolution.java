class Solution {
    public int stoneGameII(int[] piles) {
        return f(0, true, 1, piles);
    }
    //we are always returning alice score
    int f(int ind, boolean alice, int m, int [] piles){
        if(ind >= piles.length) return 0;
        int ttl = 0;
        int res = alice ? 0 : (int)1e9;
        for(int i=1; i<=2*m ; i++){
            if(ind + i - 1 >= piles.length) break;
            ttl += piles[ind + i - 1];

            if(alice){
                //alice turn, it would try to maximize the score
                res = Math.max(res, ttl + f(ind + i, false, Math.max(m, i), piles));

            }else{
                //bobs turn, it would try to minimize the score
                res = Math.min(res, f(ind + i, true, Math.max(m, i), piles));
            }
        }
        return res;
    }
}
//Time complexity : O(2*n^2)