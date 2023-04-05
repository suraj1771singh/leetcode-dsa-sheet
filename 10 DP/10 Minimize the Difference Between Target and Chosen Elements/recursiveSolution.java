import java.util.*;
//--------------------RECURSIVE SOLUTION

class Solution {
    int tg;
    List<List<Integer>> list;

    public int minimizeTheDifference(int[][] mat, int target) {
        int n = mat.length;
        list = new ArrayList<>();
        // remove duplicates and sort each row
        for (int a[] : mat) {
            Set<Integer> set = new HashSet<>();
            for (int num : a)
                set.add(num);
            list.add(new ArrayList<>(set));
            Collections.sort(list.get(list.size() - 1));
        }
        tg = target;
        return f(n - 1, 0);

    }

    int f(int r, int sum) {
        if (r < 0)
            return Math.abs(sum - tg);
        int min = (int) 1e9;
        for (int num : list.get(r)) {
            min = Math.min(min, f(r - 1, sum + num));
            if (sum + num >= tg)
                break;
        }
        return min;
    }
}
