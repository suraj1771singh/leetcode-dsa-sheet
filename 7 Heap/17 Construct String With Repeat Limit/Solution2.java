
//---ALGO

// using COUNTING 
/*
1) Make the frequency table from 'a' to 'z'
2) start iteration from last (i.e ind=25)
3) At each iteration check condition
->      freq[ind]>0
->      check if reserved char is null or not
4) if reserved is null means there is no higher character which is not fully consumed till now, so append curr char by min( repeatLimit, freq[ind])  times, if  some occurances left , then mark it as reserved and store remaining freq in reserved_cnt and decrement the index.
5) if reserved is not null means we have to process  reserved char, 
->     first append curr char 
->     decrement it's freq count
->     and try to consume reserved char, as per step 4)

 */
public class Solution2 {

    public String repeatLimitedString(String s, int repeatLimit) {

        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;

        StringBuilder str = new StringBuilder();
        int ind = 25;
        Character reserved = null;
        Integer reserved_cnt = null;

        while (ind >= 0) {
            if (freq[ind] == 0) {
                ind--;
                continue;
            }
            char c = (char) ('a' + ind);
            if (reserved == null) {
                int len = Math.min(repeatLimit, freq[ind]);

                for (int k = 0; k < len; k++)
                    str.append(c);
                if (freq[ind] - len > 0) {
                    reserved = c;
                    reserved_cnt = freq[ind] - len;
                }
                ind--;

            } else {
                str.append(c);
                freq[ind]--;
                int len = Math.min(repeatLimit, reserved_cnt);

                for (int k = 0; k < len; k++)
                    str.append(reserved);
                if (reserved_cnt - len > 0) {
                    reserved_cnt = reserved_cnt - len;
                } else {
                    reserved = null;
                    reserved_cnt = null;
                }
            }
        }
        return str.toString();
    }
}
// Time complexity : O(n)
