import java.util.*;

//-----------------USING MAX HEAP
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) return -s1.compareTo(s2);
                return -Integer.compare(s1.length(), s2.length());
            }
        });
        for (String s : nums) pq.add(s);
        String ans = "";
        while (k-- > 0) ans = pq.poll();
        return ans;
    }
}
//Time complexity : O(n * logn)