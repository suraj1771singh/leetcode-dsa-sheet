import java.util.*;

//HINT : time complexity is exponential , so try to prune the tree 
class Solution {
    int[] skillmask;
    Map<String, Integer> map;
    int target;
    int min;
    List<Integer> res;

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {

        skillmask = new int[people.size()];
        map = new HashMap<>();
        target = (int) Math.pow(2, req_skills.length) - 1;
        min = people.size();
        res = new ArrayList<>();
        int n = people.size();
        for (int i = 0; i < req_skills.length; i++)
            map.put(req_skills[i], i);

        for (int i = 0; i < n; i++) {
            int mask = 0;
            for (String skill : people.get(i)) {
                int id = map.get(skill);
                mask = mask | (1 << id);
            }
            skillmask[i] = mask;
        }
        f(n - 1, 0, new ArrayList<>());
        int ans[] = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            ans[i] = res.get(i);
        return ans;
    }

    void f(int ind, int mask, List<Integer> temp) {
        if (temp.size() >= min)
            return; // prunning
        if (mask == target) {
            if (min > temp.size()) {
                res = new ArrayList<>(temp);
                min = temp.size();
            }
            return;
        }
        if (ind < 0)
            return;
        int nmask = mask | skillmask[ind];
        if (nmask == mask) { // prunning
            // not need to pick
            f(ind - 1, mask, temp);
        } else {
            // pick
            temp.add(ind);
            f(ind - 1, nmask, temp);
            temp.remove(temp.size() - 1);
            // not need to pick
            f(ind - 1, mask, temp);
        }

    }
}