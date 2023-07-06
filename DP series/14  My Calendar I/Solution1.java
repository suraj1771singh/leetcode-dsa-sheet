import java.util.*;

class MyCalendar {
    TreeSet<int[]> set;

    public MyCalendar() {
        set = new TreeSet<int[]>((a, b) -> a[0] - b[0]);
    }

    public boolean book(int start, int end) {
        int[] book = new int[] { start, end };
        int[] floor = set.floor(book);
        int[] ceil = set.ceiling(book);
        if (floor != null && floor[1] > start)
            return false;
        if (ceil != null && ceil[0] < end)
            return false;
        set.add(book);
        return true;
    }
}
// Time complexity : O(n*logn)