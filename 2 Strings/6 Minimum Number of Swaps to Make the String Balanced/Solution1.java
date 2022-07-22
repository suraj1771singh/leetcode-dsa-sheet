//-----------EFFICIENT SOLUTION
//-----ALGO
/*
 * 1)keep track of unbalance open brackets
 * 2) in minumum way we can balance 2 open bracket in one swap
 * 3) we don't have to take care about close brackets (both are n/2)
 */
class Solution {
    public int minSwaps(String s) {
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[')
                open++;
            else if (open > 0)
                open--;

        }
        return (open + 1) / 2;
    }
}
// Time complexity : O(n)
// Space complexity : O(1)