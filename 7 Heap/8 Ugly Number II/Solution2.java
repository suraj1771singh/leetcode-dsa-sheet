import java.util.*;

//-----------USING HEAP
//ALGO
/*

1) the first ugly number is 1 , and possible next ugly no is [2,3,5] multiply 1 by 2,3,5
2) take min(2,3,5)= 2 and put its multiple 2*2, 2*3, 2*4 in heap 
3) poll out next min and put its multiple min*2, min*3, min*4 in heap
4) do until you will get n ugly numbers

*/
class Solution2 {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> q = new PriorityQueue<>();
        q.add(1L);
        int cnt = 0;
        long mini = 0;
        while (cnt != n) {
            long a = q.poll();
            if (mini == a)
                continue;
            mini = a;
            cnt++;
            q.add(mini * 2);
            q.add(mini * 3);
            q.add(mini * 5);

        }
        return (int) mini;
    }
}
// Time complexity : O(n*logn)
// Space complexity : O(n)