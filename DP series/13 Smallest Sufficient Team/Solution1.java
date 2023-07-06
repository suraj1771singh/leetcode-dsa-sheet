import java.util.*;

class Solution {
    Map<String, Integer> map;
    int target;

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        map = new HashMap<>();
        int n = req_skills.length;
        target = 1 << n;
        for (int i = 0; i < n; i++)
            map.put(req_skills[i], i);
        int size = f(0, 0, people);
        System.out.println(size);
        return new int[] {};
    }

    int f(int ind, int mask, List<List<String>> people) {
        if (mask == target)
            return 0;
        if (ind >= people.size())
            return (int) 1e9;
        int np = f(ind + 1, mask, people);

        for (String skill : people.get(ind)) {
            int id = map.get(skill);
            mask = mask | (1 << id);
        }
        int p = 1 + f(ind + 1, mask, people);
        return Math.min(np, p);
    }
}