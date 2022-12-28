import java.util.*;
// https://www.youtube.com/watch?v=GSBLe8cKu0s
//------ALGO
/*
 * 1)when we  hit start of any building , push it into pq and check if maximum is changed or not
 * 2) if max is changed , this means that coordinate need to be part of ans
 * 3) similary when we hit end of any building, remove that heigth from pq, and check if maximum heigth is changed or not
 * 4) if yes, this means that coordinate need to be part of ans
 * 
 */
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Building> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            list.add(new Building(buildings[i][0], true, buildings[i][2]));
            list.add(new Building(buildings[i][1], false, buildings[i][2]));
        }
        Collections.sort(list, new Comparator<Building>() {
            public int compare(Building a, Building b) {
                if (a.x == b.x) {
                    if (a.isStart && b.isStart)
                        return b.height - a.height;
                    else if (!a.isStart && !b.isStart)
                        return a.height - b.height;
                    else if (a.isStart)
                        return -1;
                    else
                        return 1;
                }
                return a.x - b.x;
            }
        });
        // System.out.println(list);

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);
        int prevMax = 0;
        for (int i = 0; i < list.size(); i++) {
            Building b = list.get(i);
            if (b.isStart) {
                map.put(b.height, map.getOrDefault(b.height, 0) + 1);
            } else {
                int val = map.get(b.height);
                if (val == 1)
                    map.remove(b.height);
                else
                    map.put(b.height, val - 1);
            }
            int currMax = map.lastKey();
            if (prevMax != currMax) {
                ans.add(new ArrayList<>(Arrays.asList(b.x, currMax)));
                prevMax = currMax;
            }

        }
        return ans;

    }

}

class Building {
    int x;
    boolean isStart;
    int height;

    Building(int a, boolean b, int h) {
        x = a;
        isStart = b;
        height = h;
    }

    public String toString() {
        return x + " " + isStart + " " + height;
    }
}