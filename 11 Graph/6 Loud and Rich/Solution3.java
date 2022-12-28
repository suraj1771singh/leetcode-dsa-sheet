import java.util.*;
import java.lang.*;
import java.io.*;

class Solution3 {
    public static void main(String[] args) throws java.lang.Exception {
        testcase();
    }

    public static void testcase() {
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(r.readLine());
            while (t-- > 0) {
                int n = Integer.parseInt(r.readLine());
                String s[] = r.readLine().split(" ");

                /*------- For input array */
                int arr[] = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(s[i]);
                }

                /*------For input number*/
                // int a = Integer.parseInt(s[0]);
                // int b = Integer.parseInt(s[1]);
                // int c = Integer.parseInt(s[2]);

                f(n, arr);
            }

        } catch (Exception e) {
        }
    }

    public static void f(int n, int a[]) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : a)
            q.add(i);
        int prev = q.poll();
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (prev - 1 != 0)
                q.add(prev - 1);
            prev = curr;
        }
        System.out.println(prev);

    }
}