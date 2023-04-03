import java.util.*;

// it's like a island problem, find number of islands
// return stones.length - islands 
// using UNION and FIND to cnt number of islands
// Think how we can store multidimension array into single dimension

class Solution {
    Map<Integer, Integer> f = new HashMap<>();
    int islands = 0;

    public int removeStones(int[][] stones) {
        for (int i = 0; i < stones.length; ++i)
            union(stones[i][0], 10001 + stones[i][1]);
        return stones.length - islands;
    }

    public int find(int x) {
        if (f.putIfAbsent(x, x) == null)
            islands++;
        if (x == f.get(x))
            return x;
        f.put(x, find(f.get(x)));
        return f.get(x);

    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y)
            return;
        f.put(x, y);
        islands--;

    }
}
// Time complexity : O(n)