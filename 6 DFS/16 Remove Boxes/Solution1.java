//------------------------NAIVE APPROACH

import java.util.ArrayList;

class Solution {
    public int removeBoxes(int[] boxes) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : boxes)
            list.add(i);
        return f(list);
    }

    private int f(ArrayList<Integer> list) {
        if (list.size() == 0)
            return 0;
        int n = list.size();
        int maxi = 0;
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (prev == -1 || list.get(prev) != list.get(i)) {
                prev = i;
                ArrayList<Integer> nextArr = removeConsecutive(i, list);
                int a = n - nextArr.size();
                maxi = Math.max(maxi, a * a + f(nextArr));
            }
        }
        return maxi;

    }

    private ArrayList<Integer> removeConsecutive(int start, ArrayList<Integer> list) {
        int n = list.size();
        int i = 0;
        ArrayList<Integer> nextArray = new ArrayList<>();
        while (i < n) {
            if (i == start) {
                int prev = i;
                while (i < n && list.get(prev) == list.get(i))
                    i++;
                continue;
            }
            nextArray.add(list.get(i));
            i++;
        }
        return nextArray;

    }
}