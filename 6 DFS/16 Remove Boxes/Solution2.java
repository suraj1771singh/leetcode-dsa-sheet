
//------------PARTITION RECURSIVE SOLUTION
public class Solution2 {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        return f(0, n - 1, boxes);
    }

    public int f(int l, int r, int[] boxes) {
        int n = boxes.length;
        int prev = -1;
        int a = 0;
        int i = l;
        int maxi = 0;
        while (i <= r) {
            if (prev == -1 || boxes[prev] != boxes[i]) {
                prev = i;
                a = 0;
                while (i < n && boxes[prev] == boxes[i]) {
                    a++;
                    i++;
                }
                int cost = a * a + f(l, prev - 1, boxes) + f(i + 1, r, boxes);
                maxi = Math.max(cost, maxi);
                continue;
            }
            i++;
        }
        return maxi;

    }
}
