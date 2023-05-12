import java.util.*;

//HINT : divide arrray into k subsequences
// use LIS to find longest length in each subsequences
// ans+=list.len-LIS();
class Solution {
    public int kIncreasing(int[] arr, int k) {
        int ans = 0;
        for (int i = 0; i < k; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < arr.length; j += k)
                list.add(arr[j]);
            ans += LIS(list);
        }
        return ans;
    }

    public int LIS(List<Integer> list) {
        List<Integer> temp = new ArrayList<>();
        temp.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) >= temp.get(temp.size() - 1))
                temp.add(list.get(i));
            else {
                int ind = binarySearch(list.get(i), temp);
                temp.set(ind, list.get(i));
            }
        }
        return temp.size();
    }

    public int binarySearch(Integer x, List<Integer> list) {
        int l = 0, h = list.size() - 1, ans = -1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (list.get(mid) > x)
                l = mid + 1;
            else {
                ans = mid;
                h = mid - 1;
            }
        }
        return ans;
    }
}